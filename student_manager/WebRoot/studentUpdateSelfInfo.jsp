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
         var oPwd=document.addform.oldPwd.value;
         var pwd=document.addform.stuPwd.value;
         var rPwd=document.addform.stuRepeatPwd.value;
            if(oPwd.trim()==""){
               alert("旧密码不能为空！");
               return false;
            }
             if(pwd.trim()==""){
               alert("密码不能为空！");
               return false;
            }
             if(rPwd.trim()==""){
               alert("密码不能为空！");
               return false;
            } 
             if(rPwd.trim()!=pwd.trim()){
               alert("密码不同，请重新输入！");
               return false;
            } 
               
      }
   
   </script>
  </head>
  
  <body>
  

 
  <form action="updateStuPwd" method="post" name="addform" onsubmit="return check()">
  <center>
  <table>
   <tr>
            <th colspan="3"><center>修改密码</center></th>
        </tr>
    <tr>
      <td>请输入您的旧密码：</td>
       <td><input type="text" name="oldPwd"/></td>
    </tr>
    
    <tr>
    <td><br/>请输入新密码:</td>
    <td><input type="password" name="stuPwd"/></td>
    </tr>
    <tr>
    <td><br/>请再次输入密码：</td>
    <td><br/><input type="password" name="stuRepeatPwd"/></td>
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
