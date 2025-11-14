package Problems.HARD.Chess.Model.Pieces;

import Problems.HARD.Chess.Constant.Color;
import Problems.HARD.Chess.Model.Board;
import Problems.HARD.Chess.Service.Piece;

public class Queen extends Piece {
    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = Math.abs(row-destRow);
        int colDiff = Math.abs(col-destCol);
        return (rowDiff ==colDiff || row==destRow || col==destCol);
    }
}
