package model;

import java.awt.*;

public class ColorEncoder {
    private int colorOffset;
    public ColorEncoder(){
        colorOffset = 0;
    }
    public int encodeColor(int iterations, int maxIterations){
        double color = 1.0*iterations/maxIterations;
        color += colorOffset/255.0;
        Color myColor = Color.getHSBColor((float) (color), 1, 1);
        return myColor.getRGB();
    }

    public void setColorOffset(int colorOffset) {
        this.colorOffset = colorOffset;
    }
}
