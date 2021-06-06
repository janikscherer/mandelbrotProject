package mandelbrot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MandelbrotSet {
    private int height = 1200;
    private int width = 1200;


    public MandelbrotSet() {

    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));
        BufferedImage image = createImage(width, height);
        ImagePanel imagePanel = new ImagePanel(image);
        frame.getContentPane().add(imagePanel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public BufferedImage createImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = calculateMandelbrotSet(x, y); // Calculate for each pixel
                image.setRGB(x, y, color);
            }
        }
        return image;
    }


    public int calculateMandelbrotSet(float xVal, float yVal) {
        float a = xVal / width * 4 - 2;
        float b = yVal / height * 4 - 2;
        final float originalA = a;
        final float originalB = b;
        int maxIterations = 90;

        int iterations = 0;
        for (; iterations < maxIterations; iterations++) {
            float newA = a * a - b * b;
            float newB = 2 * a * b;

            a = newA + originalA;
            b = newB + originalB;

            if (Math.abs(a * a + b * b + 2 * a * b) > 10000000) {
                break;
            }
        }

        if (iterations == maxIterations) {
            return 0;
        } else return (iterations * (Integer.MAX_VALUE / (maxIterations)));
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

}

