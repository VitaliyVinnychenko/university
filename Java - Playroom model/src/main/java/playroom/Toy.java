// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

public class Toy {
    protected float price;
    protected float weight;
    protected String type;

    public Toy(float price, float weight, String type){
        this.price = price;
        this.weight = weight;
        this.type = type;
    }

    public float getPrice(){
        return this.price;
    }

    public float getWeight(){
        return this.weight;
    }

    public String getType(){
        return this.type;
    }

}
