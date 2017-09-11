// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

public class Doll extends Toy {
    private String sex;
    private String phrase;
    private float height;
    private String hairColor;

    public Doll(float price,
         float weight,
         String type,
         String sex,
         String phrase,
         float height,
         String hairColor)
    {
        super(price, weight, type);
        this.sex = sex;
        this.phrase = phrase;
        this.height = height;
        this.hairColor = hairColor;
    }

    public String sayPhrase(){                // prints out the doll`s phrase
        return "Doll says: \"" + this.phrase + "\"";
    }

    /**
     * show info about car
     */
    @Override
    public String toString(){
        return "Price: " + this.price +
                "\nWeight: " + this.weight +
                "\nType: " + this.type +
                "\nHair color: " + this.hairColor +
                "\nSex: " + this.sex +
                "\nHeight: " + this.height + "\n";
    }
}
