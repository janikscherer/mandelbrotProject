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

            float z = 0;

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

            //Version 1 (Schwarz gefuellt ohne Abstufung)
            /*
            if(iterations == maxIterations) {
                return 0;
            } else return 255;
            */

            //Version 2 (Mitte gefuellt außen abgestuft)
            if (iterations == maxIterations) {
                return 0;
            } else if (iterations == maxIterations - 80) {
                return 180;
            } else if (iterations == maxIterations - 79) {
                return 135;
            } else if (iterations == maxIterations - 78) {
                return 90;
            } else if (iterations == maxIterations - 77) {
                return 45;
            } else if (iterations <= maxIterations - 76) {
                return 0;
            } else return 255;

        /*
            //Version 3 (Mitte gefuellt außen abgestuft in unterschiedlichen Farben)
            if (iterations > 9*maxIterations/10) return Color.BLACK.getRGB();
            else if (iterations > 8*maxIterations/10)return Color.GRAY.getRGB();
            else if (iterations > 7*maxIterations/10) return Color.MAGENTA.getRGB();
            else if (iterations > 6*maxIterations/10) return Color.CYAN.getRGB();
            else if (iterations > 5*maxIterations/10) return Color.BLUE.getRGB();
            else if (iterations > 4*maxIterations/10) return Color.GREEN.getRGB();
            else if (iterations > 3*maxIterations/10) return  Color.YELLOW.getRGB();
            else if (iterations > 2*maxIterations/10) return Color.ORANGE.getRGB();
            else if (iterations > 1*maxIterations/10) return Color.RED.getRGB();
            else return 0;


         */
    }


    static class ImagePanel extends JPanel
    {
        private final BufferedImage image;
        ImagePanel(BufferedImage image)
        {
            this.image = image;
        }

        @Override
        public Dimension getPreferredSize()
        {
            if (super.isPreferredSizeSet())
            {
                return super.getPreferredSize();
            }
            return new Dimension(image.getWidth(), image.getHeight()); //encapsulates the width and height of a component (in integer precision) in a single object
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);

        }
    }

}

