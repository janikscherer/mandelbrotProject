package model;

public class PositionAndSettings {
    private float myScale;
    private float myXOffset;
    private float myYOffset;
    private ColorMode myColorMode;
    private int myColorOffset;
    public PositionAndSettings(float scale, float xOffset, float yOffset, ColorMode colorMode, int colorOffset){
        myScale= scale;
        myXOffset =xOffset;
        myYOffset = yOffset;
        myColorMode = colorMode;
        myColorOffset = colorOffset;
    }

    public float getMyScale() {
        return myScale;
    }

    public float getMyXOffset() {
        return myXOffset;
    }

    public float getMyYOffset() {
        return myYOffset;
    }

    public ColorMode getMyColorMode() {
        return myColorMode;
    }

    public int getMyColorOffset() {
        return myColorOffset;
    }
}
