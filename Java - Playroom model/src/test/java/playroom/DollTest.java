/**
 * Created by Vinnichenko on 3/15/17.
 */

package playroom;

import org.junit.ComparisonFailure;
import org.junit.Test;
import static org.junit.Assert.*;

public class DollTest {

    private Doll doll = new Doll(3.75f,0.175f,"barbie","female","Hello, world!",21.0f, "yellow");
    @Test
    public void testSayPhrase() throws Exception {

        String expectedOutput = "Doll says: \"Hello, world!\"";
        assertEquals(expectedOutput, doll.sayPhrase());
    }

    @Test(expected=ComparisonFailure.class)
    public void testExceptionSayPhrase(){

        String expectedOutput = "Doll says: \"Hello, world\"";
        assertEquals(expectedOutput, doll.sayPhrase());
    }
}