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
        sidePanel.setLayout(new GridBagLayout());
        GridBagConstraints myGBC = new GridBagConstraints();

        zoomInButton = new JButton("Zoom in");
        zoomOutButton = new JButton("Zoom out");
        moveUpButton = new JButton("Move up");
        moveRightButton = new JButton("Move right");
        moveLeftButton = new JButton("Move left");
        moveDownButton = new JButton("Move down");


        myGBC.ipady = 25;
        myGBC.gridx = 1;
        myGBC.gridy = 0;
        sidePanel.add(zoomInButton, myGBC);
        myGBC.gridy++;
        sidePanel.add(zoomOutButton, myGBC);

        myGBC.insets = new Insets(25, 0,0,0);
        myGBC.gridy++;
        myGBC.ipady = myGBC.ipady*2;
        sidePanel.add(moveUpButton, myGBC);
        myGBC.insets = new Insets(0, 0,0,0);

        myGBC.gridy++;
        myGBC.gridx = 2;
        sidePanel.add(moveRightButton, myGBC);
        myGBC.gridx = 0;
        sidePanel.add(moveLeftButton, myGBC);
        myGBC.gridy++;
        myGBC.gridx = 1;
        sidePanel.add(moveDownButton, myGBC);
        return sidePanel;
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
