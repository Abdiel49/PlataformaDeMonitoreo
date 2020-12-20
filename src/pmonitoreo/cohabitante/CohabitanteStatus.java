package pmonitoreo.cohabitante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CohabitanteStatus extends JPanel {

  private final String[] Columns;
  private final String[][] Data;

//  private JTable statusContend;
  private final DefaultTableModel tableModel;

  public CohabitanteStatus (String[] column, String[][] data) {
    this.Columns = column;
    this.Data = data;
    tableModel = new DefaultTableModel();
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
    for( String[] row : Data){
      tableModel.insertRow(tableModel.getRowCount(), row);
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
    addData( new String[]{
        getLocalDateTimeNow(),
        getTemperature()
    });
  }

  private String getTemperature(){
    double temp = ((Math.random() * 6 ) + 34);
    return String.format("%.1f", temp);
  }

  private String getLocalDateTimeNow(){
    String dateFormat = "dd-MM-yyyy HH:mm";
    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(dateFormat);
    LocalDateTime time = LocalDateTime.now();    return formatter.format(time);

  }

}
