package Problems.HARD.SnakeAndLadder.Model;

import java.util.Random;

public class Dice {
    private final int min;
    private final int max;
    Random rand = new Random();
    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int roll(){
        return rand.nextInt(max-min+1) + min;
    }
}
