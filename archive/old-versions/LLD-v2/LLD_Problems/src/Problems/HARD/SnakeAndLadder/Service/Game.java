package Problems.HARD.SnakeAndLadder.Service;

import Problems.HARD.SnakeAndLadder.Model.Board;
import Problems.HARD.SnakeAndLadder.Model.Dice;
import Problems.HARD.SnakeAndLadder.Model.Player;
import Problems.MEDIUM.TicketBookingSystem.Model.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class Game {
    private final Dice dice;
    private final Board board;
    private final List<Player> players;
    private int currentPlayerIndex;

    public Game(List<String> players) {
        dice = new Dice(1,6);
        board = new Board();
        this.players = new ArrayList<>();
        for(String name : players){
            this.players.add(new Player(playerIdGenerator(),name));
        }
        currentPlayerIndex = 0 ;
    }


    public void play() {
        while(true){
            Player currentPlayer = players.get(currentPlayerIndex);
            int diceRoll = dice.roll();

            int newPosition = currentPlayer.getPosition() + diceRoll;

            if(newPosition <= board.getBoardSize()){
                currentPlayer.setPosition(board.getNewPositionAfterSnakeOrLadder(newPosition));
                System.out.println(currentPlayer.getName() + " rolled a " + diceRoll +
                        " and moved to position " + currentPlayer.getPosition());
            }
            else{
                System.out.println(currentPlayer.getName() + " rolled a " + diceRoll+", hence cannot move");
            }
            if( currentPlayer.getPosition()==board.getBoardSize()){
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }
            currentPlayerIndex = (currentPlayerIndex+1)%players.size();

            try{
                sleep(1000);
            } catch (InterruptedException e) {
                //
            }

        }
    }


    private String playerIdGenerator(){
        return "Player-"+ UUID.randomUUID().toString();
    }
}
