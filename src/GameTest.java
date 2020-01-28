import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void move() throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Person> players = game.getPlayers();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        players.get(0).setPosition(35);
        int previousMoney = players.get(0).getCurrentBalance();
        game.move(players.get(0), 10);
        assertEquals(5, players.get(0).getPosition());
        assertEquals(previousMoney + 20000000, players.get(0).getCurrentBalance());
    }

    @Test
    void setGame() throws IOException {
        Game game = new Game();
        game.setGame();
        assertEquals(40, game.getGameBoard().getGameboard().size());
    }

    @Test
    void isBankrupt() {
        Person person = new Person("", 0);
        Game game = new Game();
        assertEquals(true, game.isBankrupt(person));
    }

    @Test
    void updateStatus() throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        Person testPerson = game.getPlayers().get(0);
        System.out.println("before money" + testPerson.getCurrentBalance());
        game.move(testPerson, 11);
        System.out.println(squares.get(testPerson.getPosition()));
        System.out.println(((Property) squares.get(testPerson.getPosition())).price);
        System.out.println(((Property) squares.get(testPerson.getPosition())).rent);
        game.updateStatus(testPerson);
        System.out.println("own squares" + testPerson.getOwnSquares());
        System.out.println("after money" + testPerson.getCurrentBalance());
    }

    @Test
    void updateStatus1() throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        Person testPerson = game.getPlayers().get(0);
        Person testPerson2 = game.getPlayers().get(1);
        ((Property) squares.get(11)).buy(testPerson2);
        System.out.println("before money" + testPerson.getCurrentBalance());
        game.move(testPerson, 11);
        System.out.println(squares.get(testPerson.getPosition()));
        System.out.println(((Property) squares.get(testPerson.getPosition())).price);
        System.out.println(((Property) squares.get(testPerson.getPosition())).rent);
        game.updateStatus(testPerson);
        System.out.println("own squares" + testPerson.getOwnSquares());
        System.out.println("after money" + testPerson.getCurrentBalance());
    }

    @Test
    void updateStatus2() throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        Person owner = game.getPlayers().get(0);
        Person renter = game.getPlayers().get(1);
        System.out.println(squares.get(1));
        LandSquare testPlace = (LandSquare) squares.get(1);
        testPlace.buy(owner);
        game.move(owner, 1);
        game.move(renter, 1);
        game.beforeRollingDices(owner);
        game.updateStatus(renter);
    }

    @Test
    void updateStatus3() throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        Person owner = game.getPlayers().get(0);
        Person renter = game.getPlayers().get(1);
        System.out.println(squares.get(1));
        LandSquare testPlace = (LandSquare) squares.get(1);
        game.move(owner, 1);
        game.updateStatus(owner);
    }

    @Test
    void isGameOver() throws IOException {
        Game game = new Game();
        game.setGame();
        game.getPlayers().remove(0);
        game.getPlayers().remove(0);
        game.getPlayers().remove(0);
        assertEquals(true, game.isGameOver());
    }

    @Test
    void buyHouseAttempt() throws IOException {
        Game game = new Game();
        game.setGame();
        Person testPlayer = game.getPlayers().get(0);
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        ((LandSquare) (squares.get(1))).buy(testPlayer);
        ((LandSquare) (squares.get(3))).buy(testPlayer);
        game.buyHouseAttempt(testPlayer);
        System.out.println(testPlayer.getOwnSquares().get(0) + "-" + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHouse() + " " + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHotel());
        game.buyHouseAttempt(testPlayer);
        System.out.println(testPlayer.getOwnSquares().get(0) + "-" + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHouse() + " " + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHotel());
        game.buyHouseAttempt(testPlayer);
        System.out.println(testPlayer.getOwnSquares().get(0) + "-" + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHouse() + " " + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHotel());
        game.buyHouseAttempt(testPlayer);
        System.out.println(testPlayer.getOwnSquares().get(0) + "-" + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHouse() + " " + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHotel());
        game.buyHouseAttempt(testPlayer);
        System.out.println(testPlayer.getOwnSquares().get(0) + "-" + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHouse() + " " + ((LandSquare) testPlayer.getOwnSquares().get(0)).getNumberOfHotel());
    }
}