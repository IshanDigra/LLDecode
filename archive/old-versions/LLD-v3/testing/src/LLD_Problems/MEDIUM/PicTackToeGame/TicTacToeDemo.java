package LLD_Problems.MEDIUM.PicTackToeGame;

public class TicTacToeDemo {
    public static void main(String[] args){
        Player p1 = new Player("Chandler", 'X');
        Player p2 = new Player("Monica", 'O');

        Game game = new Game(p1,p2);
        game.play();
    }
}
