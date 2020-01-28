public class PublicCorporationSquare extends Property {

    public PublicCorporationSquare(String name, int price, int rent) {
        super.nameOfSquare = name;
        super.owner = null;
        super.price = price;
        super.rent = rent;
        super.type = "PublicCorporationSquare";
    }

    @Override
    public void rent(Person owner, Person renter) {
        if (owner.hasSquare("fuelGass") && owner.hasSquare("telecommunication")) {
            rent = renter.getLastDice() * 100000;
        } else {
            rent = renter.getLastDice() * 40000;
        }

        owner.setCurrentBalance(owner.getCurrentBalance() + rent);
        renter.setCurrentBalance(renter.getCurrentBalance() - rent);
    }

    @Override
    public void buy(Person player) {
        player.getOwnSquares().add(this);
        player.setCurrentBalance(player.getCurrentBalance() - super.price);
        this.owner = player;
        //burda düzenlemek gereken bir şeyler daha vardı sanki
    }
}
