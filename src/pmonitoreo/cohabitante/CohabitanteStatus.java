package pmonitoreo.cohabitante;

import pmonitoreo.backend.cohabitantes.Cohabitantes;
import pmonitoreo.backend.cohabitantes.CondicionSanitaria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class CohabitanteStatus extends JPanel {

  private final int ID;
  private List<String> Columns;
  private final List<String> Data;
  Cohabitantes cohabitanteServer;
//  private JTable statusContend;
  private final DefaultTableModel tableModel;

  public CohabitanteStatus (
      int id,
      Cohabitantes server,
      List<String> column,
      List<String> data) {

    this.ID = id;
    this.cohabitanteServer = server;
    this.Columns = column;
    this.Data = data;
    tableModel = new DefaultTableModel();
//    initColumns();
    initAllComponents();
  }

  private void initColumns(){
    Columns = new LinkedList<>();
    Columns.add("Fecha");
    Columns.add("Temperatura");

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
    for( String rowData : Data){
      String[] rowSplit = rowData.split(",");
      tableModel.insertRow(tableModel.getRowCount(), rowSplit);
    }
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

    cohabitanteServer.registrarCondicionSanitaria(ID, new CondicionSanitaria(time, "Temperatura", temp));

    String dateFormat = "dd-MM-yyyy HH:mm";

    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(dateFormat);

    addData( new String[]{
        formatter.format(time),
      temp
    });
  }

  private String getTemperature(){
    double temp = ((Math.random() * 6 ) + 34);
    return String.format("%.1f", temp);
  }

  private LocalDateTime getLocalDateTimeNow(){
    return LocalDateTime.now().withSecond(0).withNano(0);
  }

}
