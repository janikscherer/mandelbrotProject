package view;

import javax.swing.*;
import java.awt.*;

public class ColorSettingsPanel extends JPanel {
    public ColorSettingsPanel(){
        setLayout(new GridLayout(0, 1));
        add(new JComboBox<String>());
        add(createSliderPanel());
    }

    private JPanel createSliderPanel(){
        JPanel sliderPanel = new JPanel(new GridLayout(0, 1));
        JSlider colorValSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
        sliderPanel.add(colorValSlider);
        return sliderPanel;
    }
}