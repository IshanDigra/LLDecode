package Problems.HARD.SnakeAndLadder.Service;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance;
    private final List<Game> games;

    private GameManager() {
        games = new ArrayList<>();
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startNewGame(List<String> playerNames) {
        Game game = new Game(playerNames);
        games.add(game);
        new Thread(() -> game.play()).start();
    }
}
