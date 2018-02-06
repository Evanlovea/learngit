package myDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myDAO.StudentDAO;
import myUtil.DbUtil;
import myVO.Student;
import myVO.StudentAll;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public Student login(Connection con, Student user)throws SQLException {
		// TODO Auto-generated method stub
		 Student resultUser=null;
	        String sql="select * from stuinfo where stuId=? and password=?";
	        PreparedStatement ps=con.prepareStatement(sql);//
	        ps.setString(1, user.getSid());
	  
	        ps.setString(2, user.getSpassWord());
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	            resultUser=new Student();
	            resultUser.setSid(rs.getString("stuId").trim());
	            resultUser.setSpassWord(rs.getString("password").trim());
	        }
	        
	        return resultUser;
	
	}

	@Override
	 public List<StudentAll> getMyInfoById(String id)  {
		
		List<StudentAll> studentAlls=new ArrayList<StudentAll>();
		String sqlString="select stuinfo.stuId,stuName,password,courseName,grade  from stuinfo,sc,course where stuinfo.stuId=sc.stuId and sc.courseId=course.courseId and stuinfo.stuId='"+id+"'";
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			StudentAll studentAll=null;
			while(resultSet.next()){
				String studentIdString=resultSet.getString(1);
				String studentNameString=resultSet.getString(2);
				
				String studentPassWordString=resultSet.getString(3);
				String studentCourseNameString=resultSet.getString(4);
				String studentGradeString=resultSet.getString(5);
				studentAll=new StudentAll(studentIdString,studentNameString, studentPassWordString,studentCourseNameString,studentGradeString);
			    studentAlls.add(studentAll);
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return studentAlls;
	}




	@Override
	public int updateStuInfo(String sqlString) {
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement;
		int row=0;
		try {
			statement=connection.createStatement();
			row=statement.executeUpdate(sqlString);
			dbUtil.closeAll(connection, statement, null);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public boolean isLegal(String sqlString) {
		boolean legal=false;
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement;
		ResultSet resultSet;
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()){
				legal=true;
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return legal;
	}

}
