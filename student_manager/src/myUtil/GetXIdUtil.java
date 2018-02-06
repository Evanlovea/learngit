package myUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//获取数据库表中的ID值封装类
public class GetXIdUtil {
   public int getXStudentId(){
		 int id=0;
			DbUtil dbUtil=new DbUtil();
			Connection connection=dbUtil.getCon();
			Statement statement=null;
			String sqlString="select MAX(stuId) from stuinfo";
			ResultSet rSet=null;
			try {
				statement=connection.createStatement();
				 rSet=statement.executeQuery(sqlString);
				if(rSet.next()){
					id=rSet.getInt(1);
					
				}
				dbUtil.closeAll(connection, statement, rSet);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			id++;
			return id;
		}
   public int getXCourseId() {
	   int id=0;
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		String sqlString="select MAX(courseId) from course";
		ResultSet rSet=null;
		try {
			statement=connection.createStatement();
			 rSet=statement.executeQuery(sqlString);
			if(rSet.next()){
				id=rSet.getInt(1);
				
			}
			dbUtil.closeAll(connection, statement, rSet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		id++;
		return id;

   }
   public int getXTeacherName(){
	   int id=0;
		DbUtil dbUtil=new DbUtil();
		Connection connection=dbUtil.getCon();
		Statement statement=null;
		String sqlString="select MAX(teacherId) from teacherinfo";
		ResultSet rSet=null;
		try {
			statement=connection.createStatement();
			 rSet=statement.executeQuery(sqlString);
			if(rSet.next()){
				id=rSet.getInt(1);
				
			}
			dbUtil.closeAll(connection, statement, rSet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		id++;
		return id;

   }
}

