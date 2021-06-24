package view;

import javax.swing.*;
import java.awt.*;

public class ChangeIterationsPanel {
    private JButton applyIterationsButton;
    private JTextField tfIterations;
    public ChangeIterationsPanel(){

    }
  public JPanel createIterationspanel(){
      JPanel changeIterationspanel = new JPanel();
      applyIterationsButton = new JButton("Apply");
      JLabel lbIterations = new JLabel(" Max Iterations: ");
      tfIterations = new JTextField();
      tfIterations.setPreferredSize(new Dimension(50,25));
      changeIterationspanel.add(lbIterations);
      changeIterationspanel.add(tfIterations);
      changeIterationspanel.add(applyIterationsButton);
      return changeIterationspanel;
  }
    public JTextField getTfIterations() {
        return tfIterations;
    }
    public JButton getApplyIterationsButton() {
        return applyIterationsButton;
    }
}
