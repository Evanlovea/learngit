<%@page import="myDAOImpl.StudentDAOImpl"%>
<%@page import="myDAO.StudentDAO"%>
<%@page import="myDAOImpl.AdminDAOImpl"%>
<%@page import="myDAO.AdminDAO"%>
<%@page import="myVO.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'getCourseInfoById.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <table width="70%" hight="100%">
   <tr>
     <th>学生学号</th>
      <th>学生姓名</th>
      <th>学生登录密码</th>
      <th>学生选课名称</th>
      <th>学生成绩</th>
   </tr>
  <%
  
  HttpSession session2=request.getSession(true);
    Student student=(Student) request.getSession().getAttribute("currentUser");
    String id=student.getSid(); 
    StudentDAO studentDAO=new StudentDAOImpl();
    List<StudentAll> studentAlls=studentDAO.getMyInfoById(id);
     System.out.print(id+"id");
     int i=0;
     StudentAll studentAll;
     for(i=0;i<studentAlls.size();i++){
        studentAll=studentAlls.get(i);
         pageContext.setAttribute("studentAll", studentAll);
         if(i%2==0){
         out.println("<tr align='center'>");
     }else{
        out.println("<tr align='center' bgcolor='#F5F9FE'>");
     }
   %>
    <tr>
 
      <th>${ studentAll.getSid() } </th>
      <th>${studentAll.getSname()}</th>
      <th>${ studentAll.getSpassWord() } </th>
       <th>${studentAll.getCourseName() }</th>
      <th>${ studentAll.getGradeString() } </th>
   </tr>
  <%
  }
   %>
  
  
   </table>
  </body>
</html>