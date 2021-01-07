package pmonitoreo.cohabitante;

import pmonitoreo.backend.cohabitantes.Cohabitantes;
import pmonitoreo.backend.cohabitantes.CondicionSanitaria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CohabitanteStatus extends JPanel {

  private final int ID;
  private final String DATE_FORMAT;
  private final List<String> Columns;
  private final List<String> Data;
  private final Cohabitantes cohabitanteServer;
  private final DefaultTableModel tableModel;

  public CohabitanteStatus (
      int id,
      Cohabitantes server,
      List<String> column,
      List<String> data) {

    this.ID = id;
    this.DATE_FORMAT = "dd-MM-yyyy HH:mm";
    this.cohabitanteServer = server;
    this.Columns = column;
    this.Data = data;
    tableModel = new DefaultTableModel();
//    initColumns();
    initAllComponents();
  }

  private void initAllComponents(){
    this.setLayout( new BorderLayout() );
    this.setPreferredSize( new Dimension(375, 500) );

    initContendStatus();
    initActionStatus();

    this.setVisible(true);
  }

  private void initContendStatus() {
    JLabel title = new JLabel("Mis ultimas temperaturas:");
    JTable statusTable = new JTable(tableModel);
    statusTable.setEnabled(false);
    JScrollPane scrollPane = new JScrollPane(statusTable);
    loadColumns();
    loadData();
    this.add(title, BorderLayout.NORTH);
    this.add(scrollPane, BorderLayout.CENTER);
  }

  private void loadColumns(){
    for(String nameColumn : Columns) {
      tableModel.addColumn(nameColumn);
    }
  }

  private void loadData(){
    long LAST_FEW_DAYS = 6;
    for( String rowData : Data){
      String[] rowSplit = rowData.split(",");
      if( validateLatestHealthConditionRecords(rowSplit[0], LAST_FEW_DAYS) ){
        tableModel.insertRow(tableModel.getRowCount(), rowSplit);
      }
    }
  }

  private boolean validateLatestHealthConditionRecords(String date, long LAST_FEW_DAYS){
    boolean resp = false;
    LocalDateTime dateNow = getLocalDateTimeNow();
    LocalDateTime lastFewDays = dateNow.minusDays(LAST_FEW_DAYS);
    LocalDateTime dateToBeEvaluated = stringToLocalDateTime(date);
    if( dateToBeEvaluated.isAfter(lastFewDays) ){
      resp = true;
    }
    return resp;
  }

  private void addData(String[] newData){
    this.tableModel.insertRow(0, newData);
  }

  private void initActionStatus() {
    JComponent ActionsStatusCo = new JPanel();
    JButton reportButton = new JButton("Reportar mi estado actual");
    reportButton.addActionListener( e -> addReport());
    ActionsStatusCo.add(reportButton);
    this.add(ActionsStatusCo, BorderLayout.SOUTH);
  }

  private void addReport(){
    LocalDateTime time = getLocalDateTimeNow();
    String temp = getTemperature();
    String dateTimeFormat = getDateTimeFormater(time);
    cohabitanteServer.registrarCondicionSanitaria(ID, new CondicionSanitaria(time, "Temperatura", temp));

    addData( new String[]{
        dateTimeFormat,
        temp
    });
  }

  private String getDateTimeFormater(LocalDateTime dateTime){
    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(DATE_FORMAT);
    return formatter.format(dateTime);
  }

  private String getTemperature(){
    double temp = ((Math.random() * 6 ) + 34);
    return String.format("%.1f", temp);
  }

  private LocalDateTime getLocalDateTimeNow(){
    return LocalDateTime.now().withSecond(0).withNano(0);
  }

  private LocalDateTime stringToLocalDateTime(String dateTime){
    return LocalDateTime.parse(dateTime);
  }

}
