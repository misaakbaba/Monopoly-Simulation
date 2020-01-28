//rolling dice
public class Dice {
    private int dice1;
    private int dice2;
    private int sum;
    private int same = 0;
    private int[] dices = new int[3];

    public Dice() {

    }

    int[] rollDice() {

        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = (int) (Math.random() * 6 + 1);
        dices[0] = dice1;
        dices[1] = dice2;

        sum = dice1 + dice2;
        dices[2] = sum;

        return dices;
    }

    int same() {
        if (dice1 == dice2) {
            same++;
        }
        return same;
    }

    boolean sameDice() {
        if (dice1 == dice2)
            return true;
        return false;
    }
}
