package view;

import javax.swing.*;
import java.awt.*;

public class ColorSettingsPanel extends JPanel {
    GuiElements currentElements;
    public ColorSettingsPanel(GuiElements currentElements, String[] comboBoxString){
        this.currentElements = currentElements;
        setLayout(new GridLayout(0, 1));
        JComboBox<String> colorModeBox = new JComboBox<>(comboBoxString);
        currentElements.addJComboBox(colorModeBox);
        add(colorModeBox);
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