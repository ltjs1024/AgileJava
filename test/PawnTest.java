import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PawnTest
 */
public class PawnTest {
    @Test
    public void testCreate() {
        final String white = "white";
        final String black = "black";

        Pawn pawn = new Pawn(white);
        String color = pawn.getColor();
        assertEquals(white, color);

        Pawn secondPawn = new Pawn(black);
        String secondPawnColor = secondPawn.getColor();
        assertEquals(black, secondPawnColor);
    }
}
