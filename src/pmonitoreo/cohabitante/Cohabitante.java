package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Cohabitante extends JFrame implements UICohabitante {

  private int ID;
  private String coName;

  private JComponent CohabitantePanel;
  private JComponent ActionsStatusCo;
  private JComponent ReportStatusPanel;
  private JComponent TestRequestPanel;


  private Stack<JComponent> panelManger;

  public Cohabitante(){

    this.panelManger = new Stack<>();
    getCohabitanteInfo();
    initCohabitante();

  }

  private void getCohabitanteInfo(){
    this.ID = 12;
    this.coName = "Ibai";
  }

  private void initCohabitante() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(375, 667);
    this.setTitle("Interfaz de Cohabitante");
    this.setVisible(true);
    this.setLocationRelativeTo(null);

    this.CohabitantePanel = new CohabitanteMainPanel(this);
    this.ReportStatusPanel = new ReportStatusPanel(this);
    this.TestRequestPanel = new TestRequestPanel(this);

    this.add(CohabitantePanel);
//    onPush(CohabitantePanel);
      panelManger.push(CohabitantePanel);
//    initActionStatus();

    this.pack();
  }

  private void initActionStatus() {
    this.ActionsStatusCo = new JPanel();
    ActionsStatusCo.setLayout( new FlowLayout());
    JButton mainButton = new JButton("Ir a Main");
    mainButton.addActionListener(e -> {
      if(!this.CohabitantePanel.isVisible()){
        this.ReportStatusPanel.setVisible(false);
        this.CohabitantePanel.setVisible(true);
      }
    });
    ActionsStatusCo.add(mainButton);

    JButton reportButton = new JButton("Ir a Reportar");
    reportButton.addActionListener(e -> {
//      if( !this.ReportStatusPanel.isVisible() ){
        CohabitantePanel.setVisible(false);
        CohabitantePanel.setEnabled(false);
        this.add(ReportStatusPanel);
        ReportStatusPanel.setVisible(true);
        ReportStatusPanel.setEnabled(true);

//      }
    });
    ActionsStatusCo.add(reportButton);

    this.add(ActionsStatusCo, BorderLayout.SOUTH);
  }

  @Override
  public void onBack() {
    if( !panelManger.empty()){
      panelManger.peek().setEnabled(false);
      panelManger.pop().setVisible(false);
      panelManger.peek().setVisible(true);
      this.getContentPane().add(panelManger.peek());
    }
  }

  @Override
  public void onPush(JComponent component) {
    if( !panelManger.empty() ){
      panelManger.peek().setVisible(false);
//      panelManger.peek().setEnabled(false);
    }
    this.add(component);
    panelManger.push(component);
  }
}
