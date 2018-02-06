package myService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import myDAO.TeacherDAO;

import myDAOImpl.TeacherDAOImpl;
import myUtil.DbUtil;

import myVO.StudentAll;
import myVO.Teacher;

public class LookStuAndCouseInfoByTeacherId extends HttpServlet {

	/**
	 * 教师浏览对应课程学生基本信息和相应的成绩信息
	 */
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	 @Override
	    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
	      PrintWriter out = response.getWriter();
	  	   Teacher teacher=(Teacher) request.getSession().getAttribute("currentUser1"); 
	  	   out.println(teacher);
	  	   String teacherIdString=teacher.getTid();
	  	   out.println(teacherIdString);
	        String sqlString="select teacherName from teacherinfo where teacherId='"+teacherIdString+"'";
	  	 TeacherDAO dao=new TeacherDAOImpl();
	  	 DbUtil dbUtil=new DbUtil();
	  	 boolean flag=false;
	  	flag=dbUtil.isLegal(sqlString);
	  	
	   	if(flag){
	   		TeacherDAO teacherDAO=new TeacherDAOImpl();
	   		List<StudentAll> tsCourses=teacherDAO.getStuAndCouseInfoByTeacherId(teacherIdString);
	   		 request.getRequestDispatcher("/message/getStudentAndCourseInfo.jsp").forward(request, response);
	   	 }else{
	  		 request.setAttribute("msg", "1查询失败");
	  		 //request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
	    	 }
	     }
	 }

