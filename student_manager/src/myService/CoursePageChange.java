package myService;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myUtil.DbUtil;
import myVO.Pages;

public class CoursePageChange extends HttpServlet {

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
		 HttpSession session=request.getSession();
		 Pages pages=(Pages) session.getAttribute("pages");
		 if(pages==null){
			 pages=new Pages();
		 }
		 //得到请求的页面
		 String curPageString=request.getParameter("curPage");
		 if(curPageString!=null){
			 int page=Integer.parseInt(curPageString.trim());
			 //记住当前页
			 pages.setCurPage(page);
		 }else {
			String selPageString=request.getParameter("selPage").trim();
			int page=Integer.parseInt(selPageString);
			pages.setCurPage(page);
		}
		 String sqlString=pages.getSqlString();
		 //得到换页之后的内容
		 List<String[]> courseInfoList=DbUtil.getPageContent(pages.getCurPage(),sqlString);
		 request.setAttribute("courseInfoList", courseInfoList);
		 session.setAttribute("pages", pages);
		 //forward到修改的主页面
		 String urlString="/getAllCourseMess.jsp";
		 ServletContext context=getServletContext();
		 RequestDispatcher requestDispatcher=context.getRequestDispatcher(urlString);
		 requestDispatcher.forward(request, response);
	 }

}
