package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myDAOImpl.AdminDAOImpl;
import myUtil.GetXIdUtil;
import myVO.Course;

public class AddCourseInfo extends HttpServlet {

	/**
	 * 添加学生信息
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
		 String courseIdString=request.getParameter("courseId").trim();
		 String courseNameString =request.getParameter("courseName").trim();
		 AdminDAOImpl daoImpl=new AdminDAOImpl();
		 /*GetXIdUtil getXIdUtil=new GetXIdUtil();
		 int id=getXIdUtil.getXCourseId();*/
		 String temp="select courseId from course where courseName='"+courseNameString+"'";
		 boolean flag=daoImpl.isLegal(temp);
		 String msg="";
		 if(flag){
			 msg="该用户已经存在";
		 }else{
			Course student=new Course(courseIdString,courseNameString);
			 int i=daoImpl.addCourseInfo(student);//插入
			 //判断是否插入成功
			 if(i==1){
				 msg="课程信息添加成功";
			 }else{
				 msg="课程信息添加失败";
			 }
		 }
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("getMessage.jsp").forward(request, response);
		 
		 
	 }

}
