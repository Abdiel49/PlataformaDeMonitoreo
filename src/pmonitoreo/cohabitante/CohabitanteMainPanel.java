package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;

public class CohabitanteMainPanel extends JPanel {

  private JComponent CoState;
  private JComponent CoHistory;
  private JComponent CoActions;

  private int ID;
  private String coName;

  public CohabitanteMainPanel () {

    this.setVisible(true);
    this.setLayout( new BorderLayout());

    initCoState();
    initCoHistory();
    initCoActions();

  }
  private void initCoState(){
    CoState = new JPanel();
    CoState.setLayout( new FlowLayout());
    CoState.setBackground( Color.green);
    JLabel userName = new JLabel(this.coName);
    JButton userState = new JButton("_user-state_");
    CoState.add( userName );
    CoState.add( userState );
//    this.add(CoState, BorderLayout.NORTH);
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

    JButton requestTest = new JButton("Solicitar Prueba");
    JButton report = new JButton("Reportar");
    CoActions.add(requestTest);
    CoActions.add(report);

//    this.add( CoActions, BorderLayout.SOUTH);
  }

}
