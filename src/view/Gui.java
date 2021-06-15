package view;

import javax.swing.*;
import java.awt.*;

public class Gui {
    JButton zoomInButton;
    JButton zoomOutButton;
    JButton moveRightButton;
    JButton moveLeftButton;
    JButton moveUpButton;
    JButton moveDownButton;

    public Gui(JPanel mandelbrotPanel){
        JFrame frame = new JFrame();
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());

        frame.getContentPane().add(mandelbrotPanel);
        GridBagConstraints myGBC = new GridBagConstraints();
        myGBC.gridy = 1;
        frame.getContentPane().add(createSidePanel());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JPanel createSidePanel(){
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(createMoveButtonsPanel(), BorderLayout.CENTER);
        return sidePanel;
    }

    private JPanel createMoveButtonsPanel(){
        JPanel moveButtonsPanel = new JPanel();
        moveButtonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints myGBC = new GridBagConstraints();

        zoomInButton = new JButton("Zoom in");
        zoomInButton.setPreferredSize(new Dimension(120,40));
        zoomOutButton = new JButton("Zoom out");
        zoomOutButton.setPreferredSize(new Dimension(120,40));
        moveUpButton = new JButton("Move up");
        moveUpButton.setPreferredSize(new Dimension(120,20));
        moveRightButton = new JButton("Move right");
        moveRightButton.setPreferredSize(new Dimension(120,20));
        moveLeftButton = new JButton("Move left");
        moveLeftButton.setPreferredSize(new Dimension(120,20));
        moveDownButton = new JButton("Move down");
        moveDownButton.setPreferredSize(new Dimension(120,20));

        myGBC.ipady = 25;
        myGBC.gridx = 1;
        myGBC.gridy = 0;
        moveButtonsPanel.add(zoomInButton, myGBC);
        myGBC.gridy++;
        moveButtonsPanel.add(zoomOutButton, myGBC);

        myGBC.insets = new Insets(25, 0,0,0);
        myGBC.gridy++;
        myGBC.ipady = myGBC.ipady*2;
        moveButtonsPanel.add(moveUpButton, myGBC);
        myGBC.insets = new Insets(0, 0,0,0);

        myGBC.gridy++;
        myGBC.gridx = 2;
        moveButtonsPanel.add(moveRightButton, myGBC);
        myGBC.gridx = 0;
        moveButtonsPanel.add(moveLeftButton, myGBC);
        myGBC.gridy++;
        myGBC.gridx = 1;
        moveButtonsPanel.add(moveDownButton, myGBC);
        return moveButtonsPanel;
    }

    public JButton getZoomInButton(){
        return zoomInButton;
    }
    public JButton getZoomOutButton(){
        return zoomOutButton; }

    public JButton getMoveLeftButton() {
        return moveLeftButton;
    }

    public JButton getMoveUpButton() {
        return moveUpButton;
    }

    public JButton getMoveDownButton() {
        return moveDownButton;
    }

    public JButton getMoveRightButton() {
        return moveRightButton;
    }
}
