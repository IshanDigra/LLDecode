package Problems.HARD.Chess.Model;

import Problems.HARD.Chess.Constant.Color;
import Problems.HARD.Chess.Exception.InvalidMoveException;
import Problems.HARD.Chess.Service.Piece;

public class Player {
    private final String id;
    private final String name;
    private final Color color;

    public Player(String id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public void makeMove(Board board, Move move){
        Piece piece = move.getPiece();

        if(board.isValidMove(move.getPiece(),move.getDestRow(),move.getDestCol())){
            // moving the piece from the current position to the destination position
            board.setPiece(piece.getRow(), piece.getCol(), null);
            board.setPiece(move.getDestRow(), move.getDestCol(), piece);
            piece.setRow(move.getDestRow());
            piece.setCol(move.getDestCol());
        }
        else throw new InvalidMoveException("Invalid Move!");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
