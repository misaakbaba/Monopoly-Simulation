import java.util.ArrayList;

public class Board {
    private ArrayList<Square> gameboard;

    public Board(ArrayList<Square> gameboard) {
        this.gameboard = gameboard;
    }


    public void setGameboard(ArrayList<Square> gameboard) {
        this.gameboard = gameboard;
    }

    public ArrayList<Square> getGameboard() {
        return gameboard;
    }
}