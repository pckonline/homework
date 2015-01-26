package jdbcTest.Dao;

import jdbcTest.JdbcTest;
import jdbcTest.Model.Homework;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by online on 15-1-24.
 */
public class StudentDao {
    //链接数据库
    public static Connection getConne(){
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ourschool?"+
                "user=root&password=p5385676&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int studentLogin(Scanner sc) {//查
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int i =0;
        int id=0;
        int login = sc.nextInt();
        if (login==0){
            JdbcTest.intoMethod(sc);
        }
        try {
            con = getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select sname,id from students where sid = "+login+";";
            //查询学生信息
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                i++;
                String sname = rs.getString(1);
                id = rs.getInt(2);
                System.out.println("欢迎您的使用："+sname);
            }
        }
        catch (Exception e){
            System.out.println("Error : " + e.toString());
        }finally {
            if (i==0){
                System.out.println("密码错误，请重新输入或按0退出：");
                studentLogin(sc);
            }
            closeAll(rs, stmt, con);
            return id;
        }

    }
    public static void insertInfo(int id,String name){//增
        Connection con = null;
        Statement stmt=null;
        try {
            con = getConne();
            stmt =  con.createStatement();
            String sql=null;
            sql = "insert into students(sid,sname) values("+id+",'"+name+"');";
            //写入学生信息.
            int sr = stmt.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            closeAll(null,stmt,con);
        }
    }

    public static void searchInfo() {//查
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select *from students";
            //查询学生信息
            rs = stmt.executeQuery(sql);
            System.out.println("id" + "\t" + "Sname"+"\t"+"sid");

            while (rs.next()) {
                Integer id = rs.getInt(1);

                Integer sid = rs.getInt(2);
                String sname = rs.getString(3);
                System.out.println(id+"\t"+sname + "  \t" + sid);
            }
        }
        catch (Exception e){
            System.out.println("Error : " + e.toString());
        }finally {
            closeAll(rs, stmt, con);
        }

    }
    public static void closeAll(ResultSet rs,Statement stmt,Connection con){
        try{
            if(rs!=null)
                rs.close();
            if (stmt!=null)
                stmt.close();

            if (con!=null)
                con.close();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
    }
}
