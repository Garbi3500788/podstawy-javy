import java.sql.SQLOutput;
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

    public void delEquipment(Item item) {
        //System.out.println("Aktualny rozmiar tablicy :" + items.size()) ;
        //System.out.println("usuwam element :" + item);
        items.remove(item);

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void sellItems() {
        Scanner scan = new Scanner(System.in);
        String response;
        ArrayList<Item> delEqipments = new ArrayList<Item>();
        int counter = 0;
        for (int i = 0; i < items.size(); i++) { //po kazdym elemencie z aktualnego ekwipunku
            System.out.println("*******");
            items.get(i).display(); //wyswietl atrybuty ekwipunku
            System.out.println("Czy chcesz sprzedac ten przedmiot ? ");
            response = scan.next();
            if (Objects.equals(response, "TAK")) {
                System.out.println("Sprzedajesz przedmiot !");
                setMoney(items.get(i).getPrice() + getMoney()); //zwiekszam atrybut Monety bohatera
                delEquipment(items.get(i));
                i--;
                counter++;
            } else {
                System.out.println("Zostawiasz przedmiot !");
            }
        }

        System.out.println("Bohater po sprzedazy : ");
        display();

    }

    public void buyItems() {
        Scanner scan = new Scanner(System.in);
        String response;
        ArrayList<Item> skillItems = new ArrayList<Item>();
        skillItems.add(new Item("STRONG", 70));
        skillItems.add(new Item("DEFEND", 80));
        if (money != 0) {
            System.out.println("Mozesz kupowac umiejetnosci. Czy chcesz kupic ?");
            response = scan.next();
            if (Objects.equals(response, "TAK")) {
                for (int i = 0; i < skillItems.size(); i++) {
                    System.out.println("ile mam przed kupnem: " + getMoney());
                    System.out.println("cena :" + skillItems.get(i).getPrice());
                    if (getMoney() >= skillItems.get(i).getPrice()) {
                        skillItems.get(i).display(); //wyswietl co mozna kupic
                        System.out.println("Czy chcesz kupic ten przedmiot ? ");
                        response = scan.next();
                        if (Objects.equals(response, "TAK")) {
                            setSkill(skillItems.get(i).getProductName());
                            setMoney(getMoney() - skillItems.get(i).getPrice()); //zmniejszam atrybut Monety bohatera
                            System.out.println("ile mam po kupnie: " + getMoney());
                        }
                    } else {
                        System.out.println("Niestety brak srodkow do kupowania");
                    }
                    display();
                }
            }
        } else {
            System.out.println("Niestety brak srodkow do kupowania");
        }
    }

    private void displaySkill() {
        System.out.println("Umiejetnosci bohatera : ");
        System.out.println("Sila : " + strong);
        System.out.println("Obrona : " + defend);
    }

    public void setSkill(String skillName) {
        if (Objects.equals(skillName, "STRONG")) {
            setStrong(strong + 31);
        } else if (Objects.equals(skillName, "DEFEND")) {
            setDefend(defend + 23);
        }
    }
}




