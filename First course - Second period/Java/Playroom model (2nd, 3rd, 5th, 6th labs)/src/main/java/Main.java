// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

import playroom.*;

public class Main {
    public static void main(String [] args) {

        Playroom kidsRoom = new Playroom(10);

        Ball ball = new Ball(12.5f, 0.342f, "football", "white", 15);
        ball.calculateToyVolume();

        Cube cube = new Cube(0.5f, .01f, "playcube","red", 5.0f);
        cube.calculateToyVolume();

        Car car = new Car(150.0f, 2.3f,"Nissan",0.15f,0.38f,"silver");
        Doll doll = new Doll(3.75f,0.175f,"barbie","female","Hello, world!",21.0f, "yellow");

        kidsRoom.pushToy(ball);
        kidsRoom.pushToy(cube);
        kidsRoom.pushToy(car);
        kidsRoom.pushToy(doll);

        System.out.println("Print out unsorted array:\n");
        System.out.println(kidsRoom.showAvailableToys());

        kidsRoom.sortToysByPrice();
        kidsRoom.calculateTotalToysPrice();

        System.out.println("\nPrint out info about playroom:\n");
        System.out.println(kidsRoom.toString());

        System.out.println("\nPrint out sorted array:\n");
        System.out.println(kidsRoom.showAvailableToys());

        String type = "playcube";
        System.out.println("\nSearch request: \"" + type + "\"\n");
        System.out.print(kidsRoom.searchToysByType(type));
    }
}
