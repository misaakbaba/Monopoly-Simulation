public class TransportationSquare extends Property {

    public TransportationSquare(String name, int price) {
        super.nameOfSquare = name;
        super.owner = null;
        super.price = price;
        super.type = "TransportationSquare";
        if (name.equalsIgnoreCase("metro")) {
            super.rent = 500000;
        } else if (name.equalsIgnoreCase("plane")) {
            super.rent = 600000;
        } else if (name.equalsIgnoreCase("ship")) {
            super.rent = 300000;
        } else if (name.equalsIgnoreCase("tram")) {
            super.rent = 450000;
        }
    }

    @Override
    public void rent(Person owner, Person renter) {
        owner.setCurrentBalance(owner.getCurrentBalance() + super.rent);//burada sıkntı çıakrsa superlere bi göz at
        renter.setCurrentBalance(owner.getCurrentBalance() - super.rent);
    }

    @Override
    public void buy(Person player) {
        player.getOwnSquares().add(this);
        player.setCurrentBalance(player.getCurrentBalance() - super.price);
        this.owner = player;
    }
}
