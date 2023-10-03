import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Heroes {
    private String name;
    private String lastName;

    private int strong;
    private int defend;
    private int money;

    private ArrayList<Item> items;
    public ArrayList<Item> skils;

    public Heroes(String imie, String nazwisko, int monety) {
        Random liczba = new Random();
        items = new ArrayList<Item>();
        strong = liczba.nextInt(101);
        defend = liczba.nextInt(101);
        name = imie;
        lastName = nazwisko;
        money = monety;
        items.add(0, new Item("ZBROJA", 10));
        items.add(1, new Item("MIECZ", 20));
        items.add(2, new Item("TARCZA", 30));
        items.add(3, new Item("HELM", 40));
    }

    public void display() {
        System.out.println("Do sklepu przychodzi heros:");
        System.out.println("Imie : " + name + " " + lastName);
        System.out.println("Aktualnie posiadane atrybuty :");
        System.out.println("Sila:" + strong);
        System.out.println("Obrona:" + defend);
        System.out.println("Monety:" + money);
        System.out.println("Aktualny ekwipunek : ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ":" + items.get(i).getProductName());
        }
    }

    //dlaczego jak zmnienie na static to nie moge przypisywac do money
    public void setMoney(int updateMoney) {
        money = updateMoney;
    }

    int getMoney() {
        return money;
    }

    public boolean checkMoney(int money) {
        if (money >= 100) {
            System.out.println("Mozesz zaczac kupowac sile i obrone");
            return true;
        } else return false;
    }

    public void setStrong(int updateStrong) {
        strong = updateStrong;
    }

    public void setDefend(int updateDefend) {
        defend = updateDefend;
    }

    public void delEquipment(int elementEqiupment) {
        System.out.println("Aktualny rozmiar tablicy :" + items.size()) ;
        System.out.println("usuwam element :" + elementEqiupment);
        items.remove(elementEqiupment);

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void sellItems() {
        Scanner scan = new Scanner(System.in);
        String response;
        int[] delEqipments = new int[items.size()];
        int counter = 0;
        for (int i = 0; i < items.size(); i++) { //po kazdym elemencie z aktualnego ekwipunku
                System.out.println("*******");
                items.get(i).display(); //wyswietl atrybuty ekwipunku
                System.out.println("Czy chcesz sprzedac ten przedmiot ? ");
                response = scan.next();
                if (Objects.equals(response, "TAK")) {
                    System.out.println("Sprzedajesz przedmiot !");
                    setMoney(items.get(i).getPrice() + getMoney()); //zwiekszam atrybut Monety bohatera
                    // delEquipment(i);    // usuwam sprzedany ekwipunek
                    delEqipments[counter] = i;
                    counter ++ ;
                } else {
                    System.out.println("Zostawiasz przedmiot !");
                }
        }
        System.out.println("delEqipments.clone().length : " + delEqipments.clone().length);
        System.out.println("delEqipments.length : " + delEqipments.length);

        for (int i = 0; i < delEqipments.length; i++) {
            System.out.println("Probuje usunac element listy : " + i);
            delEquipment(i);
            System.out.println("Usunieto elemt  listy : " + i);
        }
        System.out.println("Bohater po sprzedazy : ");
        display();
       /* for (Item equipmentItem : items) {
            System.out.println("*******");
            equipmentItem.display(); //wyswietl atrybuty ekwipunku
            System.out.println("Czy chcesz sprzedac ten przedmiot ? ");
            response = scan.next();
            if (Objects.equals(response, "TAK")) {
                System.out.println("Sprzedajesz przedmiot !");
                setMoney(equipmentItem.getPrice() + getMoney()); //zwiekszam atrybut Monety bohatera
                //   delEquipment(items.indexOf(equipmentItem)) ;    // usuwam sprzedany ekwipunek
            } else {
                System.out.println("Zostawiasz przedmiot !");
            }
            display();
        }*/
    }
}


