package Movie;

import Price.ChildrensPrice;
import Price.Price;
import Price.RegularPrice;
import Price.NewReleasePrice;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private Price price;

    public Movie(String newtitle, int priceCode) {
        title = newtitle;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR -> price = new RegularPrice();
            case CHILDRENS -> price = new ChildrensPrice();
            case NEW_RELEASE -> price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price.Price Code");
        }
    }

    public String getTitle (){
        return title;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return price.FREQUENTRENTERPOINTS;

    }


}