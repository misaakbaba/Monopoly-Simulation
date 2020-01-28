import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PublicCorporationSquareTest {

    @Test
    void rent() throws IOException {
        Game game = new Game();
        game.setGame();
        ArrayList<Square> squares = game.getGameBoard().getGameboard();
        ArrayList<Person> players = game.getPlayers();
        Person owner = players.get(0);
        Person renter = players.get(1);
        owner.setCurrentBalance(999999999);
        for (int i = 0; i < squares.size(); i++) {
            if (squares.get(i) instanceof Property) {
                ((Property) squares.get(i)).buy(owner);
            }
        }
        System.out.println(renter.getCurrentBalance());
        game.move(renter, 12);
        ((Property) squares.get(12)).rent(owner, renter);
        System.out.println(renter.getCurrentBalance());
    }

    @Test
    void buy() {
        Person person = new Person("", 1000);
        PublicCorporationSquare corporationSquare = new PublicCorporationSquare("test", 100, 50);
        corporationSquare.buy(person);
        assertEquals(corporationSquare, person.getOwnSquares().get(0));
    }
}