package model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotSet {

    private int height;
    private int width;

    private float scale;
    private float xOffset;
    private float yOffset;


    private BufferedImage mandelbrotImage;
    private ImagePanel mandelbrotPanel;

    private ColorEncoder myColorEncoder;


    public MandelbrotSet(int height, int width) {
        myColorEncoder = new ColorEncoder();
        this.height = height;
        this.width = width;
        scale = 4;
        xOffset = 0;
        yOffset = 0;
        mandelbrotImage = createImage(width, height);
        mandelbrotPanel = new ImagePanel(mandelbrotImage);
        updateImage();
    }

    public BufferedImage createImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        return image;
    }

    private void updateImage(){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = calculateMandelbrotSet(x, y); // Calculate for each pixel
                mandelbrotImage.setRGB(x, y, color);
            }
        }
        mandelbrotPanel.updateUI();
    }

    public int calculateMandelbrotSet(float xVal, float yVal) {
        float a = xVal / width * scale - scale / 2 + xOffset;
        float b = yVal / height * scale - scale / 2 + yOffset;
        final float originalA = a;
        final float originalB = b;
        int maxIterations = 150;

        int iterations = 0;
        for (; iterations < maxIterations; iterations++) {
            float newA = a * a - b * b;
            float newB = 2 * a * b;

            a = newA + originalA;
            b = newB + originalB;

            if (Math.abs(a + b) > Integer.MAX_VALUE) {
                break;
            }
        }

        if (iterations == maxIterations) {
            return 0;
        } else {
            return myColorEncoder.encodeColor(iterations, maxIterations);
        }
    }

    public void setColorOffset(int value){
        myColorEncoder.setColorOffset(value);
        updateImage();
    }

    public void changeColorMode(String colorMode){
        myColorEncoder.changeColorMode(colorMode);
        updateImage();
    }

    public PositionAndSettings getPositionAndSettings(){
        return new PositionAndSettings(scale, xOffset, yOffset, myColorEncoder.getCurrentMode(), myColorEncoder.getColorOffset());
    }

    public void loadPositionAndSettings(PositionAndSettings myPositionAndSettings){
        scale = myPositionAndSettings.getMyScale();
        xOffset = myPositionAndSettings.getMyXOffset();
        yOffset = myPositionAndSettings.getMyYOffset();
        myColorEncoder.setCurrentMode(myPositionAndSettings.getMyColorMode());
        myColorEncoder.setColorOffset(myPositionAndSettings.getMyColorOffset());
        updateImage();
    }


    static class ImagePanel extends JPanel {
        private final BufferedImage image;

        ImagePanel(BufferedImage image) {
            this.image = image;
        }

        @Override
        public Dimension getPreferredSize() {
            if (super.isPreferredSizeSet()) {
                return super.getPreferredSize();
            }
            return new Dimension(image.getWidth(), image.getHeight()); //encapsulates the width and height of a component (in integer precision) in a single object
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }

    public void decreaseScale(){
        scale=scale/2;
        updateImage();
    }

    public void increaseScale(){
        scale=scale*2;
        updateImage();
    }

    public void moveRight(){
        xOffset += scale/8;
        updateImage();
    }

    public void moveLeft(){
        xOffset -= scale/8;
        updateImage();
    }

    public void moveUp(){
        yOffset -= scale/8;
        updateImage();
    }

    public void moveDown(){
        yOffset += scale/8;
        updateImage();
    }

    public JPanel createAndShowGUI() {
        return mandelbrotPanel;   }

}

