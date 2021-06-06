package view;

import javax.swing.*;
import java.awt.*;

public class Gui {
    JButton zoomInButton;

    public Gui(JPanel mandelbrotPanel){
        JFrame frame = new JFrame();
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        zoomInButton = new JButton("Zoom in");


        frame.getContentPane().add(mandelbrotPanel);
        frame.getContentPane().add(zoomInButton);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public JButton getZoomInButton(){
        return zoomInButton;
    }
}
