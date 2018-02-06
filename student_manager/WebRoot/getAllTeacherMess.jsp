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
    <title>教师信息</title>

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
        List<String[]> teacherInfoList=(List<String[]>)request.getAttribute("teacherInfoList");
        if(teacherInfoList==null){
        DbUtil.setSpan(2);//设置显示页数
        Pages pages=new Pages();
        int nowPage=pages.getCurPage();
        String sql="select *from teacherinfo";
        String sqlPage="select count(*) from teacherinfo";
        int totalPage=DbUtil.getTotalPages(sqlPage);
        pages.setSqlString(sql);
        //记住当前总页数
        pages.setTotalPage(totalPage);
       teacherInfoList=DbUtil.getPageContent(nowPage, sql);
       DbUtil.setSpan(2);
       session.setAttribute("pages", pages);
       request.setAttribute("teacherInfoList", teacherInfoList);
       }
       %>
       <c:forEach var="str"  items="${teacherInfoList }">
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
      <td>${str[2] }</td>
      <td>${str[3] }</td>
     </c:forEach>
     <tr>
     <c:set var="curPage" value="${pages.curPage }"/>
     <c:set var="totalPage" value="${ pages.totalPage}"/>
     <td colspan="5" align="center">
     <c:if test="${curPage>1 }">
     <a href="teacherInfoPageChange?curPage=${curPage-1}">上一页</a>
     </c:if>
     <form action="teacherInfoPageChange "method="post">
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
     <a href="teacherInfoPageChange?curPage=${curPage+1 }">下一页</a>
     </c:if>
       </td>
       </tr>
 </table>
 <a href="adminLogin_success.jsp">返回管理员操作页面</a>
 <br>
 <button type="button" onClick="history.back()">返回</button>

  </body>
</html>
