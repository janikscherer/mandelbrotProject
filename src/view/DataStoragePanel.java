package view;

import javax.swing.*;
import java.awt.*;

public class DataStoragePanel extends JPanel {

    private JList<String> list;
    private JButton saveButton;
    private JButton loadButton;
    private JButton removeButton;

    public DataStoragePanel() {

        this.setLayout(new BorderLayout());

        list = new JList<>();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listscrollpane = new JScrollPane(list);
        this.add(listscrollpane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        saveButton = new JButton("Save");
        buttonPanel.add(saveButton);

        loadButton = new JButton("Load");
        buttonPanel.add(loadButton);

        removeButton = new JButton("Remove");
        buttonPanel.add(removeButton);

        this.add(buttonPanel);
    }

    public JList<String> getList() {
        return list;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }
}
