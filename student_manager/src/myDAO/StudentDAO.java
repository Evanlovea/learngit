package myDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import myVO.Student;
import myVO.StudentAll;



public interface StudentDAO {
	 /*
     * 学生登录操作
     */
	 public Student login(Connection con,Student user) throws SQLException;
	 
	 /*
	  * 学生查看自己的全部相关信息
	  */
	 public List<StudentAll> getMyInfoById(String id) ;
     
	 /*
	  * 检查数据的合法性
	  */
	public boolean isLegal(String sqlString);

	public int updateStuInfo(String sqlString);
	 
	 /*
	  * 学生修改自己的个人信息
	  */
	
}
