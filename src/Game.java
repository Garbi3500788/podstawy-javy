import java.util.Objects;
import java.util.Scanner;

public class Game {
    public void startPlay() {
        Heroes heroes1 = new Heroes("Joanna", "Odwazna", 0);
        heroes1.display();

        Product[] equipmentProducts = new Product[4];

// jak uporzadkowac cennik produktow
        equipmentProducts[0] = new Product("ZBROJA", 10);
        equipmentProducts[1] = new Product("MIECZ", 20);
        equipmentProducts[2] = new Product("TARCZA", 30);
        equipmentProducts[3] = new Product("HELM", 40);

        Product[] skillProducts = new Product[2];
        skillProducts[0] = new Product("SILA", 70);
        skillProducts[1] = new Product("OBRONA", 80);
        Scanner scan = new Scanner(System.in);
        //  for (Product value : equipmentProducts) {
        String response;
        for (int i = 0; i < 4; i++) {


            System.out.println("*******");
            equipmentProducts[i].display();


            System.out.println("Czy chcesz sprzedac ten przedmiot ? ");

            response = scan.next();

            if (Objects.equals(response, "TAK")) {
                System.out.println("Sprzedajesz przedmiot !");
                heroes1.setMoney(equipmentProducts[i].getPrice() + heroes1.getMoney());

            } else
                System.out.println("Zostawiasz przedmiot !");

            heroes1.display();
        }

        if (heroes1.checkMoney(heroes1.getMoney())) {
            System.out.println("Czy chcesz cos kupic ? ");
            response = scan.next();
            if (Objects.equals(response, "TAK")) {
                for (Product value : skillProducts) {
                    value.display();
                    System.out.println("Czy chcesz kupic ta  umiejetnosc ?(kosztuje :) " + value.getPrice());
                    response = scan.next();
                    if (Objects.equals(response, "TAK")) {
                        System.out.println("Kupujesz umiejetnosc !");


                    } else
                        System.out.println("Nie kupujesz umiejetnosc !");
                }
            }
        }
        ;

        //   }


    }
}
