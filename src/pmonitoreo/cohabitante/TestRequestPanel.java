package pmonitoreo.cohabitante;


import javax.swing.*;
import java.awt.*;

public class TestRequestPanel extends JPanel {

  public TestRequestPanel( ){
    this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS));
    initContendTestRequest();
    initActionsTestRequest();
    this.setVisible(true);
  }

  private void initContendTestRequest(){
    JComponent ContendTestRequestPanel = new JPanel();
    JComponent textInput = new JTextPane();
    textInput.setMinimumSize( new Dimension(375,120));
    textInput.setVisible(true);
    JCheckBox checkBox = new JCheckBox("Aniadir informacion", false);
    checkBox.addItemListener( i -> {
      textInput.setVisible(checkBox.isSelected());
      this.updateUI();
    } );
    ContendTestRequestPanel.add(textInput);
    ContendTestRequestPanel.add(checkBox);
    this.add(ContendTestRequestPanel);
  }

  private void initActionsTestRequest() {

  }


}
