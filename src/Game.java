import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    public void startPlay() {
        Heroes myHero = new Heroes("Joanna", "Odwazna", 0); // tworzenie domyslnego bohatera
        myHero.display();//wyswietl stan bohatera
        myHero.sellItems() ;
        myHero.buyItems() ;

    }
}
