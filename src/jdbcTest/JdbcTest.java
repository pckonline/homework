package jdbcTest;


import jdbcTest.Dao.HomeworkDao;
import jdbcTest.Dao.StudentDao;
import jdbcTest.Model.Homework;

import java.util.Scanner;

/**
 * Created by online on 15-1-23.
 */
public class JdbcTest {
    public static void main(String[] args) {
        //写入作业信息和查询
//        HomeworkDao.insertInfo_homework(3,"答案",4);
//        HomeworkDao.insertInfo_homework(1,"答案",4);
//        HomeworkDao.insertInfo_homework(2,"答案",3);
//        HomeworkDao.insertInfo_homework(3,"答案",2);
//        HomeworkDao.insertInfo_homework(4,"答案",4);
//        HomeworkDao.insertInfo_homework(4,"答案",5);
//        HomeworkDao.insertInfo_homework(4,"答案",1);

        //首先，老师要是批改作业，先查询没有成绩的同学，并把未改的作业显示出来
//        HomeworkDao.searchByNoscore();

//        HomeworkDao.searchBySid(1014);
//        再根据学号查询该同学的作业信息

        //写入学生信息和查询

//        StudentDao.insertInfo(1015, "张三");
//        StudentDao.insertInfo(1012,"李四");
//        StudentDao.insertInfo(1013,"王五");
//        StudentDao.insertInfo(1014,"赵六");
//        StudentDao.insertInfo(1011,"田七");
//        StudentDao.searchInfo();
        Scanner sc = new Scanner(System.in);
        intoMethod(sc);


    }

    public static void intoMethod(Scanner sc) {
        System.out.println("******************作业管理系统******************");
        System.out.println("请选择登录方式：");
        System.out.println("\t"+"1.教师登录。"+"\n\t"+"2.学生登录。"+"\n\t"+"0.退出。");
        int into  = sc.nextInt();
        if (into==1){
            System.out.print("登录成功,");
            intoMethod_1(sc);
        }else if (into==2){
            intoMethod_2(sc);
        }else if (into==0){
            return;
        }
        else {
            intoMethod(sc);
        }
    }

    public static void intoMethod_2(Scanner sc) {
        System.out.println("您好，请登录或按0返回：");
        int id =StudentDao.studentLogin(sc);
        intoMethod_2_1(sc, id);
    }

    private static void intoMethod_2_1(Scanner sc, int id) {
        System.out.println("请选择："+"\n\t"+"1.提交作业。"+"\n\t"+"2.查看作业分数。"+"\n\t"+"0.返回登录界面。");
        int into_2 = sc.nextInt();
        if (into_2==1){
            System.out.println("请输入作业号");
            int into_2_1=sc.nextInt();
            System.out.println("请输入答案");
            String into_2_2=sc.next();
            HomeworkDao.insertInfo_homework(id, into_2_2, into_2_1);
            intoMethod_2_1(sc,id);
        }else if (into_2==2){
            HomeworkDao.searchByOwner(id);
            intoMethod_2_1(sc,id);
        }
        else if (into_2==0){
            intoMethod(sc);
        }
        else {
            intoMethod_2_1(sc,id);
        }
    }

    private static void intoMethod_1(Scanner sc) {
        System.out.println("请选择服务项目："+"\n\t"+"1.查看所有学生名单。"+"\n\t"
        +"2.查看未被批改作业的学生。"+"\n\t"+"0.返回。");
        int into_1  = sc.nextInt();
        if (into_1==1){
            StudentDao.searchInfo();//查看所有学生名单
            intoMethod_1(sc);//返回登录成功界面
        }else if (into_1==2){
            intoMethod_1_2(sc);//查看未被批改作业的学生
        }
        else if (into_1==0){
            intoMethod(sc);//返回登录界面
        }else {
            intoMethod_1(sc);
        }
    }

    private static void intoMethod_1_2(Scanner sc) {//查看未被批改作业的学生
        HomeworkDao.searchByNoscore();//查看未被批改作业的学生
        System.out.println("请选择："+"\n\t"+"1.查看指定学生的未被批改的作业。"+"\n\t"+"2.查看学生信息。"+"\n\t"+"0.返回。");
        int into_1_2 = sc.nextInt();
        if (into_1_2==1){
            intoMethod_1_2_1(sc);
        }else if (into_1_2==2){
            intoMethod_1_2_2(sc);//查看指定学生的作业情况
        }
        else{
            intoMethod_1(sc);//否则返回 查看未被批改作业的学生
        }

    }
    private static void intoMethod_1_2_1(Scanner sc) {//功能1.2.1 按学号查看该生的未被批改的作业
        System.out.println("请输入学号");
        int into_1_2_1 = sc.nextInt();
        intoMethod_1_2_1_1(sc,into_1_2_1);
    }

    private static void intoMethod_1_2_1_1(Scanner sc,int into_1_2_1) {

        HomeworkDao.searchBySidNoscore(into_1_2_1);//获得该生的所有的未批改的作业
        System.out.println("1.获取指定作业答案。"+"\n"+"0.返回");
        int into_1_2_1_1 = sc.nextInt();
        if (into_1_2_1_1==1) {
            System.out.println("请输入作业编码");
            int into_1_2_2 = sc.nextInt();
            HomeworkDao.getHomework(into_1_2_2, into_1_2_1);//获得该生某个作业的答案进行阅读
            System.out.println("该生获得的分数。");
            int into_1_2_3 = sc.nextInt();
            HomeworkDao.teacherCorrectingHomework(into_1_2_3, into_1_2_2, into_1_2_1);//打分
            System.out.println("请选择：" + "\n\t" + "1.继续查看该生的未批改的作业。" + "0.返回查看未被批改作业的学生");
            int into_1_2_4 = sc.nextInt();
            if (into_1_2_4 == 1) {
                intoMethod_1_2_1_1(sc, into_1_2_1);//继续查看该生未批改的作业
            } else if (into_1_2_4 == 0) {
                intoMethod_1_2(sc);//返回查看未被批改作业的学生
            }
        }
        else{
            intoMethod_1_2(sc);
        }
    }

    private static void intoMethod_1_2_2(Scanner sc) {//功能1.2.2 按学号查看该生的作业情况
        System.out.println("请输入学号");
        int into_1_2_1 = sc.nextInt();
        HomeworkDao.searchBySid(into_1_2_1);//获得该生的所有的作业
        System.out.println("请选择："+"\n\t"+"1.继续查看其他学生的作业情况。"+"0.返回查看未被批改作业的学生");
        int into_1_2_4 = sc.nextInt();
        if (into_1_2_4==1){
            intoMethod_1_2_2(sc);//继续查看其他生的作业情况
        }
        else if (into_1_2_4==0){
            intoMethod_1_2(sc);//返回查看未被批改作业的学生
        }
    }
}
