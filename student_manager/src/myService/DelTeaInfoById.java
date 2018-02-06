package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myDAO.AdminDAO;
import myDAOImpl.AdminDAOImpl;

public class DelTeaInfoById extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String teaIdString=request.getParameter("teacherId").trim();
		//int id=Integer.parseInt(stuIdString);
		 String temp="select teacherId from teacherinfo where teacherId='"+teaIdString+"'";
		AdminDAO dao=new AdminDAOImpl();
		boolean flag=dao.isLegal(temp);
		String msg="";
		if(flag){
			String sqlString="delete from teacherinfo where teacherId="+teaIdString;
			int i=dao.updateInfo(sqlString);
			if(i==1){
				msg="该教师信息删除成功";
			}else{
				msg="该教师信息删除失败";
			}
		}else{
			msg="查不到您所要删除的学号";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/getMessage.jsp").forward(request, response);
	}

}
