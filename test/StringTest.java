import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTest {

    @Test
    public void testChar() {
        char capitalA = 'A';
        assertEquals(65, capitalA);
        assertEquals('\u0041', capitalA);
        assertEquals('\101',capitalA);
    }
}
