import java.util.ArrayList;

public class Game {
    private Store skillStore = new Store("SKILL_STORE");
    private Heroes myHero = new Heroes("Joanna", "Odwazna", 0); // tworzenie domyslnego bohatera
    private Heroes opponent = new Heroes("Przeciwnik", "Przeciwnik", 0);
    public void startPlay() {
        myHero.display();
        shopping();
        myHero.display();
        fighting();
    }
    private void shopping() {
        if(myHero.getItems().size() !=0) {
            myHero.sellItems(skillStore);
        }
        if (myHero.getMoney() > 0) {
            myHero.buyItems(skillStore);
        }
        myHero.displaySkill();
        opponent.displaySkill();
    }
    private void fighting() {
        if (myHero.getSkills() > opponent.getSkills()) {
            System.out.println("Wygrywa bohater : " + myHero.getName());
        } else if (myHero.getSkills() < opponent.getSkills()) {
            System.out.println("Wygrywa bohater : " + opponent.getName());
        } else {
            System.out.println("REMIS");

        }
    }
}
