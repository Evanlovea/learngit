package myDAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myDAO.AdminDAO;
import myUtil.DbUtil;
import myVO.Admin;
import myVO.Course;
import myVO.Student;
import myVO.Teacher;

public class AdminDAOImpl  implements AdminDAO{

	@Override
	public Admin login(Connection con, Admin user)throws SQLException {
		// TODO Auto-generated method stub
		 Admin resultUser=null;
	        String sql="select * from admininfo where adminname=? and adminpwd=?";
	        PreparedStatement ps=con.prepareStatement(sql);//
	        ps.setString(1, user.getAdminname());
	        ps.setString(2, user.getAdminPassword());
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	            resultUser=new Admin();
	            resultUser.setAdminname(rs.getString("adminname").trim());
	            resultUser.setAdminPassword(rs.getString("adminpwd").trim());
	        }
	        
	        return resultUser;
	
	}
    @Override
	public int addStuInfo(Student student){
		// TODO Auto-generated method stub
		int row=0;
		String stuNameString=student.getSname();
		String stuIdString=student.getSid();
		String stuPwdString=student.getSpassWord();
		String sql ="insert into stuinfo values(?,?,?)";
		DbUtil db=new DbUtil();
		Connection connection=db.getCon();
		try {
			
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,stuIdString);
			preparedStatement.setString(2,stuNameString);
			preparedStatement.setString(3, stuPwdString);
			row=preparedStatement.executeUpdate();
			db.closeAll(connection, null, null);
//			preparedStatement.addBatch();
//	      preparedStatement.executeBatch();//提交一批要执行的更新命令 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return row;
	}

	

	@Override
	public boolean isLegal(String sql) {
		boolean legal=false;
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement;
		ResultSet resultSet;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if(resultSet.next()){
				legal=true;
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return legal;
	}
	
	@Override
	public int addCourseInfo(Course course) {
		int row=0;
		String courseNameString=course.getCourseName();
		String courseIdString=course.getCourseId();
		
		String sql ="insert into course values(?,?)";
		DbUtil db=new DbUtil();
		Connection connection=db.getCon();
		try {
			
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,courseIdString);
			preparedStatement.setString(2,courseNameString);
			
			row=preparedStatement.executeUpdate();
			db.closeAll(connection, null, null);
//			preparedStatement.addBatch();
//	      preparedStatement.executeBatch();//提交一批要执行的更新命令 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return row;
	}
	@Override
	public int addTeacherInfo(Teacher teacher) {
		int row=0;
		String teacherNameString=teacher.getTname();
		String teacherIdString=teacher.getTid();
		String teacherNumString=teacher.getTnum();
		String teacherPassWordString=teacher.getTpassWord();
		
		String sql ="insert into teacherinfo values(?,?,?,?)";
		DbUtil db=new DbUtil();
		Connection connection=db.getCon();
		try {
			
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,teacherIdString);
			preparedStatement.setString(2,teacherNameString);
			preparedStatement.setString(1,teacherNumString);
			preparedStatement.setString(2,teacherPassWordString);
			row=preparedStatement.executeUpdate();
			db.closeAll(connection, null, null);
//			preparedStatement.addBatch();
//	      preparedStatement.executeBatch();//提交一批要执行的更新命令 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return row;
	}
	@Override
	public int updateInfo(String sql) {
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement;
		int row=0;
		try{
			statement=connection.createStatement();
			row=statement.executeUpdate(sql);
			dbUtil.closeAll(connection, statement, null);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return row;
	}
	
	@Override
	public List<Course> getAllCourseInfo() {
		List<Course> courses=new ArrayList<Course>();
		String sqlString="select *from course";
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			statement =connection.createStatement();
			resultSet =statement.executeQuery(sqlString);
			Course course=null;
			while (resultSet.next()) {
				String courseId=resultSet.getString(1);
				String courseName=resultSet.getString(2);
				course=new Course(courseId,courseName);
				courses.add(course);
				
			}
			dbUtil.closeAll(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return courses;
	}
	@Override
	public Course getCourseInfoById(String id) {
		Course course=null;
		String sqlString="select *from course where courseId='"+id+"'";
		//String sqlString="select *from course where courseId='3'";
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()){
				String courseIdString=resultSet.getString(1);
				String courseNameString=resultSet.getString(2);
				course=new Course(courseIdString,courseNameString);
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return course;
	}
	
	
	
	@Override
	public Student getStudentIdById(String id) {
		Student student=null;
		String sqlString="select *from stuinfo where stuId='"+id+"'";
		
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()){
				String studentIdString=resultSet.getString(1);
				String studentNameString=resultSet.getString(2);
				
				String studentPassWordString=resultSet.getString(3);
				student=new Student(studentIdString,studentNameString, studentPassWordString);
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return student;
	}
	@Override
	public List<Student> getAllStudentInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Teacher getTeacherInfoById(String id) {
		Teacher teacher=null;
		String sqlString="select *from teacherinfo where teacherId='"+id+"'";
		
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()){
				String teacherIdString=resultSet.getString(1);
				String teacherNameString=resultSet.getString(2);
				String teacherNumString=resultSet.getString(3);
				String teacherPassWordString=resultSet.getString(4);
				teacher=new Teacher(teacherIdString,teacherNameString,teacherNumString,teacherPassWordString);
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return teacher;
	}
	@Override
	public List<Teacher> getAllTeacherInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
