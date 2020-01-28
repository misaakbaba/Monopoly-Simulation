import java.util.ArrayList;

public class Jail extends Square {
    //data field
    private int exitPrice;
    ArrayList<Person> inJail = new ArrayList<>();

    public Jail(int exitPrice) {
        super.type = "Jail Square";
        this.exitPrice = exitPrice;
    }

    public void setExitPrice(int exitPrice) {
        this.exitPrice = exitPrice;
    }

    public int getExitPrice() {
        return exitPrice;
    }
}
