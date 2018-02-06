package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myDAOImpl.AdminDAOImpl;
import myVO.Student;
import myVO.Teacher;

public class AddTeaInfo extends HttpServlet {

	/**
	 * 添加教师信息
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
		 String teacherIdString=request.getParameter("teacherId").trim();
		 String teacherNameString =request.getParameter("teacherName").trim();
		 String teacherNumString=request.getParameter("teacherNum").trim();
		 String teacherPassWordString=request.getParameter("teacherPassWord").trim();
		 AdminDAOImpl daoImpl=new AdminDAOImpl();
//		 GetXIdUtil getXIdUtil=new GetXIdUtil();
//		 int id=getXIdUtil.getXStudentId();
		 String temp="select teacherId from teacherinfo where teacherName='"+teacherNameString+"'";
		 boolean flag=daoImpl.isLegal(temp);
		 String msg="";
		 if(flag){
			 msg="该用户已经存在";
		 }else{
			 Teacher teacher=new Teacher(teacherIdString,teacherNameString, teacherNumString,teacherPassWordString);
			 int i=daoImpl.addTeacherInfo(teacher);//插入
			 //判断是否插入成功
			 if(i==1){
				 msg="教师信息添加成功";
			 }else{
				 msg="教师信息添加失败";
			 }
		 }
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("getMessage.jsp").forward(request, response);
		 
		 
	 }
}
