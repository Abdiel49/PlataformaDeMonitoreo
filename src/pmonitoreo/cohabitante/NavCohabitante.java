package pmonitoreo.cohabitante;

import javax.swing.*;
import java.awt.*;

public class NavCohabitante extends JPanel {

  private final String  userName;
  private String status;

  public NavCohabitante(String user, String status){
    this.userName = user;
    this.status = status;
//    this.setPreferredSize( new Dimension( 375, 20));
    initComponentes();
  }

  private void initComponentes(){
    JComponent CoStatusNav = new JPanel();
    CoStatusNav.setLayout( new FlowLayout());
    this.setBackground(Color.GREEN);

    JLabel Title = new JLabel( this.userName );
    JLabel Status = new JLabel( this.status );

    CoStatusNav.add(Title);
    CoStatusNav.add(Status);

    this.add(CoStatusNav, BorderLayout.NORTH);
//    this.setVisible(true);
  }

  public void onStatusChange(String status){
    this.status = status;
  }
}
