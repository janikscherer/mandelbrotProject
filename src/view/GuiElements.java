package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiElements {
    private List<JComboBox<String>> jComboBoxes;

    public GuiElements(){
        jComboBoxes = new ArrayList<>();
    }



    public void addJComboBox(JComboBox<String> givenJComboBox){
        jComboBoxes.add(givenJComboBox);
    }


    public List<JComboBox<String>> getjComboBoxes() {
        return jComboBoxes;
    }
}
