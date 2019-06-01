package dice_statistics;

import java.util.Random;

public class Dice {

    private final int MAX = 6;
    private final Random generator;

    public Dice() {
        generator = new Random();
    }

    public int roll() {
        return generator.nextInt(MAX) + 1;

    }

}
