package pmonitoreo.cohabitante;


import javax.swing.*;
import java.awt.*;

public class TestRequestPanel extends JPanel {

  private JComponent NavTestRequestPanel;
  private JComponent ContendTestRequestPanel;
  private JComponent ActionsTestRequestPanel;

  private PanelManager panelManager;
//  private CSVReader = new CSVReader();

  public TestRequestPanel( PanelManager pManager ){

    this.panelManager = pManager;
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

    goToBackButton.addActionListener( e -> {
      panelManager.onBack();
    });
    NavTestRequestPanel.add(goToBackButton);
    NavTestRequestPanel.add(title);

    this.add(NavTestRequestPanel, BorderLayout.NORTH);
  }

  private void initContendTestRequest(){


  }

  private void initActionsTestRequest() {

  }


}
