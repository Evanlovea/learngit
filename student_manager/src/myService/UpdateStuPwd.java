package myService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myDAO.StudentDAO;
import myDAOImpl.StudentDAOImpl;
import myVO.Student;

public class UpdateStuPwd extends HttpServlet {

	/**
	 * 学生修改密码
	 */
	private static final long serialVersionUID = 1L;
	  @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("UTF-8");
	         response.setContentType("text/html;charset=UTF-8");
	         request.setCharacterEncoding("utf-8");
	          PrintWriter out = response.getWriter();
		  Student student=(Student) request.getSession().getAttribute("currentUser"); 
		  String stuIdString=student.getSid();
		  out.print(stuIdString);
		  String stuOldPwdString=request.getParameter("oldPwd").trim();
		  String stuPwdString=request.getParameter("stuPwd").trim();
		 StudentDAO studentDAO=new StudentDAOImpl();
		 String temp="select stuId from stuinfo where password='"+stuOldPwdString+"'";
		 boolean flag=studentDAO.isLegal(temp);
		 String msg="";
		 if(!flag){
			 msg="对不起，用户名输入错误！";
			 
		 }else{
			 String sqlString="update stuinfo set password='"+stuPwdString+"' where stuId='"+stuIdString+"'";
			 int i=studentDAO.updateStuInfo(sqlString);
			 if(i==1){
				 msg="恭喜您，密码重置成功！";
				 
			 }else{
				 msg="对不起，密码重置失败！";
			 }
		 }
		 request.setAttribute("msg", msg);
		 request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
	  }
}
