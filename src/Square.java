import java.util.ArrayList;

public class Square {
    //data field
    protected String type;

    protected ArrayList<Person> playersOnTheSquare;

    Square(String type) {
        this();
        this.type = type;
    }

    public Square() {
        playersOnTheSquare = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    /*public ArrayList<Player> getPlayersOnTheSquare() {
        return playersOnTheSquare;
    }

    public void setPlayersOnTheSquare(ArrayList<Player> playersOnTheSquare) {
        this.playersOnTheSquare = playersOnTheSquare;
    }*/

}
