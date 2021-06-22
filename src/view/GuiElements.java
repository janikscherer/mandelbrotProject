package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiElements {
    private List<JButton> buttons;
    private List<JComboBox<String>> jComboBoxes;

    public GuiElements(){
        buttons = new ArrayList<>();
        jComboBoxes = new ArrayList<>();
    }

    public void addButton(JButton givenButton){
        buttons.add(givenButton);
    }


    public void addJComboBox(JComboBox<String> givenJComboBox){
        jComboBoxes.add(givenJComboBox);
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
