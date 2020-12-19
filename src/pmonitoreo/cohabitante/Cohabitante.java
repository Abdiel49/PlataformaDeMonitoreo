package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Cohabitante extends JFrame implements UICohabitante {

  private int ID;
  private String coName;
  private String status;
  private String[] Column;
  private String[][] Data;

  private JComponent CohabitantePanel;
  private JComponent NavCohabitante;

  private JComponent StatusPanel;
  private JComponent TestRequestPanel;


  private Stack<JComponent> panelManger;

  public Cohabitante(){

    this.panelManger = new Stack<>();
    loadCohabitanteData();
    initCohabitante();

  }

  private void loadCohabitanteData(){
    this.ID = 1;
    this.coName = "Ibai";
    this.status = "Normal";
    this.Column = new String[]{"Fecha", "Temperatura"};
    this.Data = new String[][]{
        {"12-04-2020", "36.5"},
        {"13-04-2020", "37.2"},
        {"14-04-2020", "36.3"},
        {"15-04-2020", "38.6"}
    };
  }

  private void initCohabitante() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(375, 667);
    this.setTitle("Interfaz de Cohabitante");
    this.setVisible(true);
    this.setLocationRelativeTo(null);

    this.CohabitantePanel = new CohabitanteMainPanel();
    this.StatusPanel = new CohabitanteStatus(Column, Data);
    this.NavCohabitante = new NavCohabitante(this.coName, this.status);
    this.TestRequestPanel = new TestRequestPanel();


    this.CohabitantePanel.add(NavCohabitante, BorderLayout.NORTH);
    this.CohabitantePanel.add(StatusPanel, BorderLayout.CENTER);
    this.add(CohabitantePanel);
//      panelManger.push(CohabitantePanel);
    this.pack();
  }


  @Override
  public void reportarEstado( StatusType status ) {

  }

  @Override
  public void solicitarPrueba() {

  }
}
