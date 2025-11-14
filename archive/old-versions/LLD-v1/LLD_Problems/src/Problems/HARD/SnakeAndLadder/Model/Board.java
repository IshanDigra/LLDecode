package Problems.HARD.SnakeAndLadder.Model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Board {
    private static final int BOARD_SIZE = 100;

    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;

    public Board() {
        snakes = new ConcurrentHashMap<>();
        ladders = new ConcurrentHashMap<>();
        initializeSnakesAndLadders();
    }

    private void initializeSnakesAndLadders() {
        // Initialize snakes
        snakes.put(16,new Snake(16, 6));
        snakes.put(48,new Snake(48, 26));
        snakes.put(64,new Snake(64, 60));
        snakes.put(93,new Snake(93, 73));
        snakes.put(18,new Snake(18, 10));
        snakes.put(55,new Snake(55, 40));
        snakes.put(69,new Snake(69, 61));
        snakes.put(99,new Snake(99, 2));

        // Initialize ladders
        ladders.put(1,new Ladder(1, 38));
        ladders.put(4,new Ladder(4, 14));
        ladders.put(9,new Ladder(9, 31));
        ladders.put(21,new Ladder(21, 42));
        ladders.put(28,new Ladder(28, 84));
        ladders.put(51,new Ladder(51, 67));
        ladders.put(80,new Ladder(80, 99));
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public int getNewPositionAfterSnakeOrLadder(int position){
        if(snakes.containsKey(position)){
            System.out.println("oops! landed on a snake at position " + position);
            return snakes.get(position).getEnd();
        }
        if (ladders.containsKey(position)){
            System.out.println("found a ladder at position " + position);
            return ladders.get(position).getEnd();
        }
        return position;
    }
}
