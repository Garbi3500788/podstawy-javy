public class Product {

    private String productName;
    private int productPrice;

    public Product(String name, int price) {

        productName = name;
        productPrice = price;
    }

    public void display() {


        System.out.println("Nazwa : " + productName );
        System.out.println("Cena  : " + productPrice );

    }

     int getPrice() {
        return productPrice;
    }
    String getProductName(){
        return productName ;
    }
}
