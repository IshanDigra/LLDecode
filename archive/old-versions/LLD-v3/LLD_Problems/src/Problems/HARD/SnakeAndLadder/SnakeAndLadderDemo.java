package Problems.HARD.SnakeAndLadder;

import Problems.HARD.SnakeAndLadder.Service.GameManager;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        // Start game 1
        List<String> players1 = Arrays.asList("Ishu", "Gajri");
        gameManager.startNewGame(players1);

//        // Start game 2
//        List<String> players2 = Arrays.asList("Player 4", "Player 5");
//        gameManager.startNewGame(players2);
    }
}
