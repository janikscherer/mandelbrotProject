package view;

import javax.swing.*;
import java.awt.*;

public class MandelbrotGuiFrame extends JFrame{
    private ColorSettingsPanel myColorSettingsPanel;
    private DataStoragePanel dataStoragePanel;
    private MoveButtonsPanel moveButtonsPanel;

    public MandelbrotGuiFrame(JPanel mandelbrotPanel, String[] comboBoxString){
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.add(mandelbrotPanel);
        GridBagConstraints myGBC = new GridBagConstraints();
        myGBC.gridy = 1;
        this.add(createSidePanel(comboBoxString));

        pack();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private JPanel createSidePanel(String[] comboBoxString){
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());

        sidePanel.add(moveButtonsPanel = new MoveButtonsPanel(), BorderLayout.CENTER);
        myColorSettingsPanel = new ColorSettingsPanel(comboBoxString);
        sidePanel.add(myColorSettingsPanel, BorderLayout.NORTH);

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
}
