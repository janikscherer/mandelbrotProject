package mandelbrot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MandelbrotSet {
    private int height = 500;
    private int width = 500;
    public MandelbrotSet(){
        File f = null;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        Canvas canvas = new Canvas();
        contentPane.add(canvas);
        frame.add(contentPane);
        frame.setVisible(true);
        frame.setResizable(false);

        for(int x = 0; x < width;x++){
            for(int y = 0; y < height; y++){
                int color = calculateMandelbrotSet(x, y); // Calculate for each pixel
                image.setRGB(x, y, color);
            }
        }

        try{
            f= new File("mandelbrot.png");
            ImageIO.write(image, "png", f);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public int calculateMandelbrotSet(float xVal, float yVal){
        float a = xVal/width*4-2;
        float b = yVal/height*4-2;
        final float originalA = a;
        final float originalB = b;

        int maxIterations = 100;

        float z = 0;

        int iterations = 0;
        for(; iterations<maxIterations; iterations++){
            float newA = a*a - b*b;
            float newB = 2*a*b;
            a= newA + originalA;
            b= newB + originalB;

            if(Math.abs(a+b)>16){
                break;
            }
        }

        if(iterations == maxIterations-1){
            return 0;
        }
        else return 255;

    }
}
