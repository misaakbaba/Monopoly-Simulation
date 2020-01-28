import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportationSquareTest {

    @Test
    void rent() {
        Person owner = new Person("", 1000000);
        Person renter = new Person("", 1000000);
        TransportationSquare square = new TransportationSquare("metro", 100000);
        System.out.println("owner money" + owner.getCurrentBalance());
        System.out.println("renter money" + owner.getCurrentBalance());
        square.buy(owner);
        square.rent(owner, renter);
        System.out.println("owner money" + owner.getCurrentBalance());
        System.out.println("renter money" + owner.getCurrentBalance());

    }

    @Test
    void buy() {
        Person person = new Person("", 1000);
        TransportationSquare square = new TransportationSquare("test", 100);
        square.buy(person);
        assertEquals(square, person.getOwnSquares().get(0));
        System.out.println(person.getOwnSquares());
    }
}