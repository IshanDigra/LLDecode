package LLD_Problems.TickTackToe;

import LLD_Problems.TickTackToe.Piece.PieceO;
import LLD_Problems.TickTackToe.Piece.PieceX;

public class Demo {
    public static void main(String[] args) {
        Player p1 = new Player("Ishan", new PieceO());
        Player p2 = new Player("Gargi", new PieceX());

        Game game = new Game(p1,p2);
        game.initiateGame();
    }
}
