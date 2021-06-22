package IO;

import model.ColorMode;
import model.PositionAndSettings;

import java.io.*;
import java.util.Scanner;

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

    public PositionAndSettings readPositionAndSettings(int indexInList){
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("positionAndSettings.txt")))){
            scanner.useDelimiter(delimiter);
            for(int i = 0; i<indexInList; i++){
                scanner.nextLine();
            }
            float scale = scanner.nextFloat();
            float xOffset = scanner.nextFloat();
            float yOffset = scanner.nextFloat();
            ColorMode colorMode = ColorMode.colorModeFromString(scanner.next());
            int colorOffset = scanner.nextInt();
            return new PositionAndSettings(scale, xOffset, yOffset, colorMode, colorOffset);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
