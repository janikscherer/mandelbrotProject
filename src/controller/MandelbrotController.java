package controller;

import model.MandelbrotSet;
import view.gui;

public class MandelbrotController {
    private int height = 1200;
    private int width = 1200;

    public MandelbrotController() {
        MandelbrotSet myMandelbrot = new MandelbrotSet(height, width);
        new gui(myMandelbrot.createAndShowGUI());
    }
}
