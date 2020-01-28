public class StartingSquare extends Square {
    //data field
    private int rewardPrice;

    public StartingSquare() {
        super.type = "Starting Square";
    }

    public int getRewardPrice() {
        return rewardPrice;
    }

    public void setRewardPrice(int rewardPrice) {
        this.rewardPrice = rewardPrice;
    }
}
