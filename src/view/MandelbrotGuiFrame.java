package view;

import javax.swing.*;
import java.awt.*;

public class MandelbrotGuiFrame extends JFrame{
    private ColorSettingsPanel myColorSettingsPanel;
    private DataStoragePanel dataStoragePanel;
    private MoveButtonsPanel moveButtonsPanel;
    private view.FractalSetPanel fractalSetPanel;
    private ChangeIterationsPanel changeIterationsPanel;

    public MandelbrotGuiFrame(JPanel mandelbrotPanel, String[] comboBoxStringColor,String[] comboBoxStringJuliaSet){
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.add(mandelbrotPanel);
        GridBagConstraints myGBC = new GridBagConstraints();
        myGBC.gridy = 1;
        this.add(createSidePanel(comboBoxStringColor,comboBoxStringJuliaSet));

        pack();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private JPanel createSidePanel(String[] comboBoxStringColor,String[] comboBoxStringFractalSet){
        JPanel sidePanel = new JPanel();
        JPanel comboboxPanel = new JPanel();

        sidePanel.setLayout(new BorderLayout());

        sidePanel.add(moveButtonsPanel = new MoveButtonsPanel(), BorderLayout.CENTER);
        myColorSettingsPanel = new ColorSettingsPanel(comboBoxStringColor);
        fractalSetPanel = new FractalSetPanel(comboBoxStringFractalSet);
        comboboxPanel.add(myColorSettingsPanel);
        comboboxPanel.add(fractalSetPanel);
        comboboxPanel.setLayout(new GridLayout(2,0));
        sidePanel.add(comboboxPanel,BorderLayout.NORTH);

        changeIterationsPanel = new ChangeIterationsPanel();
        sidePanel.add(changeIterationsPanel.createIterationspanel(),BorderLayout.EAST);


        dataStoragePanel = new DataStoragePanel();
        sidePanel.add(dataStoragePanel, BorderLayout.PAGE_END);

        return sidePanel;
    }


    public ColorSettingsPanel getMyColorSettingsPanel() {
        return myColorSettingsPanel;
    }

    public DataStoragePanel getDataStoragePanel() {
        return dataStoragePanel;
    }

    public MoveButtonsPanel getMoveButtonsPanel(){
        return moveButtonsPanel;
    }
    public view.FractalSetPanel getJuliaSetPanel(){
        return fractalSetPanel;
    }

    public ChangeIterationsPanel getChangeIterationsPanel() {
        return changeIterationsPanel;
    }
}
