package Problems.HARD.Chess;

import Problems.HARD.Chess.Constant.Color;
import Problems.HARD.Chess.Model.Player;
import Problems.HARD.Chess.ServiceImpl.Game;

public class Demo {
    public static void main(String[] args) {
        Player p1 = new Player("1", "ishan", Color.WHITE);
        Player p2 = new Player("2", "Gajri", Color.BLACK);
        Game chessGame = new Game(p1,p2);
        chessGame.start();
    }
}
