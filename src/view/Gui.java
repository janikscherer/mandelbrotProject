package view;

import javax.swing.*;
import java.awt.*;

public class Gui {
    JButton zoomInButton;
    JButton zoomOutButton;

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
        sidePanel.add(zoomInButton);
        sidePanel.add(zoomOutButton);
        return sidePanel;
    }

    public JButton getZoomInButton(){
        return zoomInButton;
    }
    public JButton getZoomOutButton(){
        return zoomOutButton;
    }
}
