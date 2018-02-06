<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询教师信息</title>
<!-- <script type="text/javascript">
function check(){

   if(document.addForm.courseId.value==""){

    alert("输入的教工号不得为空！");//弹出提示框
    return false;

  }
 }

</script> -->
</head>
<body>
<center>
<form action="searchTeacherInfo" method="post" name="addForm" onsubmit="return check()">
    <table>
        <tr>
            <th colspan="3"><center>查询教师信息</center></th>
             
        </tr>
         <tr>
            <th colspan="2"><center>查询全部教师信息请直接点击查询</center></th>
             
        </tr>
        <tr>
            <td>请输入要查询的教工号：</td>
         
            <td><input type="text" id="teacherId" name="teacherId" value="${teacherId}"></td>
        </tr>
        <tr>
           <td><input type="submit" value="查询"></td>
            <td><button type="button" onClick="history.back()">返回</button>
        </tr>
    </table>
</form>
</center>
</body>
</html>
