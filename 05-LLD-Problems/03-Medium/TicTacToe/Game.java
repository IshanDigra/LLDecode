package LLD_Problems.MEDIUM.PicTackToeGame;

import java.util.Scanner;

public class Game {
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Board board;

    public Game(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = p1;
        board  = new Board();
    }

    public void play(){
        board.printBoard();
        while(!board.isFull() && !board.hasWinner()){
            int row = getInput(currentPlayer.getName()+  " Please mention the row (0...2) :");
            int col = getInput(currentPlayer.getName()+ "Please mention the column (0..2) :");

            try{
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                switchPlayer();
                if(!board.isFull() && !board.hasWinner()){
                    System.out.println(currentPlayer.getName() + " its your turn!");
                }
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        if(board.hasWinner()){
            switchPlayer();
            System.out.println(currentPlayer.getName() + " Won!");
        }
        else{
            System.out.println("Its a Draw");
        }

    }

    private int getInput(String message){
        Scanner scanner = new Scanner(System.in);
        int res;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                res = scanner.nextInt();
                if (res >= 0 && res <= 2) {
                    return res;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }

    private void switchPlayer(){
        if(currentPlayer == p1) currentPlayer = p2;
        else currentPlayer  = p1;
    }


}
