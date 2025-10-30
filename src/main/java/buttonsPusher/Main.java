package buttonsPusher;

import buttonsPusher.controller.ButtonsController;
import buttonsPusher.controller.FileReaderController;
import buttonsPusher.controller.Randomizer;
import buttonsPusher.view.MainFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws AWTException {

//        D:\it\ButtonsPusher\src\main\resources\jobs.txt
        FileReaderController fileReader = new FileReaderController("D:\\it\\ButtonsPusher\\src\\main\\resources\\test.txt", new ButtonsController(new Robot()));
        fileReader.SymbolicTraversal("1", "2");

//        MainFrame.run();
//        System.out.println(Randomizer.getRandomValue(5, 50));
    }
}