/**
 * Created by Vinnichenko on 3/15/17.
 */

package playroom;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball ball = new Ball(12.5f, 0.342f, "football", "white", 15);

    @Test
    public void testCalculateToyVolume() throws Exception {

        this.ball.calculateToyVolume();
        assertEquals(10602.875205865552, this.ball.getVolume(), 0.00001);
    }
}