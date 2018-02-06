package myService;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import myDAO.TeacherDAO;

import myDAOImpl.TeacherDAOImpl;
import myUtil.DbUtil;



public class ModifyCourseInfo extends HttpServlet {

	/**
	 * 教师修改相应课程信息
	 */
	private static final long serialVersionUID = 1L;
	 @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	  @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("UTF-8");
	         response.setContentType("text/html;charset=UTF-8");
	         request.setCharacterEncoding("utf-8");
	        
		
			  String teacherOldIdString=request.getParameter("oldId").trim();
			  String courseNameString=request.getParameter("courseName").trim();
			  String teacherNewIdString=request.getParameter("newId").trim();
			DbUtil dbUtil=new DbUtil();
			TeacherDAO teacherDAO=new TeacherDAOImpl();
			 String temp="select courseName from course where courseId='"+teacherOldIdString+"'";
			 boolean flag=dbUtil.isLegal(temp);
			 String msg="";
			 if(!flag){
				 msg="对不起，课程号输入错误！";
				 
			 }else{
				 String sqlString="update course set courseId='"+teacherNewIdString+"' where courseName='"+courseNameString+"'";
				 int i=teacherDAO.updateCourseInfo(sqlString);
				 if(i==1){
					 msg="恭喜您，课程号重置成功！";
					 
				 }else{
					 msg="对不起，课程号重置失败！";
				 }
			 }
			 request.setAttribute("msg", msg);
			 request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
		  }
	  }

