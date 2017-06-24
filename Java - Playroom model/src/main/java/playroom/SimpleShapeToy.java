// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

public class SimpleShapeToy extends Toy{

    protected String color;

    public SimpleShapeToy(float price, float weight, String type, String color){
        super(price, weight, type);
        this.color = color;
    }
}
