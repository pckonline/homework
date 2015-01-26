package movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by online on 14-12-1.
 */
public class Customer {
    /**
     * 顾客的名字
     */
    private String name;

    /**
     * 用于保存顾客的租赁信息
     */

    private List<Rental> rentals = new ArrayList<Rental>();

    /**
     * 构造函数
     *
     * @param name 顾客的名字
     */


    public Customer(String name) {
        this.name = name;
    }


    /**
     * 增加一个租借
     *
     * @param rental 租借类
     */


    public void addRental(Rental rental) {
        rentals.add(rental);
    }


    /**
     * 生成详单的函数
     */


    public String statement() {

        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.getCharge()) + "\n";



        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    // set and get methods
    private double getTotalCharge() {
        double totalAmount = 0;

        for (Rental rental : rentals) {
            totalAmount += rental.getCharge();
        }

        return totalAmount;
    }

    /**
     * 计算总常客积分
     */
    private int getTotalFrequentRenterPoints() {
        int result = 0;

        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }

        return result;
    }

    public String getName() {
        return name;
    }
}
