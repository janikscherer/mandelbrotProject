package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GuiElements {
    private List<JSlider> sliders;
    private List<JButton> buttons;

    public GuiElements(){
        buttons = new ArrayList<>();
        sliders = new ArrayList<>();
    }

    public void addButton(JButton givenButton){
        buttons.add(givenButton);
    }

    public void addSlider(JSlider givenSlider){
        sliders.add(givenSlider);
    }
    public List<JSlider> getSliders() {
        return sliders;
    }

    /**
     * Returns all the buttons.
     * @return List<JButton> buttons in this order: zoomIn, zoomOut, moveUp, moveLeft, moveRight, moveDown
     */
    public List<JButton> getButtons() {
        return buttons;
    }
}
