package Price;

/**
 * Created with IntelliJ IDEA.
 * User: Berkling
 * Date: 14.05.14
 * Time: 12:48
 * To change this template use File | Settings | File Templates.
 */
public interface Price {
    int getPriceCode();
    double getCharge(int daysRented);
    int FREQUENTRENTERPOINTS = 0;
}
