package model;

public class PositionAndSettings {
    private ColorMode myColorMode;
    private float myScale;
    private float myXOffset;
    private float myYOffset;
    public PositionAndSettings(float scale, float xOffset, float yOffset, ColorMode colorMode){
        myScale= scale;
        myXOffset =xOffset;
        myYOffset = yOffset;
        myColorMode = colorMode;
    }
}
