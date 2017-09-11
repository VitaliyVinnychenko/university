// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

public class Car extends Toy {
    private float width;
    private float length;
    private String color;

    public Car(float price, float weight, String type, float width, float length, String color){
        super(price, weight, type);
        this.width = width;
        this.length = length;
        this.color = color;
    }

    /**
     * show info about car
     */
    @Override
    public String toString(){
        return "Price: " + this.price +
                "\nWeight: " + this.weight +
                "\nType: " + this.type +
                "\nColor: " + this.color +
                "\nWidth: " + this.width +
                "\nLength: " + this.length + "\n";
    }
}
