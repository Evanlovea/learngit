package myDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import myDAO.TeacherDAO;
import myUtil.DbUtil;
import myVO.StudentAll;
import myVO.Teacher;

public class TeacherDAOImpl implements TeacherDAO{

	@Override
	public Teacher login(Connection con, Teacher user) throws SQLException {
		// TODO Auto-generated method stub
		 Teacher resultUser=null;
	        String sql="select * from teacherinfo where teacherId=? and tPassword=?";
	        PreparedStatement ps=con.prepareStatement(sql);//
	        ps.setString(1, user.getTid());
	        ps.setString(2, user.getTpassWord());
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	            resultUser=new Teacher();
	            resultUser.setTid(rs.getString("teacherId").trim());
	            resultUser.setTpassWord(rs.getString("tPassword").trim());
	        }
	        
	        return resultUser;
	}

	@Override
	public List<StudentAll> getStuAndCouseInfoByTeacherId(String teacherIdString) {
		List<StudentAll> studentAlls=new ArrayList<StudentAll>();
		String sqlString="select sc.stuId ,stuinfo.stuName,course.courseName,sc.grade from teacherinfo,course,sc,stuinfo where teacherinfo.tno=sc.courseId and sc.stuId=stuinfo.stuId and sc.courseId=course.courseId and teacherinfo.teacherId='"+teacherIdString+"'";
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
				
				
				String studentCourseNameString=resultSet.getString(3);
				String studentGradeString=resultSet.getString(4);
				studentAll=new StudentAll(studentIdString,studentNameString, null,studentCourseNameString,studentGradeString);
			    studentAlls.add(studentAll);
			}
			dbUtil.closeAll(connection, statement, resultSet);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return studentAlls;
	}

	@Override
	public int updateCourseInfo(String sqlString) {
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

	

}
