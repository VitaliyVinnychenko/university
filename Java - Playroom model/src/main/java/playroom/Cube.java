// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

public class Cube extends SimpleShapeToy {

    private float edgeLength;
    private double volume;

    public Cube(float price, float weight, String type, String color, float edgeLength){
        super(price, weight, type, color);
        this.edgeLength = edgeLength;
    }

    public double getVolume(){
        return this.volume;
    }

    /**
     * calculate cube volume method
     */
    public void calculateToyVolume(){
        this.volume = this.edgeLength * this.edgeLength * this.edgeLength;
    }

    /**
     * show info about toy
     */
    @Override
    public String toString(){
        return "Price: " + this.price +
                "\nWeight: " + this.weight +
                "\nType: " + this.type +
                "\nColor: " + this.color +
                "\nEdge length: " + this.edgeLength +
                "\nVolume: " + this.volume + "\n";
    }
}
