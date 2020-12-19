package pmonitoreo.cohabitante;


import javax.swing.*;
import java.awt.*;

public class TestRequestPanel extends JPanel {

  private JComponent NavTestRequestPanel;
  private JComponent ContendTestRequestPanel;
  private JComponent ActionsTestRequestPanel;




  public TestRequestPanel( ){
    initAllComponents();
    this.setVisible(true);
  }

  private void initAllComponents(){
    this.setLayout( new BorderLayout());
    initNavTestRequest();
    initContendTestRequest();
    initActionsTestRequest();
  }

  private void initNavTestRequest(){
    NavTestRequestPanel = new JPanel();
    NavTestRequestPanel.setLayout( new FlowLayout() );
    NavTestRequestPanel.setBackground(Color.GREEN);

    JButton goToBackButton = new JButton("Atras");
    JLabel title = new JLabel("Solicitud de Pruebas");

    NavTestRequestPanel.add(goToBackButton);
    NavTestRequestPanel.add(title);

    this.add(NavTestRequestPanel, BorderLayout.NORTH);
  }

  private void initContendTestRequest(){


  }

  private void initActionsTestRequest() {

  }


}
