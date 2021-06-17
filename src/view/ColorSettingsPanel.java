package view;

import javax.swing.*;
import java.awt.*;

public class ColorSettingsPanel extends JPanel {
    GuiElements currentElements;
    public ColorSettingsPanel(GuiElements currentElements){
        this.currentElements = currentElements;
        setLayout(new GridLayout(0, 1));
        add(new JComboBox<String>());
        add(createSliderPanel());
    }

    private JPanel createSliderPanel(){
        JPanel sliderPanel = new JPanel(new GridLayout(0, 1));
        sliderPanel.add(new JLabel("Color Offset"));
        JSlider colorValSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        currentElements.addSlider(colorValSlider);
        sliderPanel.add(colorValSlider);
        return sliderPanel;
    }
}