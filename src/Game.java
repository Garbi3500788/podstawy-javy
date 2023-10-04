import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Store skillStore = new Store();
    private Heroes myHero = createHero("Joanna", "Odwazna", 25);

    private String name;
    private String lastName;
    private int money;

    public void startPlay() {
        Monster monster = new Monster() ;

        myHero.display();
        myHero.display();
        shopping();
        fighting(myHero,monster);
    }
    private void shopping() {
        if (myHero.getItems().size() != 0) {
            myHero.sellItems(skillStore);
        }
        if (myHero.getMoney() > 0) {
            myHero.buyItems(skillStore);
        }
        myHero.displaySkill();

    }

    private void fighting(Person fihter1 , Person fighter2) {
        System.out.println("Walczy  : " +  fihter1.getName() + "i : "+ fighter2.getName());
        System.out.println("Zebrane Umiejetnosci   : " +  fihter1.getSkills() + "i : "+ fighter2.getSkills());
        if (fihter1.getSkills() > fighter2.getSkills()) {
            System.out.println("Wygrywa bohater : " + fihter1.getName());
        } else if (fihter1.getSkills() < fighter2.getSkills()) {
            System.out.println("Wygrywa bohater : " + fighter2.getName());
        } else {
            System.out.println("REMIS");

        }
    }

    public Heroes createHero(String name, String lastName, int money) {

        Random liczba = new Random();
        int strong ;
        int defend ;

        do {
            strong = liczba.nextInt(4);
            defend = liczba.nextInt(4);
        } while (checkSkills(strong+defend));
        return new Heroes(name, lastName, money, strong, defend);

    }

    public boolean checkSkills(int skils) {
        if (skils == 4)
            return false;
        return true;
    }
}
