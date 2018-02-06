<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript">
      function check(){
         var oldId=document.addform.oldId.value;
         var newId=document.addform.newId.value;
         var rNewId=document.addform.rNewId.value;
         var corseName=document.addform.courseName.value;
            if(oldId.trim()==""){
               alert("旧课程号不能为空！");
               return false;
            }
             if(corseName.trim()==""){
               alert("课程名不能为空！");
               return false;
            }
            
             if(newId.trim()==""){
               alert("新课程号不能为空！");
               return false;
            }
             if(rNewId.trim()==""){
               alert("课程号不能为空！");
               return false;
            } 
             if(rNewId.trim()!=rNewId.trim()){
               alert("两次输入的课程号不同，请重新输入！");
               return false;
            } 
               
      }
   
   </script>
  </head>
  
  <body>
  

 
  <form action="modifyCourseInfo" method="post" name="addform" onsubmit="return check()">
  <center>
  <table>
   <tr>
            <th colspan="3"><center>修改课程号</center></th>
        </tr>
   
    <tr>
      <td>请输入您要更改的课程号：</td>
       <td><input type="text" name="oldId"/></td>
    </tr>
     <tr>
      <td>请输入对应的课程名：</td>
       <td><input type="text" name="courseName"/></td>
    </tr>
    <tr>
    <td><br/>请输入新课程号:</td>
    <td><input type="text" name="newId"/></td>
    </tr>
    <tr>
    <td><br/>请再次输入课程号：</td>
    <td><br/><input type="text" name="rNewId"/></td>
    </tr>
    <tr>
    <td align="right">
    <br/><input type="submit" value="提交" />
    </td>
    <td><br/><input type="reset" value="重置"/></td>
    </tr>
    </table>
    </center>
    </form>
     
   
   
  </body>
</html>
