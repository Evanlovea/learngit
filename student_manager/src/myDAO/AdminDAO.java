package myDAO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import myVO.Admin;
import myVO.Course;
import myVO.Student;
import myVO.Teacher;



public interface AdminDAO {
     /*
      * 管理员登录操作
      */
	 public Admin login(Connection con,Admin user) throws SQLException;
	 
	 /*
	  * 增加学生信息
	  */
	 public int addStuInfo(Student student); 
	 
	 /*
	  * 判断所查询的数据是否为合法数据
	  */
	 public boolean isLegal(String sql);
	 
	 /*
	  * 删除学生、教师、课程信息
	  * 返回影响的行数
	  */
	 public int updateInfo(String sql);
	 /*
	  * 通过stuId查询学生信息
	  */
	 public Student getStudentIdById(String id);
	 
	 
	 /*
	  * 查询所有的学生信息
	  */
	 public List<Student> getAllStudentInfo();
	 
	 /*
	  * 增加教师信息
	  */
	 public int addTeacherInfo(Teacher teacher);
	
	 
	 /*
	  * 通过teacherId查询教师信息
	  */
	 public Teacher getTeacherInfoById(String id);
	 
	 /*
	  * 查询所有教师信息
	  */
	public List<Teacher> getAllTeacherInfo();
	
	
	 /*
	  * 增加课程信息
	  */
	 public int addCourseInfo(Course course);


	 
	
	 /*
	  * 通过Id查询课程信息
	  */
	 public Course getCourseInfoById(String id);
	 /*
	  * 查询所有课程信息
	  */
	 public  List<Course> getAllCourseInfo();
	 
	 
	 
}
