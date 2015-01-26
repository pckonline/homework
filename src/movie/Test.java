package movie;

/**
 * Created by online on 14-12-1.
 */
public class Test {
    public static void main(String[] args) {


        Movie 射雕英雄传 = new Movie("射雕英雄传", new RegularPrice());
        Movie 海面宝宝 = new Movie("海面宝宝", new ChildrensPrice());
        Movie 大长今 = new Movie("大长今", new NewReleasePrice());
        Customer 小明 = new Customer("小明");

        小明.addRental(new Rental(射雕英雄传, 2));
        小明.addRental(new Rental(海面宝宝, 4));
        小明.addRental(new Rental(大长今, 1));
        String result = "Rental Record for 小明\n" +
                "\t射雕英雄传\t2.0\n" +
                "\t海面宝宝\t3.0\n" +
                "\t大长今\t3.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 3 frequent renter points";

        System.out.println(小明.statement().equals(result));
    }
}
