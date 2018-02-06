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
  <%
  
    String id=request.getParameter("id");
    AdminDAO adminDAO=new AdminDAOImpl();
    Course course=adminDAO.getCourseInfoById(id);
      System.out.print(id);
   %>
  <body>
   <table width="70%" hight="100%">
   <tr>
     <th>课程ID</th>
      <th>课程名</th>
   </tr>
  
    <tr>
     <th>${course.getCourseName()}</th>
      <th>${ course.getCourseId() } </th>
   </tr>
  
  
  
   </table>
  </body>
</html>
