package view;

import javax.swing.*;
import java.awt.*;

public class Gui {
    GuiElements myGuiElements;
    ColorSettingsPanel myColorSettingsPanel;

    public Gui(JPanel mandelbrotPanel, String[] comboBoxString){
        myGuiElements = new GuiElements();
        JFrame frame = new JFrame();
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());

        frame.getContentPane().add(mandelbrotPanel);
        GridBagConstraints myGBC = new GridBagConstraints();
        myGBC.gridy = 1;
        frame.getContentPane().add(createSidePanel(comboBoxString));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private JPanel createSidePanel(String[] comboBoxString){
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(createMoveButtonsPanel(), BorderLayout.CENTER);
        myColorSettingsPanel = new ColorSettingsPanel(myGuiElements, comboBoxString);
        sidePanel.add(myColorSettingsPanel, BorderLayout.NORTH);
        return sidePanel;
    }

    private JPanel createMoveButtonsPanel(){
        JPanel moveButtonsPanel = new JPanel();
        moveButtonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints myGBC = new GridBagConstraints();

        JButton zoomInButton = new JButton("Zoom in");
        zoomInButton.setPreferredSize(new Dimension(120,40));
        myGuiElements.addButton(zoomInButton);

        JButton zoomOutButton = new JButton("Zoom out");
        zoomOutButton.setPreferredSize(new Dimension(120,40));
        myGuiElements.addButton(zoomOutButton);

        JButton moveUpButton = new JButton("Move up");
        moveUpButton.setPreferredSize(new Dimension(120,20));
        myGuiElements.addButton(moveUpButton);

        JButton moveLeftButton = new JButton("Move left");
        moveLeftButton.setPreferredSize(new Dimension(120,20));
        myGuiElements.addButton(moveLeftButton);

        JButton moveRightButton = new JButton("Move right");
        moveRightButton.setPreferredSize(new Dimension(120,20));
        myGuiElements.addButton(moveRightButton);

        JButton moveDownButton = new JButton("Move down");
        moveDownButton.setPreferredSize(new Dimension(120,20));
        myGuiElements.addButton(moveDownButton);

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

    public GuiElements getGuiElements(){
        return myGuiElements;
    }
}
