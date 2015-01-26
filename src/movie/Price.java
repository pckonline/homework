package movie;

/**
 * Created by online on 14-12-3.
 */

abstract public class Price {
    public abstract int getPriceCode();

    abstract public double getCharge(int daysRented);
    public int getFrequentRenterPoints(int daysRented) {
                return 1;
            }

}

