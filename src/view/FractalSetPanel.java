package view;

import javax.swing.*;
import java.awt.*;

    public class FractalSetPanel extends JPanel {

        JComboBox<String> fractalSetBox;

        public FractalSetPanel(String[] comboBoxStringJuliaSet){
            setLayout(new GridLayout(0, 1));
            fractalSetBox = new JComboBox<>(comboBoxStringJuliaSet);
            fractalSetBox.setPreferredSize(new Dimension(240, 40));
            add(fractalSetBox);
        }

        public JComboBox<String> getFractalSetBox() {
            return fractalSetBox;
        }
}


