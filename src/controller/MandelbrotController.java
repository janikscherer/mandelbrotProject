package controller;

import IO.DataStorage;
import model.ColorMode;
import model.MandelbrotSet;
import model.PositionAndSettings;
import view.ColorSettingsPanel;
import view.DataStoragePanel;
import view.MandelbrotGuiFrame;
import view.MoveButtonsPanel;

import javax.swing.*;

public class MandelbrotController {
    private int height = 1080;
    private int width = 1080;
    private MandelbrotSet myMandelbrot;
    private MandelbrotGuiFrame mandelbrotGuiFrame;
    private DataStorage dataStorage;
    DefaultListModel<String> listModel;

    public MandelbrotController() {
        myMandelbrot = new MandelbrotSet(height, width);
        listModel= new DefaultListModel<>();
        mandelbrotGuiFrame = new MandelbrotGuiFrame(myMandelbrot.createAndShowGUI(), ColorMode.allColorModes());
        dataStorage = new DataStorage();
        initializeElements();
    }

    private void initializeElements(){
        MoveButtonsPanel moveButtonsPanel = mandelbrotGuiFrame.getMoveButtonsPanel();
        moveButtonsPanel.getZoomInButton().addActionListener(x -> { myMandelbrot.decreaseScale(); });
        moveButtonsPanel.getZoomOutButton().addActionListener(x -> { myMandelbrot.increaseScale(); });
        moveButtonsPanel.getMoveUpButton().addActionListener(x -> { myMandelbrot.moveUp(); });
        moveButtonsPanel.getMoveLeftButton().addActionListener(x -> { myMandelbrot.moveLeft(); });
        moveButtonsPanel.getMoveRightButton().addActionListener(x -> { myMandelbrot.moveRight(); });
        moveButtonsPanel.getMoveDownButton().addActionListener(x -> { myMandelbrot.moveDown(); });

        ColorSettingsPanel myColorSettingsPanel = mandelbrotGuiFrame.getMyColorSettingsPanel();
        myColorSettingsPanel.getColorValSlider().addChangeListener(x -> { myMandelbrot.setColorOffset(myColorSettingsPanel.getColorValSlider().getValue());});
        JComboBox<String> colorModeJComboBox = myColorSettingsPanel.getColorModeBox();
        colorModeJComboBox.addActionListener(x -> {myMandelbrot.changeColorMode(colorModeJComboBox.getItemAt(colorModeJComboBox.getSelectedIndex()));});

        DataStoragePanel dataStoragePanel = mandelbrotGuiFrame.getDataStoragePanel();


        dataStoragePanel.getList().setModel(listModel);
        dataStoragePanel.getSaveButton().addActionListener(x -> {
            dataStorage.writePositionAndSettings(myMandelbrot.getPositionAndSettings());
            String nameForPositionAndSettings = JOptionPane.showInputDialog(mandelbrotGuiFrame,"Enter Name");
            listModel.addElement(nameForPositionAndSettings);
        });

        dataStoragePanel.getLoadButton().addActionListener(x ->{
            int index = dataStoragePanel.getList().getSelectedIndex();
            PositionAndSettings positionAndSettings = dataStorage.readPositionAndSettings(index);
            myMandelbrot.loadPositionAndSettings(positionAndSettings);
        });
    }
}
