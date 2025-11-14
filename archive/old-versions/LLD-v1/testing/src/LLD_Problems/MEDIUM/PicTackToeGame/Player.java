package LLD_Problems.MEDIUM.PicTackToeGame;

public class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

//  getters
    public String getName(){return name; }
    public char getSymbol(){return symbol;}

}
