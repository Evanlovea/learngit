<%@page import="myUtil.DbUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="myDAOImpl.AdminDAOImpl"%>
<%@page import="myDAO.AdminDAO"%>
<%@page import="myVO.*" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>课程信息</title>

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
   <table>
   <tr>
     <th>课程ID</th>
      <th>课程名</th>
   </tr>
      <%
        List<String[]> courseInfoList=(List<String[]>)request.getAttribute("courseInfoList");
        if(courseInfoList==null){
        DbUtil.setSpan(2);
        Pages pages=new Pages();
        int nowPage=pages.getCurPage();
        String sql="select *from course";
        String sqlPage="select count(*) from course";
        int totalPage=DbUtil.getTotalPages(sqlPage);
        pages.setSqlString(sql);
        //记住当前总页数
        pages.setTotalPage(totalPage);
        courseInfoList=DbUtil.getPageContent(nowPage, sql);
       DbUtil.setSpan(2);
       session.setAttribute("pages", pages);
       request.setAttribute("courseInfoList", courseInfoList);
       }
       %>
       <c:forEach var="str"  items="${courseInfoList }">
       <c:choose>
       <c:when test="${i%2==0 }">
       <c:out value="<tr align='center'>" escapeXml="false"/>
      
       </c:when>
       <c:otherwise>
      <c:out value="<tr align='center' bgcolor='#F5F9FE'>" escapeXml="false"></c:out>
     </c:otherwise>
     </c:choose>
     <td>${str[0] }</td>
      <td>${str[1] }</td>
   
     </c:forEach>
     <tr>
     <c:set var="curPage" value="${pages.curPage }"/>
     <c:set var="totalPage" value="${ pages.totalPage}"/>
     <td colspan="5" align="center">
     <c:if test="${curPage>1 }">
     <a href="CoursePageChange?curPage=${curPage-1}">上一页</a>
     </c:if>
     <form action="CoursePageChange "method="post">
     <select onchange="this.form.submit()" name="selPage">
     <c:forEach var="i" begin="1" end="${totalPage }" step="1">
     <c:set var="flag" value=""/>
     <c:if test="${flag==i }">
     <c:set var="flag" value="selected"/>
     </c:if>
      <option value="${i }"${flag }>第${i }页</option>
  
     </c:forEach>
     </select>
     </form>
     <c:if test="${curPage<totalPage }">
     <a href="CoursePageChange?curPage=${curPage+1 }">下一页</a>
     </c:if>
       </td>
       </tr>
 </table>
 <a href="adminLogin_success.jsp">返回管理员操作页面</a>
 <br>
 <button type="button" onClick="history.back()">返回</button>

  </body>
</html>
