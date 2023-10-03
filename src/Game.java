import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    public void startPlay() {
        Heroes myHero = new Heroes("Joanna", "Odwazna", 0); // tworzenie domyslnego bohatera
        myHero.display();//wyswietl stan bohatera
        ArrayList<Item> equipmentItems = myHero.getItems(); //pobieram ekwipunek bohatera --  jak to zrobic lepiej / inaczej ? czy tworzyc get w klasie Heroes ? - musialem teraz zrobic public z polem items
        myHero.sellItems() ;

        /*   Item[] skillItems = new Item[2];
        skillItems[0] = new Item("SILA", 70);
        skillItems[1] = new Item("OBRONA", 80);*/


       /* if (myHero.checkMoney(myHero.getMoney())) {
            System.out.println("Czy chcesz cos kupic ? ");
            response = scan.next();
            if (Objects.equals(response, "TAK")) {
                for (Item value : skillItems) {
                    value.display();
                    System.out.println("Czy chcesz kupic ta  umiejetnosc ?(kosztuje :) " + value.getPrice());
                    response = scan.next();
                    if (Objects.equals(response, "TAK")) {
                        System.out.println("Kupujesz umiejetnosc !");
                    } else {
                        System.out.println("Nie kupujesz umiejetnosc !");
                    }
                }
            }
        }*/
    }
}
