package classRoom;

/**
 * Created by online on 15-1-21.
 */
import java.sql.*;
public class Search {
    public int num;
    public int date;

    public void set1(Person p2){
        this.num = p2.getCr().getNum();
        this.date = p2.getCr().getDate();
    }



    public void searchTo(){
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mysql";
            String usr = "root";
            String pwd = "p5385676";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, usr, pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from classrooms where info='yes' and rid="+num+" and rdata="+date);

            while (rs.next()) {
                String info = rs.getString("info");
                Integer id = rs.getInt("rid");
                Integer data = rs.getInt("rdata");
                System.out.println(id + "\t" + data + "\t" + info);
            }
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
    }
}
