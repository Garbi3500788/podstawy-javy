package kwiaciarnia;

import java.util.ArrayList;

public class PriceList {
    private ArrayList<PricePosition> prices = new ArrayList<>();

    private static PriceList priceList = new PriceList();
    private PriceList() {
    }

    public void put(String flowerName, double flowerPrice) {
        prices.add(new PricePosition(flowerName,flowerPrice));
    }

    public  static PriceList getInstance() {
        return priceList ;
    }

    public  double getPrice(String name){

        for (PricePosition price : prices) {
            if (price.getFlowerName().equals(name) ) {
                return price.getFlowerPrice();
            }


        }
        return 0 ;
    }

    public ArrayList<PricePosition> getPrices() {
        return prices;
    }
}