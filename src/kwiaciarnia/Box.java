package kwiaciarnia;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private Customer customer;

    public Box(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        String result;
        List<Flower> flowers = customer.getBox();
        result = "Pudełko własciciel : " + customer.getName() + "/";
        for (Flower flower : flowers) {
            result = result + flower.getName() + "kolor :" + flower.getColour() + "ilosc :" + flower.getCount() + "cena :" + flower.getPrice();
        }
        return result;
    }
}
