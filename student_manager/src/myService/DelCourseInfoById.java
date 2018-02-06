package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myDAO.AdminDAO;
import myDAOImpl.AdminDAOImpl;

public class DelCourseInfoById extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String courseIdString=request.getParameter("courseId").trim();
		//int id=Integer.parseInt(stuIdString);
		 String temp="select courseName from course where courseId='"+courseIdString+"'";
		AdminDAO dao=new AdminDAOImpl();
		boolean flag=dao.isLegal(temp);
		String msg="";
		if(flag){
			String sqlString="delete from course where courseId="+courseIdString;
			int i=dao.updateInfo(sqlString);
			if(i==1){
				msg="该课程信息删除成功";
			}else{
				msg="该课程信息删除失败";
			}
		}else{
			msg="查不到您所要删除的课程信息";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
	}

}
