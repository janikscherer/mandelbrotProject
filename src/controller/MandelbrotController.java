package controller;

import IO.DataStorage;
import model.ColorMode;
import model.FractalSet;
import model.MandelbrotSet;
import model.PositionAndSettings;
import view.ColorSettingsPanel;
import view.DataStoragePanel;
import view.MandelbrotGuiFrame;
import view.MoveButtonsPanel;

import javax.swing.*;

public class MandelbrotController {
    private int height = 1000;
    private int width = 1000;
    private MandelbrotSet myMandelbrot;
    private MandelbrotGuiFrame mandelbrotGuiFrame;
    private DataStorage dataStorage;
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
        String maxiterationsString = mandelbrotGuiFrame.getChangeIterationsPanel().getTfIterations().getText();
        int maxiterationsInt = Integer.parseInt(maxiterationsString);
        return maxiterationsInt;
    }
    private void initializeElements(){
        MoveButtonsPanel moveButtonsPanel = mandelbrotGuiFrame.getMoveButtonsPanel();
        moveButtonsPanel.getZoomInButton().addActionListener(x -> { myMandelbrot.decreaseScale(); });
        moveButtonsPanel.getZoomOutButton().addActionListener(x -> { myMandelbrot.increaseScale(); });
        moveButtonsPanel.getMoveUpButton().addActionListener(x -> { myMandelbrot.moveUp(); });
        moveButtonsPanel.getMoveLeftButton().addActionListener(x -> { myMandelbrot.moveLeft(); });
        moveButtonsPanel.getMoveRightButton().addActionListener(x -> { myMandelbrot.moveRight(); });
        moveButtonsPanel.getMoveDownButton().addActionListener(x -> { myMandelbrot.moveDown(); });
        mandelbrotGuiFrame.getChangeIterationsPanel().getApplyIterationsButton().addActionListener(x -> { myMandelbrot.changeIterations(getInputTfIteration()); });

        ColorSettingsPanel myColorSettingsPanel = mandelbrotGuiFrame.getMyColorSettingsPanel();
        myColorSettingsPanel.getColorValSlider().addChangeListener(x -> { myMandelbrot.setColorOffset(myColorSettingsPanel.getColorValSlider().getValue());});
        JComboBox<String> colorModeJComboBox = myColorSettingsPanel.getColorModeBox();
        colorModeJComboBox.addActionListener(x -> {myMandelbrot.changeColorMode(colorModeJComboBox.getItemAt(colorModeJComboBox.getSelectedIndex()));});

        DataStoragePanel dataStoragePanel = mandelbrotGuiFrame.getDataStoragePanel();
        dataStoragePanel.getList().setModel(listModel);
        JComboBox<String> juliaSetJComboBox = mandelbrotGuiFrame.getJuliaSetPanel().getJuliaSetBox();
        juliaSetJComboBox.addActionListener(x -> {myMandelbrot.changejuliaSet(juliaSetJComboBox.getItemAt(juliaSetJComboBox.getSelectedIndex()));});

        // save button initialization
        dataStoragePanel.getSaveButton().addActionListener(x -> {
            String nameForPositionAndSettings = JOptionPane.showInputDialog(mandelbrotGuiFrame,"Enter Name");
            PositionAndSettings positionAndSettings = myMandelbrot.getPositionAndSettings();
            positionAndSettings.setName(nameForPositionAndSettings);
            dataStorage.writePositionAndSettings(positionAndSettings);
            listModel.addElement(nameForPositionAndSettings);
        });

        // load button initialization
        dataStoragePanel.getLoadButton().addActionListener(x ->{
            int index = dataStoragePanel.getList().getSelectedIndex();
            PositionAndSettings positionAndSettings = dataStorage.readPositionAndSettings(index);
            myMandelbrot.loadPositionAndSettings(positionAndSettings);
        });
    }
    public void initializePositionAndSettingsEntries(){
        for(int line = 0; line < dataStorage.howManyLinesWritten(); line++){
            PositionAndSettings positionAndSettings = dataStorage.readPositionAndSettings(line);
            listModel.addElement(positionAndSettings.getName());
        }
    }
}
