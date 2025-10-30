package buttonsPusher.controller;

import java.util.Random;

public class Randomizer {
    public static int getRandomValue(String minValue, String maxValue) {
        int min = 2;
        int max = 30;

        try {
            min = Integer.parseInt(minValue);
            max = Integer.parseInt(maxValue);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка перобразования в int.");
        }
        min = min * 1000;
        max = max * 1000;

        if (max < min) {
            throw new IllegalArgumentException("Параметр 'min' не может быть больше 'max'");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
