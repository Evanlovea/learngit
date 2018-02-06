package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import myDAOImpl.TeacherDAOImpl;
import myUtil.DbUtil;
import myVO.Teacher;

public class TeacherLogin extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil db=new DbUtil();
	   TeacherDAOImpl userDao=new TeacherDAOImpl();
	 
	  @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	 request.setCharacterEncoding("UTF-8");
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=utf-8");
	        String teacherIdString=request.getParameter("teacherId").trim();
	        String teacherPasswordString=request.getParameter("teacherPassword").trim();
	        Connection con=null;
	        try {
	           Teacher user=new Teacher(teacherIdString, null,null,teacherPasswordString);
	            con=(Connection) db.getCon();
	            Teacher currentUser=userDao.login(con, user);
	            if(currentUser==null){
	                //System.out.println("no");
	                request.setAttribute("error", "用户名或者密码错误");
	                request.setAttribute("teacherId", teacherIdString);
	                request.setAttribute("studentPassword",teacherPasswordString);
	                request.getRequestDispatcher("teacherLogin.jsp").forward(request, response);
	            }else{
	                //System.out.println("yes");
	                HttpSession session=request.getSession();
	                session.setAttribute("currentUser1",currentUser);
	                response.sendRedirect("teaLogin_success.jsp");
	                
	            }
	            db.closeAll(con, null, null);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	    }
	    
}
