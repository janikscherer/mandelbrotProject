package view;

import javax.swing.*;
import java.awt.*;

    public class FractalSetPanel extends JPanel {

        JComboBox<String> juliaSetBox;

        public FractalSetPanel(String[] comboBoxStringJuliaSet){
            setLayout(new GridLayout(0, 1));
            juliaSetBox = new JComboBox<>(comboBoxStringJuliaSet);
            add(juliaSetBox);
            juliaSetBox.setPreferredSize(new Dimension(200,20));


        }





        public JComboBox<String> getJuliaSetBox() {
            return juliaSetBox;
        }
    }


