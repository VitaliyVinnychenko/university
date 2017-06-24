/**
 * Created by Vinnichenko on 3/15/17.
 */

package playroom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class PlayroomTest {

    private Playroom pr = new Playroom(10);

    @Test
    public void testShowAvailableToys() throws Exception {

        String expectedOutput  = "Price: 12.5\n" +
                "Weight: 0.342\n" +
                "Type: football\n" +
                "Color: white\n" +
                "Radius: 15\n" +
                "Volume: 10602.875205865552\n" +
                "\n" +
                "Price: 0.5\n" +
                "Weight: 0.01\n" +
                "Type: playcube\n" +
                "Color: red\n" +
                "Edge length: 5.0\n" +
                "Volume: 125.0\n" +
                "\n" +
                "Price: 150.0\n" +
                "Weight: 2.3\n" +
                "Type: Nissan\n" +
                "Color: silver\n" +
                "Width: 0.15\n" +
                "Length: 0.38\n" +
                "\n" +
                "Price: 3.75\n" +
                "Weight: 0.175\n" +
                "Type: barbie\n" +
                "Hair color: yellow\n" +
                "Sex: female\n" +
                "Height: 21.0\n\n";

        assertEquals(expectedOutput, this.pr.showAvailableToys());
    }

    @Test
    public void getSearchToysByType() throws Exception{

        String expectedOutput = "Price: 0.5\n" +
                "Weight: 0.01\n" +
                "Type: playcube\n" +
                "Color: red\n" +
                "Edge length: 5.0\n" +
                "Volume: 125.0\n\n";

        assertEquals(expectedOutput, this.pr.searchToysByType("playcube"));
    }

    @Test
    public void testSortToysByPrice(){

        this.pr.sortToysByPrice();

        String expectedOutput = "Price: 0.5\n" +
                "Weight: 0.01\n" +
                "Type: playcube\n" +
                "Color: red\n" +
                "Edge length: 5.0\n" +
                "Volume: 125.0\n" +
                "\n" +
                "Price: 3.75\n" +
                "Weight: 0.175\n" +
                "Type: barbie\n" +
                "Hair color: yellow\n" +
                "Sex: female\n" +
                "Height: 21.0\n" +
                "\n" +
                "Price: 12.5\n" +
                "Weight: 0.342\n" +
                "Type: football\n" +
                "Color: white\n" +
                "Radius: 15\n" +
                "Volume: 10602.875205865552\n" +
                "\n" +
                "Price: 150.0\n" +
                "Weight: 2.3\n" +
                "Type: Nissan\n" +
                "Color: silver\n" +
                "Width: 0.15\n" +
                "Length: 0.38\n\n";

        assertEquals(expectedOutput, this.pr.showAvailableToys());
    }

    @Test
    public void testCalculateTotalToysPrice(){

        this.pr.calculateTotalToysPrice();
        assertEquals(166.75f, this.pr.getTotalToysPrice(), 0.001);
    }

    @BeforeEach
    private void preparation(){
        this.pr.clearAvailableToys();

        Ball ball = new Ball(12.5f, 0.342f, "football", "white", 15);
        ball.calculateToyVolume();

        Cube cube = new Cube(0.5f, .01f, "playcube","red", 5.0f);
        cube.calculateToyVolume();

        Car car = new Car(150.0f, 2.3f,"Nissan",0.15f,0.38f,"silver");
        Doll doll = new Doll(3.75f,0.175f,"barbie","female","Hello, world!",21.0f, "yellow");

        this.pr.pushToy(ball);
        this.pr.pushToy(cube);
        this.pr.pushToy(car);
        this.pr.pushToy(doll);
    }

}