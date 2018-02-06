package myService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myDAOImpl.AdminDAOImpl;
import myUtil.GetXIdUtil;
import myVO.Student;

public class AddStuInfo extends HttpServlet {

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
		 String studentIdString=request.getParameter("stuId").trim();
		 String studentNameString =request.getParameter("stuName").trim();
		 String studentPassWordString=request.getParameter("stuPassWord").trim();
		
		 AdminDAOImpl daoImpl=new AdminDAOImpl();
//		 GetXIdUtil getXIdUtil=new GetXIdUtil();
//		 int id=getXIdUtil.getXStudentId();
		 String temp="select stuId from stuinfo where stuName='"+studentNameString+"'";
		 boolean flag=daoImpl.isLegal(temp);
		 String msg="";
		 if(flag){
			 msg="该用户已经存在";
		 }else{
			 Student student=new Student(studentIdString,studentNameString, studentPassWordString);
			 int i=daoImpl.addStuInfo(student);//插入
			 //判断是否插入成功
			 if(i==1){
				 msg="学生信息添加成功";
			 }else{
				 msg="学生信息添加失败";
			 }
		 }
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("getMessage.jsp").forward(request, response);
		 
		 
	 }

}
