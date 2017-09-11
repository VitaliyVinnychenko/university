// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

import java.lang.Math;

public class Ball extends SimpleShapeToy {

    private int radius;
    private double volume;

    public Ball(float price, float weight, String type, String color, int radius){
        super(price, weight, type, color);
        this.radius = radius;
    }

    public double getVolume(){
        return this.volume;
    }

    /*
     * calculate ball volume method
     */
    public void calculateToyVolume(){
        this.volume = 4 / 3 * Math.PI * this.radius * this.radius * this.radius;
    }

    /*
     * show info about toy
     */
    @Override
    public String toString(){
        return "Price: " + this.price +
                "\nWeight: " + this.weight +
                "\nType: " + this.type +
                "\nColor: " + this.color +
                "\nRadius: " + this.radius +
                "\nVolume: " + this.volume + "\n";
    }
}
