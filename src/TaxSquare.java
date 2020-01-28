
public class TaxSquare extends Square {
    private int taxAmount;

    public TaxSquare(int taxAmount) {
        super.type = "taxSquare";
        this.taxAmount = taxAmount;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

}
