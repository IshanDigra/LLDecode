package LLD_Problems.TickTackToe;

import LLD_Problems.TickTackToe.Piece.PieceType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;

    public Game(Player P1, Player P2) {
        players = new ArrayDeque<>();
        players.offer(P1);
        players.offer(P2);
        board = new Board(3);
        initiateGame();
    }
    public void initiateGame(){}

}
