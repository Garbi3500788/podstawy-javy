package kwiaciarnia;

public class PricePosition {
    private double flowerPrice;
    private String flowerName;

    public PricePosition(String flowerName, double flowerPrice) {
        this.flowerPrice = flowerPrice;
        this.flowerName = flowerName;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }

    public String getFlowerName() {
        return flowerName;
    }
}
