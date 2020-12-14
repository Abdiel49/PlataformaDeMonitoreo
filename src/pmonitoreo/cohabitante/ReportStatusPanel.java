package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;

public class ReportStatusPanel extends JPanel {

  private JComponent NavStateReport;
  private JComponent ContendStateReport;
  private JComponent ActionsStateReport;

  private PanelManager panelManager;

  public ReportStatusPanel(PanelManager  pManager ){
    this.panelManager = pManager;
    initAllComponents();
  }

  private void initAllComponents(){
    this.setLayout( new BorderLayout() );
    this.setPreferredSize( new Dimension(375, 500) );

    initNavStateReport();
    initContendStateReport();
    initActionsStateReport();

    this.setVisible(true);
  }

  private void initNavStateReport(){
    NavStateReport = new JPanel();
    NavStateReport.setLayout( new FlowLayout() );
    NavStateReport.setBackground( Color.green );
    JButton backButton = new JButton("Atras");
    JLabel title = new JLabel("REPORTAR MI ESTADO");

    backButton.addActionListener(e -> {
      panelManager.onBack();
    });

    NavStateReport.add(backButton);
    NavStateReport.add(title);

    this.add(NavStateReport, BorderLayout.NORTH);
  }

  private void initContendStateReport() {
    this.ContendStateReport = new JPanel();
    JPanel TempBox = new JPanel();
    TempBox.setLayout( new FlowLayout());

    JLabel tempLabel = new JLabel("Temperatura");
    JTextField tempInput = new JTextField(12);

    TempBox.add(tempLabel);
    TempBox.add(tempInput);

    ContendStateReport.add(TempBox);
    this.add(ContendStateReport, BorderLayout.CENTER);
  }

  private void initActionsStateReport() {
    this.ActionsStateReport = new JPanel();
    ActionsStateReport.setLayout( new FlowLayout());
    JButton reportButton = new JButton("Reportar");
    ActionsStateReport.add(reportButton);

    this.add(ActionsStateReport, BorderLayout.SOUTH);
  }

}
