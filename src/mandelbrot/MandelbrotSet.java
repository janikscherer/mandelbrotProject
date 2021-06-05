package mandelbrot;

import javax.swing.*;
import java.awt.*;

public class MandelbrotSet {
    private int height = 500;
    private int width = 500;
    public MandelbrotSet(){
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
                calculateMandelbrotSet(x, y); // Calculate for each pixel
            }
        }

    }


    public void calculateMandelbrotSet(float xVal, float yVal){
        float a = xVal/width*4-2;
        float b = yVal/height*4-2;

        float z = 0;

        for(int iterations = 0; iterations<100; iterations++){
            float newA = a*a - b*b;
            float newB = 2*a*b;

        }

    }
}
