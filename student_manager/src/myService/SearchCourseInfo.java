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
import myDAOImpl.AdminDAOImpl;
import myVO.Course;

public class SearchCourseInfo extends HttpServlet {

	/**
	 * 
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
		// HttpSession session=request.getSession();
		 
       String courseIdString=request.getParameter("courseId");
       out.print(courseIdString);
       request.setAttribute("id", courseIdString);
      // session.setAttribute("courseId",courseIdString);
       out.print("myId"+courseIdString);
         String sqlString="select courseName from course where courseId='"+courseIdString+"'";
    	 AdminDAO dao=new AdminDAOImpl();
    	 boolean flag=false;
    	flag=dao.isLegal(sqlString);
          
    	 out.print("myFlag"+flag);
   if(courseIdString==""){
	      flag=true;
        	if(flag){
        	
        		 AdminDAO adminDAO=new AdminDAOImpl();
       		 List<Course>courses=adminDAO.getAllCourseInfo();
       		 request.setAttribute("courses", courses);
       		 
       		 request.getRequestDispatcher("/getAllCourseMess.jsp").forward(request, response);
        	 }else{
       		 request.setAttribute("msg", "1查询失败");
        		// request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
         	 }
 
        	 
         }else{
     	 if(flag){
        		
        		 AdminDAO adminDAO2=new AdminDAOImpl();
        		 Course course=adminDAO2.getCourseInfoById(courseIdString);
        		 request.setAttribute("course", course);
        		// out.println(course.getCourseName());
        		request.getRequestDispatcher("/getCourseInfoById.jsp").forward(request, response);		
        		// response.sendRedirect("/getCourseInfoById.jsp");
        	 }else{
        		 request.setAttribute("msg", "2查询失败");
        		 request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
        	 }
        	 
         }
         
	 }
}
