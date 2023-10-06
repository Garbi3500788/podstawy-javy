package kwiaciarnia;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
public class Box {
    private Customer customer;
    private LinkedList<Flower> flowers;
    Box(Customer customer) {
        this.customer = customer;
        this.flowers = customer.getBox();
    }
    @Override
    public String toString() {
        String result;
        result = "Pudełko własciciel : " + customer.getName() + "\n";
        for (Flower flower : flowers) {
            result = result + flower.getName() + " kolor :" + flower.getColour() + " ilosc :" + flower.getCount() + " cena :" + flower.getPrice() + "\n";
        }
        return result;
    }
    public double getCountFlower(String flowerColor) {
        return flowers.stream()
                .filter(flower -> flower.getColour().equals(flowerColor))
                .mapToDouble(flower->flower.getTotalPrice())
                .sum();

    }
}
