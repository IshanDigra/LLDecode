package Problems.HARD.Chess.Model.Pieces;

import Problems.HARD.Chess.Constant.Color;
import Problems.HARD.Chess.Model.Board;
import Problems.HARD.Chess.Service.Piece;

public class Rook extends Piece {
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {

        return (row==destRow || col==destCol);
    }
}
