package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;

public class Cohabitante extends JFrame {

  private JPanel CoState;
  private JPanel CoHistory;
  private JPanel CoActions;

  private int ID;
  private String coName;


  public Cohabitante(){
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

    initCoState();
    initCoHistory();
    initCoActions();

    this.pack();
  }

  private void initCoState(){
    CoState = new JPanel();
    CoState.setLayout( new FlowLayout());
    CoState.setBackground( Color.red);
    JLabel userName = new JLabel(this.coName);
    JButton userState = new JButton("_user-state_");
    CoState.add( userName );
    CoState.add( userState );
    this.add(CoState, BorderLayout.NORTH);
  }

  private void initCoHistory(){
    CoHistory = new JPanel();
    CoHistory.setPreferredSize( new Dimension(375, 500) );
    //CoHistory.setLayout( new ScrollPaneLayout() );
    JLabel historyTitle = new JLabel("History");
    JLabel Contend = new JLabel("_table heald user history last 5 days_");

    CoHistory.add(historyTitle);
    CoHistory.add(Contend);

    this.add( CoHistory, BorderLayout.CENTER);
  }

  private void initCoActions(){
    CoActions = new JPanel();
    CoActions.setLayout( new FlowLayout() );

    JButton requestTest = new JButton("Solicitar Prueba");
    JButton report = new JButton("Reportar");

    CoActions.add(requestTest);
    CoActions.add(report);

    this.add( CoActions, BorderLayout.SOUTH);
  }

}
