/**
 * Created by Vinnichenko on 3/15/17.
 */

package playroom;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CubeTest {

    private Cube cube = new Cube(0.5f, .01f, "playcube","red", 5.0f);

    @Test
    public void testCalculateToyVolume() throws Exception {

        this.cube.calculateToyVolume();
        assertEquals(125.0, this.cube.getVolume(), 0.00001);
    }

}