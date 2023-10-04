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
    private ArrayList<Item> items = new ArrayList<Item>();

    private Scanner scan = new Scanner(System.in);

    public Heroes(String imie, String nazwisko, int monety) {
        Random liczba = new Random();
        strong = liczba.nextInt(101);
        defend = liczba.nextInt(101);
        name = imie;
        lastName = nazwisko;
        money = monety;
        items.add(new Item("ZBROJA", 10));
        items.add(new Item("MIECZ", 20));
        items.add(new Item("TARCZA", 30));
        items.add(new Item("HELM", 40));
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
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void sellItems(Store skillStore) {
        for (int i = 0; i < items.size(); i++) { //po kazdym elemencie z aktualnego ekwipunku
            System.out.println("*******");
            items.get(i).display(); //wyswietl atrybuty ekwipunku
            if (!skillStore.action("SELL")) {
                System.out.println("Zostawiasz przedmiot !");
                continue;
            }
            System.out.println("Sprzedajesz przedmiot !");
            setMoney(items.get(i).getPrice() + getMoney()); //zwiekszam atrybut Monety bohatera
            delEquipment(items.get(i));
            i--;
        }
        System.out.println("Bohater po sprzedazy : ");
        display();
    }

    public void buyItems(Store skillStore) {
        System.out.println("Ilosc pieniendzy przed zakupami: " + money);

        for (Item skillItem : skillStore.getAssortment()) {
            skillItem.display(); //wyswietl co mozna kupic
            if (money < skillItem.getPrice()) {
                System.out.println("Niestety nie stac mnie na ten przedmiot");
                continue;
            }
            if (skillStore.action("BUY")) {
                setSkill(skillItem.getProductName());
                setMoney(money - skillItem.getPrice()); //zmniejszam atrybut Monety bohatera
                System.out.println("ile mam po kupnie: " + getMoney());
            }
        }
        display();
    }
    public void displaySkill() {
        System.out.println("Imie : " + name + " " + lastName);
        System.out.println("Sila:" + strong);
        System.out.println("Obrona:" + defend);
    }
    public void setSkill(String skillName) {
        if (Objects.equals(skillName, "STRONG")) {
            setStrong(strong + 31);
        } else if (Objects.equals(skillName, "DEFEND")) {
            setDefend(defend + 23);
        }
    }

    public int getSkills() {
        return strong + defend;
    }

    public String getName() {
        return name + lastName;
    }
}




