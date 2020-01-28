import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getName() {
    }

    @Test
    void getCurrentBalance() {
        Person testPerson = new Person("", 100);
        assertEquals(100, testPerson.getCurrentBalance());
    }

    @Test
    void getPosition() {
        Person person = new Person("", 100);
        person.setPosition(5);
        assertEquals(5, person.getPosition());
    }

    @Test
    void getInJail() {
        Person person = new Person("", 100);
        person.setInJail(true);
        assertEquals(true, person.getInJail());
    }

    @Test
    void getOwnSquares() {
        Person person = new Person("", 100);
        Square square1 = new LandSquare("", 100, 50, 1);
        Square square2 = new LandSquare("", 100, 50, 1);
        person.getOwnSquares().add((Property) square1);
        person.getOwnSquares().add((Property) square2);
        ArrayList<Square> squareArrayList = new ArrayList<>();
        squareArrayList.add(square1);
        squareArrayList.add(square2);
        assertEquals(squareArrayList, person.getOwnSquares());
    }

    @Test
    void hasSquare() {
        Person person = new Person("", 100);
        Square square1 = new LandSquare("testName1", 100, 50, 1);
        Square square2 = new LandSquare("testName2", 100, 50, 1);
        person.getOwnSquares().add((Property) square1);
        person.getOwnSquares().add((Property) square2);
        assertEquals(true, person.hasSquare(((Property) square1).nameOfSquare));
    }

    @Test
    void hasColor() {
        Person person = new Person("", 100);
        person.getOwnSquares().add(new LandSquare("", 100, 50, 1));
        assertEquals(true, person.hasColor(1));
    }
}