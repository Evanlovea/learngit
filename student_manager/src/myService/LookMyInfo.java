package myService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myDAO.AdminDAO;
import myDAO.StudentDAO;
import myDAOImpl.AdminDAOImpl;
import myDAOImpl.StudentDAOImpl;
import myVO.Student;
import myVO.StudentAll;

public class LookMyInfo extends HttpServlet {

	/**
	 * 查看学生自己的信息
	 */
	private static final long serialVersionUID = 1L;
	
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	 @Override
	    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		 response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("utf-8");
          PrintWriter out = response.getWriter();
	//	HttpSession session=request.getSession();
	   Student student=(Student) request.getSession().getAttribute("currentUser"); 
	   out.println(student.getSid());
	   String studentIdString=student.getSid();
	   out.println(studentIdString);
      String sqlString="select stuName from stuinfo where stuId='"+studentIdString+"'";
	 StudentDAO dao=new StudentDAOImpl();
	 boolean flag=false;
	flag=dao.isLegal(sqlString);
	
 	if(flag){
 		StudentDAO studentDAO=new StudentDAOImpl();
 		List<StudentAll> student2=studentDAO.getMyInfoById(studentIdString);
 		request.setAttribute("student2", student2);
 		request.setAttribute("id", studentIdString);
 		 request.getRequestDispatcher("/message/MyPriInfo.jsp").forward(request, response);
 	 }else{
		 request.setAttribute("msg", "1查询失败");
		 request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
  	 }
   }
}

 	 
 
