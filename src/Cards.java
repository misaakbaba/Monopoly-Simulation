import java.util.ArrayList;

public class Cards {

    String cardsInfo;

    public Cards() {
    }

    public void applyCardsEffect(int cardID, Person person, Game game) {
//        int numberOfSquare = game.board.size(); // kare sayısı
        switch (cardID) {
            case 0:
                cardsInfo = "Get out of jail.";
                if (person.getInJail()) {
                    person.setInJail(false);
                } else {
                    person.setExitJailCard(true);
                }
                System.out.println("Card info: " + cardsInfo);
                break;
            case 1:
                cardsInfo = "Computer system infected with virus Pay 1 million.";
                person.setCurrentBalance(person.getCurrentBalance() - 1000000);
                System.out.println("Card info: " + cardsInfo);

                break;
            case 2:
                cardsInfo = "Go to Jail.";
                person.setInJail(true);
                person.setPosition(10); // jail visitor location
                System.out.println("Card info: " + cardsInfo);
                break;
            case 3:
                cardsInfo = "You won the lottery. Take 1 million.";
                person.setCurrentBalance(person.getCurrentBalance() + 1000000);
                System.out.println("Card info: " + cardsInfo);
                break;
            case 4:
                cardsInfo = "Pass the starting square and get 2 million.";
                person.setCurrentBalance(person.getCurrentBalance() + 2000000);
                System.out.println("Card info: " + cardsInfo);
                person.setPosition(0);
                break;
            case 5:
                cardsInfo = "There are complaints about the your hotel , pay 500 thousand to each player.";
                for (int i = 0; i < game.getPlayers().size(); i++) {
                    game.getPlayers().get(i).setCurrentBalance(game.getPlayers().get(i).getCurrentBalance() + 500000);
                    person.setCurrentBalance(person.getCurrentBalance() - 500000);
                }
                System.out.println("Card info: " + cardsInfo);
                break;
            case 6:
                cardsInfo = "Get tax deduction 500 thousand.";
                person.setCurrentBalance(person.getCurrentBalance() + 500000);
                System.out.println("Card info: " + cardsInfo);
                break;
            case 7:
                cardsInfo = "Go back 3 square.";
                if (person.getPosition() >= 3) {
                    person.setPosition(person.getPosition() - 3);
                } else {
                    int newPosition = person.getPosition() - 3;
                    newPosition += game.getGameBoard().getGameboard().size();
                    person.setPosition(newPosition);
                }
                System.out.println("Card info: " + cardsInfo);
                break;
            case 8:
                cardsInfo = "Pay your tax debt 500 thousand.";
                person.setCurrentBalance(person.getCurrentBalance() - 500000);
                System.out.println("Card info: " + cardsInfo);
                break;
        }
    }

}
