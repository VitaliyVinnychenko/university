// Created 02/22/2017 by Vitaliy Vinnichenko (v1.0)

package playroom;

import java.util.ArrayList;
import java.util.Comparator;

public class Playroom {
    private int capability;
    private int toysNumber = 0;
    private float totalToysPrice = 0;

    private ArrayList<Toy> availableToys = new ArrayList<Toy>();

    public Playroom(int capability) {
        this.capability = capability;
    }

    public float getTotalToysPrice() {
        return this.totalToysPrice;
    }

    public void clearAvailableToys() {
        this.availableToys.clear();
    }

    /*
     * show playroom info method
     */
    @Override
    public String toString() {
        return "Capability: " + this.capability + "\nNumber of toys: "
                + this.toysNumber + "\nTotal price: "
                + this.totalToysPrice + "\n";
    }

    /*
     * prints out elements from available toys array
     */
    public String showAvailableToys() {
        StringBuffer buf = new StringBuffer();

        for (Toy counter : this.availableToys) {
            buf.append(counter.toString());
            buf.append('\n');
        }

        return buf.toString();
    }

    /*
     * pushes toy to the array of available toys in playroom
     */
    public void pushToy(final Toy object) {
        this.availableToys.add(object);
        this.toysNumber++;
    }

    /*

     * calculate total price method
     */
    public void calculateTotalToysPrice() {
        for (Toy counter : this.availableToys) {
            this.totalToysPrice += counter.getPrice();
        }
    }

    /*
     * sorting toys by price method
     */
    public void sortToysByPrice() {
        this.availableToys.sort(Comparator.comparing(Toy::getPrice));
    }

    /*
     * search toys by type method
     */
    public String searchToysByType(final String type) {
        StringBuffer buf = new StringBuffer();
        String input = type.toLowerCase();

        for (Toy counter : this.availableToys) {
            String text = counter.getType().toLowerCase();
            if (input.equals(text)) {
                buf.append(counter.toString());
                buf.append('\n');
            }
        }
        return buf.toString();
    }
}
