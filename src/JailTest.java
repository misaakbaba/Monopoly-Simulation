import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailTest {


    @Test
    void getExitPrice() {
        Jail jail = new Jail(100);
        assertEquals(100, jail.getExitPrice());
    }
}