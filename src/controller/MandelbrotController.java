package controller;

import IO.DataStorage;
import model.ColorMode;
import model.FractalSet;
import model.MandelbrotSet;
import model.PositionAndSettings;
import view.*;

import javax.swing.*;

public class MandelbrotController {
    private int height = 1000;
    private int width = 1000;
    private MandelbrotSet myMandelbrot;
    private MandelbrotGuiFrame mandelbrotGuiFrame;
    private DataStorage dataStorage;
    private DataStoragePanel dataStoragePanel;
    private ColorSettingsPanel colorSettingsPanel;
    private FractalSetPanel fractalSetPanel;
    DefaultListModel<String> listModel;

    public MandelbrotController() {
        myMandelbrot = new MandelbrotSet(height, width);
        listModel= new DefaultListModel<>();
        mandelbrotGuiFrame = new MandelbrotGuiFrame(myMandelbrot.createAndShowGUI(), ColorMode.allColorModes(), FractalSet.allJuliaSets());
        mandelbrotGuiFrame.getChangeIterationsPanel().getTfIterations().setText(myMandelbrot.getMaxIterations());
        dataStorage = new DataStorage();
        initializeElements();
        initializePositionAndSettingsEntries();
    }

    public int getInputTfIteration(){
        String maxIterationsString = mandelbrotGuiFrame.getChangeIterationsPanel().getTfIterations().getText();
        int maxIterationsInt = Integer.parseInt(maxIterationsString);
        return maxIterationsInt;
    }
    private void initializeElements(){
        initializeButtons();
        initializeColorSliderAndBox();

        dataStoragePanel = mandelbrotGuiFrame.getDataStoragePanel();
        dataStoragePanel.getList().setModel(listModel);

        fractalSetPanel = mandelbrotGuiFrame.getJuliaSetPanel();
        JComboBox<String> juliaSetJComboBox = fractalSetPanel.getJuliaSetBox();
        juliaSetJComboBox.addActionListener(x -> {myMandelbrot.changejuliaSet(juliaSetJComboBox.getItemAt(juliaSetJComboBox.getSelectedIndex()));});


        initializeSaveButton();
        initializeLoadButton();
    }

    private void initializeLoadButton() {
        dataStoragePanel.getLoadButton().addActionListener(x ->{
            int index = dataStoragePanel.getList().getSelectedIndex();
            PositionAndSettings positionAndSettings = dataStorage.readPositionAndSettings(index);
            myMandelbrot.loadPositionAndSettings(positionAndSettings);
            colorSettingsPanel.getColorValSlider().setValue(positionAndSettings.getMyColorOffset());
            colorSettingsPanel.getColorModeBox().setSelectedItem(positionAndSettings.getMyColorMode().toString());
            fractalSetPanel.getJuliaSetBox().setSelectedItem(positionAndSettings.getMyFractalSet().toString());
        });
    }

    private void initializeSaveButton() {
        dataStoragePanel.getSaveButton().addActionListener(x -> {
            String nameForPositionAndSettings = JOptionPane.showInputDialog(mandelbrotGuiFrame,"Enter Name");
            PositionAndSettings positionAndSettings = myMandelbrot.getPositionAndSettings();
            positionAndSettings.setName(nameForPositionAndSettings);
            dataStorage.writePositionAndSettings(positionAndSettings);
            listModel.addElement(nameForPositionAndSettings);
        });
    }

    private void initializeColorSliderAndBox() {
        colorSettingsPanel = mandelbrotGuiFrame.getMyColorSettingsPanel();
        colorSettingsPanel.getColorValSlider().addChangeListener(x -> { myMandelbrot.setColorOffset(colorSettingsPanel.getColorValSlider().getValue());});
        JComboBox<String> colorModeJComboBox = colorSettingsPanel.getColorModeBox();
        colorModeJComboBox.addActionListener(x -> {myMandelbrot.changeColorMode(colorModeJComboBox.getItemAt(colorModeJComboBox.getSelectedIndex()));});
    }

    private void initializeButtons() {
        MoveButtonsPanel moveButtonsPanel = mandelbrotGuiFrame.getMoveButtonsPanel();
        moveButtonsPanel.getZoomInButton().addActionListener(x -> { myMandelbrot.decreaseScale(); });
        moveButtonsPanel.getZoomOutButton().addActionListener(x -> { myMandelbrot.increaseScale(); });
        moveButtonsPanel.getMoveUpButton().addActionListener(x -> { myMandelbrot.moveUp(); });
        moveButtonsPanel.getMoveLeftButton().addActionListener(x -> { myMandelbrot.moveLeft(); });
        moveButtonsPanel.getMoveRightButton().addActionListener(x -> { myMandelbrot.moveRight(); });
        moveButtonsPanel.getMoveDownButton().addActionListener(x -> { myMandelbrot.moveDown(); });
        mandelbrotGuiFrame.getChangeIterationsPanel().getApplyIterationsButton().addActionListener(x -> { myMandelbrot.changeIterations(getInputTfIteration()); });
    }

    public void initializePositionAndSettingsEntries(){
        for(int line = 0; line < dataStorage.howManyLinesWritten(); line++){
            PositionAndSettings positionAndSettings = dataStorage.readPositionAndSettings(line);
            listModel.addElement(positionAndSettings.getName());
        }
    }
}
