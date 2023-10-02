import java.util.Random;

public class Heroes {
    private String name;
    private String lastName;

    private int strong;
    private int defend;
    private int money;

    public Heroes(String imie, String nazwisko, int monety) {

        Random liczba = new Random();
        strong = liczba.nextInt(101);
        defend = liczba.nextInt(101);

        name = imie;
        lastName = nazwisko;
        money = monety;
    }

    public void display() {

        System.out.println("Do sklepu przychodzi heros:");
        System.out.println("Imie : " + name + " " + lastName);
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
}


