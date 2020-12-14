package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;

public class CohabitanteStatus extends JPanel {

  private JComponent NavStatusCo;
  private JComponent ContendStatusCo;
  private JComponent ActionsStatusCo;
  private JComponent Cohabitante;

  public CohabitanteStatus (JComponent cohabitante) {
    this.Cohabitante = cohabitante;
    initAllComponents();
  }

  private void initAllComponents(){
    this.setLayout( new BorderLayout() );
    this.setPreferredSize( new Dimension(375, 500) );

    initNavStatus();
    initContendStatus();
    initActionStatus();

    this.setVisible(true);
  }

  private void initNavStatus() {
    NavStatusCo = new JPanel();
    NavStatusCo.setLayout( new FlowLayout() );
    NavStatusCo.setBackground( Color.green );
    JButton backButton = new JButton("Atras");
    JLabel title = new JLabel("MI ESTADO");
    backButton.addActionListener(e -> {
      this.setVisible(false);
    });
    NavStatusCo.add(backButton);
    NavStatusCo.add(title);

    this.add(NavStatusCo, BorderLayout.NORTH);
  }

  private void initContendStatus() {

  }

  private void initActionStatus() {
    this.ActionsStatusCo = new JPanel();
    ActionsStatusCo.setLayout( new FlowLayout());
    JButton reportButton = new JButton("Reportar");
    ActionsStatusCo.add(reportButton);

    this.add(ActionsStatusCo, BorderLayout.SOUTH);
  }


}
