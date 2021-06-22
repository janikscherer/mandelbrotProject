package view;

import javax.swing.*;
import java.awt.*;

public class ColorSettingsPanel extends JPanel {
    JComboBox<String> colorModeBox;
    JSlider colorValSlider;
    public ColorSettingsPanel( String[] comboBoxString){
        setLayout(new GridLayout(0, 1));
        colorModeBox = new JComboBox<>(comboBoxString);
        add(colorModeBox);
        add(createSliderPanel());
    }

    private JPanel createSliderPanel(){
        JPanel sliderPanel = new JPanel(new GridLayout(0, 1));
        sliderPanel.add(new JLabel("Color Offset"));
        colorValSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        sliderPanel.add(colorValSlider);
        return sliderPanel;
    }

    public JComboBox<String> getColorModeBox() {
        return colorModeBox;
    }

    public JSlider getColorValSlider() {
        return colorValSlider;
    }


}