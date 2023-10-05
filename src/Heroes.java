import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Heroes extends  Person{

    private String lastName;

    private int money;
    private ArrayList<Item> items = new ArrayList<Item>();

    private Scanner scan = new Scanner(System.in);

    public Heroes(String name, String lastName, int money) {
        Random liczba = new Random();
        this.strong = liczba.nextInt(10);
        this.defend = liczba.nextInt(10);
        this.name = name;
        this.lastName = lastName;
        this.money = money;


    }
    public Heroes (String name, String lastName, int money,int strong,int defend){
        this.strong = strong;
        this.defend = defend ;
        this.name = name;
        this.lastName = lastName;
        this.money = money;

    }

    public void display() {
        System.out.println("Do sklepu przychodzi heros:");
        System.out.println("Imie : " + name + " " + lastName);
        System.out.println("Aktualnie posiadane atrybuty :");
        System.out.println("Sila:" + strong);
        System.out.println("Obrona:" + defend);
        System.out.println("Monety:" + money);

    }

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
            setMoney(items.get(i).getProductPrice() + getMoney()); //zwiekszam atrybut Monety bohatera
            delEquipment(items.get(i));
            i--;
        }
        System.out.println("Bohater po sprzedazy : ");
        display();
    }

    public void buyItems(Store skillStore) {
        System.out.println("Ilosc pieniendzy przed zakupami: " + money);

        Random index  = new Random() ;
        //index.

        for (Item skillItem : skillStore.getAssortment()) {
            skillItem.display(); //wyswietl co mozna kupic
            if (money < skillItem.getProductPrice()) {
                System.out.println("Niestety nie stac mnie na ten przedmiot");
                continue;
            }
            if (skillStore.action("BUY")) {
                setSkill(skillItem.toString());
                setMoney(money - skillItem.getProductPrice()); //zmniejszam atrybut Monety bohatera
                setDefend(defend+ skillItem.getProductDefend() );
                setStrong(strong + skillItem.getProductStrong());
                displaySkill() ;
            }
        }
        display();
    }
    public void displaySkill() {
        System.out.println("Sila:" + strong);
        System.out.println("Obrona:" + defend);
        System.out.println("Monety:" + money);
    }
    public void setSkill(String skillName) {
        if (Objects.equals(skillName, "STRONG")) {
            setStrong(strong + 31);
        } else if (Objects.equals(skillName, "DEFEND")) {
            setDefend(defend + 23);
        }
    }


    public String getName() {
        return name + lastName;
    }
}




