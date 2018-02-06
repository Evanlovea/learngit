package myDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import myVO.StudentAll;
import myVO.Teacher;



public interface TeacherDAO {
	 /*
     * 教师登录操作
     */
	 public Teacher login(Connection con,Teacher user) throws SQLException;

	public List<StudentAll> getStuAndCouseInfoByTeacherId(String teacherIdString);

	public int updateCourseInfo(String sqlString);

	
}
