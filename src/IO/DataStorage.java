package IO;

import model.PositionAndSettings;

import java.io.*;

public class DataStorage {
    private final String delimiter;
    public DataStorage(){
        delimiter = ";";
    }

    public void writePositionAndSettings(PositionAndSettings positionAndSettings){
        try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("positionAndSettings.txt"),true));){
            printWriter.print(positionAndSettings.getMyScale() + delimiter);
            printWriter.print(positionAndSettings.getMyXOffset() + delimiter);
            printWriter.print(positionAndSettings.getMyYOffset() + delimiter);
            printWriter.print(positionAndSettings.getMyColorMode() + delimiter);
            printWriter.print(positionAndSettings.getMyColorOffset() + delimiter);
            printWriter.println();
        }
        catch (IOException e){
            System.out.println(e.getMessage());

        }

    }
}
