import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Store {

    private ArrayList<Item> shopItems = new ArrayList<Item>();

    public Store() {
        shopItems.add(new Item("STRONG", 70,10));
        shopItems.add(new Item("DEFEND", 70,15));
        shopItems.add(new Item("ZBROJA", 10,20));
        shopItems.add(new Item("MIECZ", 20,0));
        shopItems.add(new Item("TARCZA", 30,0));
        shopItems.add(new Item("HELM", 40,0));
    }

    public ArrayList<Item> getAssortment() {
        return shopItems;
    }
    public  boolean action(String what) {
        Scanner scan = new Scanner(System.in);
        if (Objects.equals(what, "SELL")) {
            System.out.println("Czy chcesz sprzedac ten przedmiot ? ");
            if (Objects.equals(scan.next(), "TAK")) {
                return true;
            }
        } else if (Objects.equals(what, "BUY")) {
            System.out.println("Czy chcesz kupic ten przedmiot ? ");
            if (Objects.equals(scan.next(), "TAK")) {
                return true;
            }
        }
        return false;
    }
}
