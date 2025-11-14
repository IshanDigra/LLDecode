package LLD_Problems.MEDIUM.PicTackToeGame;

public class Board {
    private char[][] board;
    private int moveCount;

    public Board(){
        board = new char[3][3];
        initializeBoard();
        moveCount = 0 ;
    }

    private void initializeBoard(){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j <3; j++){
                board[i][j] = '-';
            }
        }
    }

    public boolean isFull(){
        return moveCount == 9;
    }

    public boolean hasWinner(){
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        return board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0];

    }

    public void makeMove(int row, int col, char symbol){
        if(row<0 || col<0 || row>=3 || col>=3 || board[row][col]!='-'){
            throw new IllegalArgumentException("Invalid Aguments!");
        }
        board[row][col] = symbol;
        moveCount++;
    }

    public void printBoard(){
        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
