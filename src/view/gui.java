package view;

import javax.swing.*;
import java.awt.*;

public class gui {
    public gui(JPanel mandelbrotPanel){
        JFrame frame = new JFrame();
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        frame.getContentPane().add(mandelbrotPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
