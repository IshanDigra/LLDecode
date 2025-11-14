package LLD_Problems.TickTackToe;

import LLD_Problems.TickTackToe.Piece.Piece;

public class Player {
    private final String name;
    private Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", piece=" + piece +
                '}';
    }
}
