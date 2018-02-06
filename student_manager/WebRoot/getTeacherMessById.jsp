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
    Teacher teacher=adminDAO.getTeacherInfoById(id);
      System.out.print(id);
   %>
  <body>
   <table width="70%" hight="100%">
   <tr>
     <th>教师ID</th>
      <th>教师姓名</th>
      <th>教师所教课程号</th>
      <th>教师登录密码</th>
   </tr>
  
    <tr>
 
      <th>${ teacher.getTid() } </th>
      <th>${teacher.getTname()}</th>
      <th>${teacher.getTnum()}</th>
      <th>${ teacher.getTpassWord() } </th>
   </tr>
  
  
  
   </table>
  </body>
</html>