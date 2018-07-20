package chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testCreate() {
        assertEquals(0, board.getNumberOfPawns());

        final Pawn whitePawn = new Pawn(Pawn.WHITE);
        board.add(whitePawn);
        assertEquals(1, board.getNumberOfPawns());
        assertEquals(whitePawn, board.get(0));

        final Pawn blackPawn = new Pawn(Pawn.BLACK);
        board.add(blackPawn);
        assertEquals(2, board.getNumberOfPawns());
        assertEquals(whitePawn, board.get(0));
        assertEquals(blackPawn, board.get(1));
    }
}
