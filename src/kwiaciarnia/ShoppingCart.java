package kwiaciarnia;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart  {
    private List<Flower> shoppingCart = new ArrayList<Flower>();

    String name ;

    public ShoppingCart(String name) {
        this.name = name ;
    }

    public void addToCart(Flower flower) {
        shoppingCart.add(flower);
    }
    public ShoppingCart getShoppingCart() {
        return this;
    }

    @Override
    public String toString() {
        String result;
        result = "Wozek wlasciciel : " +  name + "\n";
        for (Flower flower : shoppingCart) {
            result = result + flower.getName() + " kolor : " + flower.getColour() + " ilosc : " + flower.getCount() + " cena : " + flower.getPrice();

        }
        return result;
    }
    public List<Flower> getShopping   () {
        return shoppingCart ;
    }
}
