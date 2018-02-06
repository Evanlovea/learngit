package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import myDAOImpl.StudentDAOImpl;
import myUtil.DbUtil;
import myVO.Student;

public class StudentLogin extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil db=new DbUtil();
	    StudentDAOImpl userDao=new StudentDAOImpl();
	 
	  @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     request.setCharacterEncoding("UTF-8");
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=utf-8");
	        String StudentIdString=request.getParameter("studentId").trim();
	        String studentPasswordString=request.getParameter("studentPassword").trim();
	        Connection con=null;
	        try {
	           Student user=new Student(StudentIdString, null,studentPasswordString);
	            con=(Connection) db.getCon();
	          Student currentUser=userDao.login(con, user);
	            if(currentUser==null){
	                //System.out.println("no");
	                request.setAttribute("error", "用户名或者密码错误");
	                request.setAttribute("studentId", StudentIdString);
	                request.setAttribute("studentPassword",studentPasswordString);
	                request.getRequestDispatcher("studentLogin.jsp").forward(request, response);
	            }else{
	                //System.out.println("yes");
	                HttpSession session=request.getSession();
	                session.setAttribute("currentUser",currentUser);
	                request.setAttribute("id", StudentIdString);
	                response.sendRedirect("stuLogin_success.jsp");
	                
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	    }
	    
}
