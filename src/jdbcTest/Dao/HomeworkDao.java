package jdbcTest.Dao;

import jdbcTest.Model.Homework;
import jdbcTest.Model.Students;

import java.sql.*;

/**
 * Created by online on 15-1-24.
 */
public class HomeworkDao {
    public static void teacherCorrectingHomework(int score,int homeworkid,int stuid){
        Connection con = null;
        Statement stmt=null;

        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = "update students s,homeworks h set score="+score+" where s.sid ="+ stuid+" and s.id = h.owner and h.homeworkid="+homeworkid+";";

            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            StudentDao.closeAll(null, stmt, con);
        }
    }
    public static void getHomework(int homeworkid,int stuid){
        Connection con = null;
        Statement stmt=null;
        ResultSet rs = null;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            System.out.println("haha1");
            String sql = "select answer from students s,homeworks h where s.sid ="+ stuid+" and s.id = h.owner and h.homeworkid="+homeworkid+";";
            System.out.println("haha2");
            rs=stmt.executeQuery(sql);
            System.out.println("hah3");
            while (rs.next()){
                System.out.println("haha4");
                String an = rs.getString(1);
                System.out.println(an);
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            StudentDao.closeAll(rs, stmt, con);
        }
    }
    public static void insertInfo_homework(int hid,String ans,int owner){//增
        Connection con = null;
        PreparedStatement stmt=null;
        Homework h = new Homework();
        try {
            h.setAnswer(ans);
            h.setHomeworkid(hid);
            h.setowner(owner);
            con = StudentDao.getConne();
            String sql = "insert into homeworks(homeworkid,answer,owner) values(?,?,?);";
            //学生提交作业，成绩为空
            stmt =  con.prepareStatement(sql);
            stmt.setInt(1,h.getHomeworkid());
            stmt.setString(2,h.getAnswer());
            stmt.setInt(3,h.getowner());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            StudentDao.closeAll(null, stmt, con);
        }
    }
    public static void searchBySidNoscore(int stuid) {//查
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int i=0;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select homeworkid,answer,owner,score from students s,homeworks h where s.sid ="+ stuid+" and s.id = h.owner and score is null ;";

            rs = stmt.executeQuery(sql);
            System.out.println("homeworkid" + "\t" +"answer"+"\t" +
                    "owner"+"\t" +"score");

            while (rs.next()) {
                i++;
                String answer = rs.getString(2);
                Integer homeworkid = rs.getInt(1);
                Integer owner = rs.getInt(3);
                Integer score = rs.getInt(4);
                System.out.println("     "+homeworkid + "       " +answer+"     " +owner+"       " +score);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
            if (i==0){
                System.out.println("该生作业都已批改完毕。");}
        }
    }
    public static void searchBySid(int stuid) {//查学生的作业信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select homeworkid,answer,owner,score from students s,homeworks h where s.sid ="+ stuid+" and s.id = h.owner;";

            rs = stmt.executeQuery(sql);
            System.out.println("homeworkid" + "\t" +"answer"+"\t" +
                    "owner"+"\t" +"score");

            while (rs.next()) {
                String answer = rs.getString(2);
                Integer homeworkid = rs.getInt(1);
                Integer owner = rs.getInt(3);
                Integer score = rs.getInt(4);
                System.out.println("     "+homeworkid + "       " +answer+"     " +owner+"       " +score);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
        }
    }
    public static void searchByOwner(int owner) {//查学生的作业信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select * from students s,homeworks h where h.owner ="+ owner+" and s.id = h.owner;";

            rs = stmt.executeQuery(sql);
            System.out.println("sid" + "     " +"id"+"    " +
                    "sname"+"    " +"homeworkid"+"   " +"score");

            while (rs.next()) {
                Integer sid = rs.getInt(2);
                Integer id = rs.getInt(1);
                String sname = rs.getString(3);
                Integer homeworkid = rs.getInt(5);
                Integer score = rs.getInt(8);

                System.out.println(sid+"\t" +id+"\t  " +sname+"          " +homeworkid+"         " +score);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
        }
    }
    public static void searchByNoscore(){//查学生的未批改的作业信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select distinct sid,sname from students s,homeworks h where h.score is NULL and s.id = h.owner;";
            rs = stmt.executeQuery(sql);
            System.out.println("sid" + "   " +"sname");


            while (rs.next()) {
                String sname = rs.getString(2);
                Integer sid = rs.getInt(1);
                System.out.println(sid +"   "+sname);

            }
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
            }
        }

}
