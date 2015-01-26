package movie;

/**
 * Created by online on 14-12-1.
 */
public class Rental {
    /**
     * 租赁的影片
     */
    private Movie movie;

    /**
     * +     * 租赁的天数
     * +
     */
    private int daysRented;

    /**
     * 租赁类的构造函数
     *
     * @param movie      要租赁的影片类
     * @param daysRented 要租借的天数
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    // set and get methods

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return getMovie().getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
    return movie.getFrequentRenterPoints(daysRented);
    }
}

