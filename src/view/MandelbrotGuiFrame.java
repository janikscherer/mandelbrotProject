package view;

import javax.swing.*;
import java.awt.*;

public class MandelbrotGuiFrame extends JFrame{
    private ColorSettingsPanel myColorSettingsPanel;
    private DataStoragePanel dataStoragePanel;
    private JButton zoomInButton;
    private JButton zoomOutButton;
    private JButton moveUpButton;
    private JButton moveLeftButton;
    private JButton moveRightButton;
    private JButton moveDownButton;

    public MandelbrotGuiFrame(JPanel mandelbrotPanel, String[] comboBoxString){
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.add(mandelbrotPanel);
        GridBagConstraints myGBC = new GridBagConstraints();
        myGBC.gridy = 1;
        this.add(createSidePanel(comboBoxString));

        dataStoragePanel = new DataStoragePanel();
        this.add(dataStoragePanel);

        pack();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private JPanel createSidePanel(String[] comboBoxString){
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(createMoveButtonsPanel(), BorderLayout.CENTER);
        myColorSettingsPanel = new ColorSettingsPanel(comboBoxString);
        sidePanel.add(myColorSettingsPanel, BorderLayout.NORTH);
        return sidePanel;
    }

    private JPanel createMoveButtonsPanel(){
        JPanel moveButtonsPanel = new JPanel();
        moveButtonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints myGBC = new GridBagConstraints();

        zoomInButton = new JButton("Zoom in");
        zoomInButton.setPreferredSize(new Dimension(120,40));

        zoomOutButton = new JButton("Zoom out");
        zoomOutButton.setPreferredSize(new Dimension(120,40));

        moveUpButton = new JButton("Move up");
        moveUpButton.setPreferredSize(new Dimension(120,20));

        moveLeftButton = new JButton("Move left");
        moveLeftButton.setPreferredSize(new Dimension(120,20));

        moveRightButton = new JButton("Move right");
        moveRightButton.setPreferredSize(new Dimension(120,20));

        moveDownButton = new JButton("Move down");
        moveDownButton.setPreferredSize(new Dimension(120,20));

        myGBC.ipady = 25;
        myGBC.gridx = 1;
        myGBC.gridy = 0;
        moveButtonsPanel.add(zoomInButton, myGBC);
        myGBC.gridy++;
        moveButtonsPanel.add(zoomOutButton, myGBC);

        myGBC.insets = new Insets(25, 0,0,0);
        myGBC.gridy++;
        myGBC.ipady = myGBC.ipady*2;
        moveButtonsPanel.add(moveUpButton, myGBC);
        myGBC.insets = new Insets(0, 0,0,0);

        myGBC.gridy++;
        myGBC.gridx = 2;
        moveButtonsPanel.add(moveRightButton, myGBC);
        myGBC.gridx = 0;
        moveButtonsPanel.add(moveLeftButton, myGBC);
        myGBC.gridy++;
        myGBC.gridx = 1;
        moveButtonsPanel.add(moveDownButton, myGBC);
        return moveButtonsPanel;
    }

    public ColorSettingsPanel getMyColorSettingsPanel() {
        return myColorSettingsPanel;
    }

    public DataStoragePanel getDataStoragePanel() {
        return dataStoragePanel;
    }

    public JButton getZoomInButton() {
        return zoomInButton;
    }

    public JButton getZoomOutButton() {
        return zoomOutButton;
    }

    public JButton getMoveUpButton() {
        return moveUpButton;
    }

    public JButton getMoveLeftButton() {
        return moveLeftButton;
    }

    public JButton getMoveRightButton() {
        return moveRightButton;
    }

    public JButton getMoveDownButton() {
        return moveDownButton;
    }
}
