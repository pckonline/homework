package classRoom;

/**
 * Created by online on 15-1-21.
 * 该文件是对数据库中的信息进行检索，并找出符合要求的信息。
 * 本人的java项目的第一步。。。。。。。。。
 *
 */
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setProfessional("jisuanji");
        p1.setSid("1311058");
        p1.setSname("zhangsan");
        p1.getCr().setDate(10112);
        p1.getCr().setNum(5305);
        Search se = new Search();
        se.set1(p1);
        se.searchTo();

    }
}