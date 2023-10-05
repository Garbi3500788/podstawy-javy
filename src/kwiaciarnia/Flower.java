package kwiaciarnia;

import java.util.ArrayList;

public class Flower {
    private String colour;
    private int count;
    private double price;
    private String name;

    public Flower(String name, String colour, int count) {
        this.name = name;
        this.colour = colour;
        this.price = PriceList.getInstance().getPrice(name);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }
}

