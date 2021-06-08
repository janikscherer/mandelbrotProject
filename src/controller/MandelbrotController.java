package controller;

import model.MandelbrotSet;
import view.Gui;

public class MandelbrotController {
    private int height = 1200;
    private int width = 1200;

    public MandelbrotController() {
        MandelbrotSet myMandelbrot = new MandelbrotSet(height, width);
        Gui myGui = new Gui(myMandelbrot.createAndShowGUI());
        myGui.getZoomInButton().addActionListener(x -> { myMandelbrot.decreaseScale(); });
        myGui.getZoomOutButton().addActionListener(x -> { myMandelbrot.increaseScale(); });
    }
}
