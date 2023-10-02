import java.util.Random;

public class Products {

    private String productName;
    private int price;

    public Products(String name, int price) {

        productName = name;
        price = price;
    }

    public void display() {


        System.out.println("Nazwa : " + productName );
        System.out.println("Cena  : " + price );

    }

    int getPrice() {
        return price;
    }
}
