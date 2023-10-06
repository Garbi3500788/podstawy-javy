package kwiaciarnia;

import java.util.*;

public class Customer {
    private String name;
    private double money;
    private ShoppingCart shoppingCart;
    private LinkedList<Flower> myBox;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
        shoppingCart = new ShoppingCart(name);
        myBox = new LinkedList<>();
    }

    public void addToCart(Flower flower) {
        shoppingCart.addToCart((flower));
    }
    public void pay() {
        Set<Flower> delElements = new HashSet<Flower>();
        for (Flower flower : shoppingCart.getShoppingCart().getShopping()) {
            if (flower.getPrice() == -1 || money < flower.getTotalPrice()) {
                delElements.add(flower);
            } else {
                money -= flower.getTotalPrice();
            }
        }
        shoppingCart.remove(delElements);

    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return money;
    }


    public void pack(Box box) {
        myBox.addAll(shoppingCart.getShoppingCart().getShopping());
        shoppingCart.clearCard();
    }

    public LinkedList<Flower> getBox() {
        return myBox;
    }

}

