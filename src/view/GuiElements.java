package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiElements {
    private HashMap<String, JSlider> sliders;
    private List<JButton> buttons;
    private List<JComboBox<String>> jComboBoxes;

    public GuiElements(){
        buttons = new ArrayList<>();
        sliders = new HashMap<>();
        jComboBoxes = new ArrayList<>();
    }

    public void addButton(JButton givenButton){
        buttons.add(givenButton);
    }

    public void addSlider(String sliderName, JSlider givenSlider){
        sliders.put(sliderName, givenSlider);
    }

    public void addJComboBox(JComboBox<String> givenJComboBox){
        jComboBoxes.add(givenJComboBox);
    }
    public JSlider getSlider(String sliderName) {
        return sliders.get(sliderName);
    }

    /**
     * Returns all the buttons.
     * @return List<JButton> buttons in this order: zoomIn, zoomOut, moveUp, moveLeft, moveRight, moveDown
     */
    public List<JButton> getButtons() {
        return buttons;
    }

    public List<JComboBox<String>> getjComboBoxes() {
        return jComboBoxes;
    }
}
