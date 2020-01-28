import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LandSquareTest {

    @Test
    void rent() { // house test
        ArrayList<Square> squares = new ArrayList<>();
        int rentPrice = 50;
        squares.add(new LandSquare("testLand", 100, rentPrice, 1));
        Board board = new Board(squares);
        Person owner = new Person("", 1000);
        Person renter = new Person("", 1000);
        int lastbalance1 = owner.getCurrentBalance();
        int lastbalance2 = renter.getCurrentBalance();
        int numberOfHouse = 4;
        ((LandSquare) squares.get(0)).setNumberOfHouse(numberOfHouse);
        ((LandSquare) squares.get(0)).rent(owner, renter);
        assertEquals(lastbalance1 + rentPrice * (numberOfHouse + 1), owner.getCurrentBalance());
        assertEquals(lastbalance2 - rentPrice * (numberOfHouse + 1), renter.getCurrentBalance());
    }

    @Test
    void rent2() { //hotel test
        ArrayList<Square> squares = new ArrayList<>();
        int rentPrice = 50;
        squares.add(new LandSquare("testLand", 100, rentPrice, 1));
        Board board = new Board(squares);
        Person owner = new Person("", 1000);
        Person renter = new Person("", 1000);
        int lastbalance1 = owner.getCurrentBalance();
        int lastbalance2 = renter.getCurrentBalance();

        ((LandSquare) squares.get(0)).setNumberOfHotel(1);
        ((LandSquare) squares.get(0)).rent(owner, renter);
        assertEquals(lastbalance1 + rentPrice * 8, owner.getCurrentBalance());
        assertEquals(lastbalance2 - rentPrice * 8, renter.getCurrentBalance());
    }

    @Test
    void buy() {
        ArrayList<Square> squares = new ArrayList<>();
        squares.add(new LandSquare("testLand", 100, 50, 1));
        squares.add(new LandSquare("testLand2", 100, 50, 1));
        Person owner = new Person("", 1000);
        ((Property) squares.get(0)).buy(owner);
        ((Property) squares.get(1)).buy(owner);
        assertEquals(squares, owner.getOwnSquares());
    }



    @Test
    void hasAllSameColourLand() throws IOException {
        Person person = new Person("", 100);
        Game game = new Game();
        game.setGame();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        person.getOwnSquares().add(((Property) squares.get(1)));
//        person.getOwnSquares().add(((Property) squares.get(3)));
        assertEquals(false, ((LandSquare) squares.get(1)).hasAllSameColourLand(person, game.getGameBoard()));

    }


}