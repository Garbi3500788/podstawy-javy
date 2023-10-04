import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Store {
    private String shopName;
    private ArrayList<Item> shopItems = new ArrayList<Item>();

    public Store(String shopName) {
        shopItems.add(new Item("STRONG", 70));
        shopItems.add(new Item("DEFEND", 80));
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
