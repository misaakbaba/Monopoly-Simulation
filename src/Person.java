import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private boolean inJail;
    private int jailTime; // oyun süresince sürekli bunu kontrol edip 3 olunca atarız.
    private int myTurn;
    private int currentBalance;
    private int doublesCounter = 0;
    private int sameDiceCount = 0;
    private int position;
    private int lastDice;
    private boolean exitJailCard = false;
    private List<Property> ownSquares = new ArrayList<>();


    //List<Cards> cards = new ArrayList<Cards>();
    public Person(String name, int startingBalance) {
        this.name = name;
        position = 0;
        this.currentBalance = startingBalance;
    }

    public void setExitJailCard(boolean exitJailCard) {
        this.exitJailCard = exitJailCard;
    }

    public void setJailTime(int jailTime) {
        this.jailTime = jailTime;
    }

    public boolean isExitJailCard() {
        return exitJailCard;
    }


    public String getName() {
        return name;
    }


    public int getMyTurn() {
        return myTurn;
    }

    public void setMyTurn(int myTurn) {
        this.myTurn = myTurn;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getDoublesCounter() {
        return doublesCounter;
    }

    public void setDoublesCounter(int doublesCounter) {
        this.doublesCounter = doublesCounter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getLastDice() {
        return lastDice;
    }

    public void setLastDice(int lastDice) {
        this.lastDice = lastDice;
    }

    public List<Property> getOwnSquares() {
        return ownSquares;
    }


    public int getJailTime() {
        return jailTime;
    }


    @Override
    public int compareTo(Person o) {
        return o.currentBalance - this.currentBalance;
    }

    public boolean attemtpExitJail(int[] dices, Jail jail) {
        //parası varsa
        if (this.exitJailCard) {
            this.inJail = false;
            this.exitJailCard = false;
            return true;
        } else if (dices[0] == dices[1]) {
            this.inJail = false;
            return true;
        } else if (this.currentBalance >= jail.getExitPrice()) {
            this.currentBalance -= jail.getExitPrice();
            this.inJail = false;
            return true;
        }
        return false;
    }

    public void enterJail() {
        this.inJail = true;
        this.position = 10;
        this.jailTime = 3;
        System.out.println(this.name + " is enter jail");
    }

    boolean hasSquare(String name) {
        for (int i = 0; i < ownSquares.size(); i++) {
            if (ownSquares.get(i).nameOfSquare.equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    boolean hasColor(int id) {
        for (int i = 0; i < this.getOwnSquares().size(); i++) {
            if (this.getOwnSquares().get(i) instanceof LandSquare) {
                if (id == ((LandSquare) this.getOwnSquares().get(i)).getColourID()) {
                    return true;
                }
            }
        }
        return false;
    }

}

