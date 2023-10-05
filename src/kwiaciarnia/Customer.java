package kwiaciarnia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private double money;
    private ShoppingCart sC;

    private List<Flower> myBox = new ArrayList<Flower>();

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
        sC = new ShoppingCart(name);
    }

    public void add(Flower flower) {
        sC.addToCart((flower));
    }

    public ShoppingCart getShoppingCart() {
        return sC.getShoppingCart();
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return money;
    }

    public void pay() {
        ArrayList<PricePosition> pp = PriceList.getInstance().getPrices();
        for (int i = 0; i < sC.getShoppingCart().getShopping().size(); i++) { // iteracja po produktach w koszyku
            for (int j = 0; j < pp.size(); j++) {   //iteracja po produktach na liscie cen
                if (Objects.equals(sC.getShoppingCart().getShopping().get(i).getName(), pp.get(j).getFlowerName()) && money >= pp.get(j).getFlowerPrice()*sC.getShoppingCart().getShopping().get(i).getCount()) { //nazwa produktu znajduje sie na liscie i klient ma kase na ten produkt
                    money = money - sC.getShoppingCart().getShopping().get(i).getPrice(); // stac mnie na zakupc tej ilosci kwiatow co mam w koszyku
                }else {
                    sC.getShoppingCart().getShopping().remove(i);           // usuwam  z koszyka
                }

            }
        }
    }

    public void pack(Box box) {
        for (int i = 0; i < sC.getShoppingCart().getShopping().size(); i++) {
            myBox.add(sC.getShoppingCart().getShopping().get(i));//doodaje do pudelka
            sC.getShoppingCart().getShopping().remove(i);           // usuwam  z koszyka

            i--;
        }
    }

    public List<Flower> getBox() {
        return myBox;
    }

}

