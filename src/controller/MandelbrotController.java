package controller;

import model.MandelbrotSet;
import view.Gui;
import view.GuiElements;

public class MandelbrotController {
    private int height = 1200;
    private int width = 1200;
    private GuiElements myGuiElements;
    private MandelbrotSet myMandelbrot;

    public MandelbrotController() {
        myMandelbrot = new MandelbrotSet(height, width);
        Gui myGui = new Gui(myMandelbrot.createAndShowGUI());
        myGuiElements = myGui.getGuiElements();
        initializeElements();
    }

    private void initializeElements(){
        myGuiElements.getButtons().get(0).addActionListener(x -> { myMandelbrot.decreaseScale(); });
        myGuiElements.getButtons().get(1).addActionListener(x -> { myMandelbrot.increaseScale(); });
        myGuiElements.getButtons().get(2).addActionListener(x -> { myMandelbrot.moveUp(); });
        myGuiElements.getButtons().get(3).addActionListener(x -> { myMandelbrot.moveLeft(); });
        myGuiElements.getButtons().get(4).addActionListener(x -> { myMandelbrot.moveRight(); });
        myGuiElements.getButtons().get(5).addActionListener(x -> { myMandelbrot.moveDown(); });
        myGuiElements.getSliders().get(0).addChangeListener(x -> { myMandelbrot.setColorOffset(myGuiElements.getSliders().get(0).getValue());});
    }
}
