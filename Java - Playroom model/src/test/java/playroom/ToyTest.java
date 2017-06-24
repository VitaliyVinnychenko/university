package playroom;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by Vinnichenko on 3/23/17.
 */
public class ToyTest {
    private Toy toy = new Toy(12.5f, 0.4f, "toy");

    @Test
    public void testGetPrice() throws Exception {
        assertEquals(12.5f, this.toy.getPrice());
    }

    @Test
    public void testGetWeight() throws Exception {
        assertEquals(0.4f, this.toy.getWeight());
    }

    @Test
    public void testGetType() throws Exception {
        assertEquals("toy", this.toy.getType());
    }

}