package LLD_Problems.TickTackToe;

import LLD_Problems.TickTackToe.Piece.Piece;

public class Board {
    private final int size ;
    Piece[][] board;

    public Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public boolean addPiece(int row, int column, Piece piece){
        if(board[row][column] != null){
            System.out.println("Please choose a valid spot");
            return false;
        }
        else{
            board[row][column] = piece;
            return true;
        }
    }

    public boolean isComplete(){
        for(int i = 0 ; i < size ;i++){
            for(int j = 0 ; j < size; j++){
                if(board[i][j] ==null) return false;
            }
        }
        return true;
    }

    public boolean isWin(Piece piece, int row, int column){
        for(int i = 0 ; i < size; i++){
            if(board[i][column]==null) return false;
            if(board[row][i]==null) return false;
            if(board[i][i]==null) return false;
            if (board[i][size-i-1]==null) return false;


        }
        return true;
    }

    public Piece getPiece(int r, int c){
        return board[r][c];
    }
}
