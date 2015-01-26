#学生作业提交
##使用的是ourschool数据库

1.创建一个学生表
          create table students(
          id integer(10) auto_increment primary key,
          sid integer(10)not null ,
          sname varchar(20)not null)charset utf8 collate utf8_general_ci;
2.作业表
          create table homeworks(
          id integer(10) auto_increment primary key,
          homeworkid integer(10)not null ,
          answer varchar(20)not null,
          owner integer(10)not null,
           score integer(4))charset utf8 collate utf8_general_ci;
##1.系统流程
+1.写入测试数据  在main中。
##2.主界面：
	###1 教师登录：
		接收输入数据，若为1
		1.1 查看学生名单（包括姓名、学号和编号，直接返回教师登录后界面）
		若为2
		1.2 查看未被批改作业的学生。（包括学号和姓名，无重复）
			根据列出的数据选择 1.2.1. 查看指定学生的未被批改的作业。（会列出所有未批改的作业，输入作业编号获取该生答案进行阅读并给出成绩，可以
										继续批改该生作业，若修改完，有提示。或选择其他同学作业。）
					1.2.2. 查看学生信息（即包括所有作业，查看后可以选择查看其他学生作业信息或者返回1.2）。
		若为0
		1.0 返回登录界面
	###2 学生登录：您好，请登录或按0返回（按学号登录）：
			2.1 提交作业
				输入作业号，输入答案，提交成功
			2.2 查看作业分数
				直接显示
