public abstract class Property extends Square implements PurchaseableSquares {
    protected int price;
    protected Person owner = null;
    protected String nameOfSquare;
    protected int rent;

    public Property() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    abstract public void rent(Person owner, Person renter, Board gameBoard);
//
//    abstract public void buy(Person player, Board gameBoard);
}
