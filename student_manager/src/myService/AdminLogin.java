package myService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import myDAOImpl.AdminDAOImpl;
import myUtil.DbUtil;
import myVO.Admin;

public class AdminLogin extends HttpServlet{

    DbUtil db=new DbUtil();
    AdminDAOImpl userDao=new AdminDAOImpl();
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
        String adminNameString=request.getParameter("adminName").trim();
        String adminPasswordString=request.getParameter("adminPassword").trim();
        Connection con=null;
        try {
           Admin user=new Admin(adminNameString,adminPasswordString);
            con=(Connection) db.getCon();
           Admin currentUser=userDao.login(con, user);
            if(currentUser==null){
                //System.out.println("no");
                request.setAttribute("error", "用户名或者密码错误");
                request.setAttribute("username", adminNameString);
                request.setAttribute("password",adminPasswordString);
                request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
            }else{
                //System.out.println("yes");
                HttpSession session=request.getSession();
                session.setAttribute("currentUser",currentUser);
                response.sendRedirect("adminLogin_success.jsp");
                
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
}