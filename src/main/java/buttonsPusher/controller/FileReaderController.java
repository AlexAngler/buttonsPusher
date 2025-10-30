package buttonsPusher.controller;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderController {
    String path = "";
    ButtonsController buttonsController;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileReaderController(String path, ButtonsController buttonsController) {
        this.path = path;
        this.buttonsController = buttonsController;
    }

    public void SymbolicTraversal(String min, String max) {
        try (FileInputStream fileInputStream = new FileInputStream(this.path)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                int randomValue = Randomizer.getRandomValue(min, max);
                System.out.println(i + " - " + (char) i);
                System.out.println("randomValue - " + randomValue);
                buttonsController.ButtonPush(i, randomValue);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
