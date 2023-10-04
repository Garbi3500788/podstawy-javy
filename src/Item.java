import java.util.Random;

public class Item {
    private String productName;
    private int productPrice;

    private int productStrong ;
    private int productDefend ;

    public Item(String name,  int  productStrong, int productDefend) {
        Random price = new Random();

        this.productName = name;
        this.productPrice = price.nextInt(15);
        this.productStrong = productStrong ;
        this.productDefend = productDefend ;
    }
    public void display() {
        System.out.println("Nazwa : " + productName );
        System.out.println("Cena  : " + productPrice );
        System.out.println("sila  : " + productStrong );
        System.out.println("obrona  : " + productDefend );
    }
     public int getProductPrice() {
        return productPrice;
    }
    public int getProductStrong(){
        return productStrong ;
    }
    public int getProductDefend(){
        return productDefend ;
    }

}
