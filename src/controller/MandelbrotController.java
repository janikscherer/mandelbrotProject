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
        myMandelbrotGuiFrame.getZoomInButton().addActionListener(x -> { myMandelbrot.decreaseScale(); });
        myMandelbrotGuiFrame.getZoomOutButton().addActionListener(x -> { myMandelbrot.increaseScale(); });
        myMandelbrotGuiFrame.getMoveUpButton().addActionListener(x -> { myMandelbrot.moveUp(); });
        myMandelbrotGuiFrame.getMoveLeftButton().addActionListener(x -> { myMandelbrot.moveLeft(); });
        myMandelbrotGuiFrame.getMoveRightButton().addActionListener(x -> { myMandelbrot.moveRight(); });
        myMandelbrotGuiFrame.getMoveDownButton().addActionListener(x -> { myMandelbrot.moveDown(); });

        ColorSettingsPanel myColorSettingsPanel = myMandelbrotGuiFrame.getMyColorSettingsPanel();
        myColorSettingsPanel.getColorValSlider().addChangeListener(x -> { myMandelbrot.setColorOffset(myColorSettingsPanel.getColorValSlider().getValue());});
        JComboBox<String> colorModeJComboBox = myGuiElements.getjComboBoxes().get(0);
        colorModeJComboBox.addActionListener(x -> {myMandelbrot.changeColorMode(colorModeJComboBox.getItemAt(colorModeJComboBox.getSelectedIndex()));});
    }
}
