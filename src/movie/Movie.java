package movie;

/**
 * Created by online on 14-12-1.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;

    public Movie(String title, Price price) {
        this.title = title;
                this.price = price;
    }


    // set and get methods

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Price getPrice() {
                return price;
    }

    public void setPrice(Price price) {
               this.price = price;
    }
    public double getCharge(int daysRented)
    {
         return price.getCharge(daysRented);
    }
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
           }
}
