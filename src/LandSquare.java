import java.util.ArrayList;

public class LandSquare extends Property {
    private int numberOfHouse;
    private int numberOfHotel;
    private int colourID;
    private int costOfHotel;
    private int costOfHouse;

    public LandSquare(String name, int price, int rent, int colour) {
        super.nameOfSquare = name;
        super.owner = null;
        super.price = price;
        super.rent = rent;
        super.type = "LandSquare";
        colourID = colour;
        costOfHouse = 2 * rent;
        costOfHotel = 3 * rent;
    }


    //config ile ev sayısı arttırılınca kiranın kaça katlandığı elde edilir ve ev sayısına göre rent variable ı güncellenir
    @Override
    public void rent(Person owner, Person renter) { //evlerin kira bedeli güncellenecek
        int rentOfLand = 0;
        if (this.numberOfHouse == 0) {
            if (this.numberOfHotel == 1) {
                rentOfLand = 8 * this.rent; //configden default kirayı çek
            } else {
                rentOfLand = this.rent;
            }
        } else {
            rentOfLand = this.rent * (this.numberOfHouse + 1);
            //ev sayısına göre configden kira miktarı çekilir
        }
        owner.setCurrentBalance(owner.getCurrentBalance() + rentOfLand);
        renter.setCurrentBalance(renter.getCurrentBalance() - rentOfLand);
    }

    @Override
    public void buy(Person player) {
        player.getOwnSquares().add(this); // bu objeyi refer ediyor.
        player.setCurrentBalance(player.getCurrentBalance() - this.price);
        this.owner = player;
    }


    //aynı renkte olan tüm arsalara sahip mi değil mi?
    public boolean hasAllSameColourLand(Person player, Board gameBoard) {
        int id = this.colourID;
        int sameColur = 0;
        int hasAllSameColur = 0;
        for (int i = 0; i < gameBoard.getGameboard().size(); i++) {
            if (gameBoard.getGameboard().get(i) instanceof LandSquare) {
                if (((LandSquare) (gameBoard.getGameboard().get(i))).colourID == id) {
                    sameColur++;
                    if (player.getOwnSquares().contains(((gameBoard.getGameboard().get(i))))) {
                        hasAllSameColur++;
                    }
                }
            }
        }
        if (sameColur == hasAllSameColur)
            return true;
        return false;
    }

    //otel yapabilmek için evler yıkılır ve yerine otel yapılır
    void changeHousesWithHotels(Person player) {
        //otel yapmak için gerekn price miktarı configden çekilecek
        int costOfHotel = this.costOfHotel;
        this.numberOfHouse = 0;
        this.numberOfHotel = 1;
        player.setCurrentBalance(player.getCurrentBalance() - costOfHotel);
    }

    void buildHouse(Person person) {
        this.numberOfHouse += 1;
        person.setCurrentBalance(person.getCurrentBalance() - costOfHouse);
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public int getNumberOfHotel() {
        return numberOfHotel;
    }

    public void setNumberOfHotel(int numberOfHotel) {
        this.numberOfHotel = numberOfHotel;
    }

    public int getColourID() {
        return colourID;
    }

    public void setColourID(int colourID) {
        this.colourID = colourID;
    }

    public int getCostOfHotel() {
        return costOfHotel;
    }

    public void setCostOfHotel(int costOfHotel) {
        this.costOfHotel = costOfHotel;
    }

    public int getCostOfHouse() {
        return costOfHouse;
    }

    public void setCostOfHouse(int costOfHouse) {
        this.costOfHouse = costOfHouse;
    }
}
