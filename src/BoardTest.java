import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getGameboard() {
        ArrayList<Square> squares = new ArrayList<>();
        Board board = new Board(squares);
        assertEquals(squares, board.getGameboard());
    }
}