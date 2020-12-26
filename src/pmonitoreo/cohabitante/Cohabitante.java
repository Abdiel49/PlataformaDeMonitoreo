package pmonitoreo.cohabitante;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

public class Cohabitante implements CohabitanteUI {

  private int ID;
  private String coName;
  private String status;
  private String[] Column;
  private String[][] Data;

  private JFrame CohabitanteFrame;
  private JComponent NavCohabitante;

  private JComponent StatusPanel;
  private JComponent TestRequestPanel;

  public Cohabitante(){
    loadCohabitanteData();
    initCohabitante();

  }

  private void loadCohabitanteData(){
    String path = "src/pmonitoreo/cohabitante/mobil.conf";
    JSONObject object = JSONController.getJSONObjectFromFile(path);
    JSONObject data = (JSONObject) object.get("userData");
//    System.out.println(data.toJSONString());
    this.ID = Integer.parseInt( (String) data.get("id") );
    this.coName = (String) data.get("name");
    this.status = (String) data.get("status");
    this.Column = new String[]{"Fecha", "Temperatura"};
    this.Data = new String[][]{
        {"12-04-2020 08:26", "36.5"},
        {"13-04-2020 08:15", "37.2"},
        {"14-04-2020 08:35", "36.3"},
        {"15-04-2020 08:12", "38.6"}
    };
  }

  public void initCohabitante() {
    this.CohabitanteFrame = new JFrame("Interfaz de Cohabitante");
    this.CohabitanteFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.CohabitanteFrame.setSize(375, 667);
    this.CohabitanteFrame.setTitle("Interfaz de CohabitanteServer");
    this.CohabitanteFrame.setVisible(false);
    this.CohabitanteFrame.setLocationRelativeTo(null);

    this.StatusPanel = new CohabitanteStatus(Column, Data);
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
  public void reportarEstado( StatusType status ) {

  }

  @Override
  public void solicitarPrueba() {

  }
}
