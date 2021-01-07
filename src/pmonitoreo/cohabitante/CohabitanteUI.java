package pmonitoreo.cohabitante;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pmonitoreo.backend.alertas.Alertas;
import pmonitoreo.backend.cohabitantes.Cohabitantes;

import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CohabitanteUI implements MovilCohabitante {

  Cohabitantes cohabitanteServer;
  private int ID;
  private String coName;
  private String status;

  private JFrame CohabitanteFrame;
  private JComponent NavCohabitante;

  private JComponent StatusPanel;
  private JComponent TestRequestPanel;

  private final List<String> dataList;
  private final Map<String, String> columsMap;
  private final List<String> columnsList;

  public CohabitanteUI(Cohabitantes cohabitanteServer, Alertas alerta){
    this.cohabitanteServer = cohabitanteServer;
    this.dataList = new LinkedList<>();
    this.columsMap = new HashMap<>();
    this.columnsList = new LinkedList<>();

    loadCohabitanteData();
    initCohabitante();
    updatingCohabitanteData();

  }

  private void updatingCohabitanteData(){

  }

  private void loadCohabitanteData(){
    String path = "src/pmonitoreo/cohabitante/mobil.conf";
    JSONObject object = JSONController.getJSONObjectFromFile(path);
    JSONObject userData = (JSONObject) object.get("userData");
//    System.out.println(data.toJSONString());
    this.ID = Integer.parseInt( (String) userData.get("id") );
    this.coName = (String) userData.get("name");
    this.status = (String) userData.get("status");

    processCondicionSanitariaData((JSONArray) object.get("condicionSanitaria"));
    parsingColumnsData();

    cohabitanteServer.validarUsuario(ID);
  }

  private void processCondicionSanitariaData(JSONArray condicionSanitaria){
    for (Object o : condicionSanitaria) {
      processRowData((String) o);
    }
  }

  private void processRowData( String rowData ){
    String[] rowDataArr = rowData.split(",");
    StringBuilder dataRow = new StringBuilder();
    this.columsMap.put( "Fecha", "Fecha"); // add Fecha colum for table
    for (int i = 0; i < rowDataArr.length ; i++) {
      if( i % 2 == 0 ){
        dataRow.append(rowDataArr[i]).append(",");
      }else{
        this.columsMap.put( rowDataArr[i], rowDataArr[i]); // add new colum name <key , key>
      }
    }
    this.dataList.add(dataRow.toString()); // add new data for table
  }

  private void parsingColumnsData (){
    Set<String> set = columsMap.keySet();
    columnsList.addAll(set);
  }

  public void initCohabitante() {
    this.CohabitanteFrame = new JFrame("Interfaz de CohabitanteUI");
    this.CohabitanteFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.CohabitanteFrame.setSize(375, 667);
//    this.CohabitanteFrame.setTitle("Interfaz de CohabitantesServer");
    this.CohabitanteFrame.setVisible(false);
    this.CohabitanteFrame.setLocationRelativeTo(null);

    this.StatusPanel = new CohabitanteStatus(ID, cohabitanteServer, columnsList, dataList);
    this.NavCohabitante = new NavCohabitante(this.coName, this.status);
    this.TestRequestPanel = new TestRequestPanel();

    this.CohabitanteFrame.add(NavCohabitante, BorderLayout.NORTH);
    this.CohabitanteFrame.add(StatusPanel, BorderLayout.CENTER);
//    this.CohabitantePanel.add(TestRequestPanel/*, BorderLayout.SOUTH*/);

    this.CohabitanteFrame.pack();
  }

  @Override
  public void show(){
    this.CohabitanteFrame.setVisible(true);
  }

  @Override
  public void onChangeStatus(){
    cohabitanteServer.obtenerCohabitante(this.ID);
  }


}
