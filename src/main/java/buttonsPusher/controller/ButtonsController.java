package buttonsPusher.controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class ButtonsController {
    Robot robot;

    public ButtonsController(Robot robot) {
        this.robot = robot;
    }

    // В данный метод передаются 2 параметра buttonNumber - код нажимаемой клавиши, delay задержка с которой клавиша будет нажиматься
    public void ButtonPush(int buttonNumber, int delay) {

        // Создаём мапу с кодами символов которы нужо нажимать через shift
        Map<Integer, Integer> specialSymbols = new HashMap<>();
        specialSymbols.put(42, 56); // * - 8
        specialSymbols.put(95, 45); // _ - -
        specialSymbols.put(40, 57); // ( - 9
        specialSymbols.put(41, 48); // ) - 0
        specialSymbols.put(35, 51); // # - 3


        this.robot.delay(delay);

        if (Character.isUpperCase(buttonNumber)) {
            this.robot.keyPress(KeyEvent.VK_SHIFT);
        }

        if (specialSymbols.containsKey(buttonNumber)) {
            this.robot.keyPress(KeyEvent.VK_SHIFT);
            buttonNumber = specialSymbols.get(buttonNumber);
        }

        buttonNumber = KeyEvent.getExtendedKeyCodeForChar(buttonNumber);

        this.robot.keyPress(buttonNumber);
        this.robot.keyRelease(buttonNumber);
        this.robot.keyRelease(KeyEvent.VK_SHIFT);

    }
}
