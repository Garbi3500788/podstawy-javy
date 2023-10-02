import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Heroes heroes1 = new Heroes("Joanna", "Odwazna", 25);
        heroes1.display();

        Products product = new Products("srebrna zbroja", 15);

        System.out.println("*******");

        product.display();


        Scanner scan = new Scanner(System.in);

        System.out.println("Czy chcesz sprzedac ten przedmiot ? ");

        String response = scan.next();

        if (response == "TAK") {
            System.out.println("Sprzedajesz przedmiot !");

            heroes1.setMoney(heroes1.getMoney() + product.getPrice());

        }else
            System.out.println("Zostawiasz przedmiot !") ;

        heroes1.display();


    }

}