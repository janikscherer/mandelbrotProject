package controller;

import model.ColorMode;
import model.MandelbrotSet;
import view.ColorSettingsPanel;
import view.MandelbrotGuiFrame;
import view.GuiElements;

import javax.swing.*;

public class MandelbrotController {
    private int height = 1080;
    private int width = 1080;
    private GuiElements myGuiElements;
    private MandelbrotSet myMandelbrot;
    private MandelbrotGuiFrame myMandelbrotGuiFrame;

    public MandelbrotController() {
        myMandelbrot = new MandelbrotSet(height, width);
        //Ziel: Gui Strings für Combobox übergeben
        myMandelbrotGuiFrame = new MandelbrotGuiFrame(myMandelbrot.createAndShowGUI(), ColorMode.allColorModes());
        myGuiElements = myMandelbrotGuiFrame.getGuiElements();
        initializeElements();
    }


    private void initializeElements(){
        myGuiElements.getButtons().get(0).addActionListener(x -> { myMandelbrot.decreaseScale(); });
        myGuiElements.getButtons().get(1).addActionListener(x -> { myMandelbrot.increaseScale(); });
        myGuiElements.getButtons().get(2).addActionListener(x -> { myMandelbrot.moveUp(); });
        myGuiElements.getButtons().get(3).addActionListener(x -> { myMandelbrot.moveLeft(); });
        myGuiElements.getButtons().get(4).addActionListener(x -> { myMandelbrot.moveRight(); });
        myGuiElements.getButtons().get(5).addActionListener(x -> { myMandelbrot.moveDown(); });
        ColorSettingsPanel myColorSettingsPanel = myMandelbrotGuiFrame.getMyColorSettingsPanel();
        myColorSettingsPanel.getColorValSlider().addChangeListener(x -> { myMandelbrot.setColorOffset(myColorSettingsPanel.getColorValSlider().getValue());});
        JComboBox<String> colorModeJComboBox = myGuiElements.getjComboBoxes().get(0);
        colorModeJComboBox.addActionListener(x -> {myMandelbrot.changeColorMode(colorModeJComboBox.getItemAt(colorModeJComboBox.getSelectedIndex()));});
    }
}
