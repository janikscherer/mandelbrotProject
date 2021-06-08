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
        sidePanel.setLayout(new GridLayout(0, 1));
        zoomInButton = new JButton("Zoom in");
        zoomOutButton = new JButton("Zoom out");
        moveRightButton = new JButton("Move right");
        moveLeftButton = new JButton("Move left");
        moveUpButton = new JButton("Move up");
        moveDownButton = new JButton("Move down");
        sidePanel.add(zoomInButton);
        sidePanel.add(zoomOutButton);
        sidePanel.add(moveRightButton);
        sidePanel.add(moveLeftButton);
        sidePanel.add(moveUpButton);
        sidePanel.add(moveDownButton);
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
