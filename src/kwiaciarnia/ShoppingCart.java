package kwiaciarnia;

import java.util.*;

public class ShoppingCart  {
    private LinkedList<Flower> shoppingCart = new LinkedList<>() ;
    String name ;
    public ShoppingCart(String name) {
        this.name = name ;
    }

    public void addToCart(Flower flower) {
        shoppingCart.add(flower);
    }
    public void clearCard(){
        shoppingCart.clear();
    }
    public ShoppingCart getShoppingCart() {
        return this;
    }

    @Override
    public String toString() {
        String result;
        result = "Wozek wlasciciel : " +  name + "\n";
        for (Flower flower : shoppingCart) {
            result = result + flower.getName() + " kolor : " + flower.getColour() + " ilosc : " + flower.getCount() + " cena : " + flower.getPrice()+ "\n";

        }
        return result;
    }
    public LinkedList<Flower> getShopping   () {
        return new LinkedList<>(shoppingCart) ;
    }
    /*public List<Flower> getShopping2   () {
        return Collections.unmodifiableList(shoppingCart);
    }*/
    public void remove(Set<Flower> flowersToRemove){
        shoppingCart.removeAll(flowersToRemove) ;
    }

    public void x () {
        LinkedList<String> l = new LinkedList() ;

    }
}
