package myService;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myDAO.AdminDAO;
import myDAOImpl.AdminDAOImpl;

import myVO.Teacher;

public class SearchTeacherInfo extends HttpServlet {

	/**
	 * 查找教师信息业务处理
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
		 
    String teacherIdString=request.getParameter("teacherId");
    out.print(teacherIdString);
    request.setAttribute("id",teacherIdString);
   // session.setAttribute("courseId",courseIdString);
   // out.print("myId"+courseIdString);
      String sqlString="select teacherName from teacherinfo where teacherId='"+teacherIdString+"'";
 	 AdminDAO dao=new AdminDAOImpl();
 	 boolean flag=false;
 	flag=dao.isLegal(sqlString);
       
 	 out.print("myFlag"+flag);
if(teacherIdString==""){
	      flag=true;
     	if(flag){
     	
     		 /*AdminDAO adminDAO=new AdminDAOImpl();
    		 List<Course>courses=adminDAO.getAllCourseInfo();
    		 request.setAttribute("courses", courses);
    		 
    		 request.getRequestDispatcher("/getAllCourseMess.jsp").forward(request, response);*/
     		 request.getRequestDispatcher("/getAllTeacherMess.jsp").forward(request, response);
     	 }else{
    		 request.setAttribute("msg", "1查询失败");
     		
      	 }

     	 
      }else{
  	 if(flag){
     		
     		 AdminDAO adminDAO2=new AdminDAOImpl();
     		 Teacher teacher=adminDAO2.getTeacherInfoById(teacherIdString);
     		 request.setAttribute("teacher", teacher);
     	
     		request.getRequestDispatcher("/getTeacherMessById.jsp").forward(request, response);		
     		
     	 }else{
     		 request.setAttribute("msg", "2查询失败");
     		 request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
     	 }
     	 
      }
      
	 }
}
