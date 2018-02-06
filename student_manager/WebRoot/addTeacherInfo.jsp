<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师信息</title>
<script type="text/javascript">
function check(){

   if(document.addForm.teacherName.value==""){

    alert("姓名不得为空！");//弹出提示框
   return false;

  }
     if(document.addForm.teacherId.value==""){

    alert("教工号不得为空！");//弹出提示框
   return false;

  }


   if(document.addForm.teacherNum.value==""){

    alert("教师所教课程号不得为空！");//弹出提示框
   return false;

  }
   if(document.addForm.teacherPassWord.value==""){

    alert("密码不得为空！");//弹出提示框
   return false;

  }
 }

</script>
</head>
<body>
<center>
<form action="addTeacherInfo" method="post" name="addForm" onsubmit="return check()">
    <table>
        <tr>
            <th colspan="3"><center>添加教师信息</center></th>
        </tr>
        <tr>
            <td>请输入教工号：</td>
            <td><input type="text" id="teacherId" name="teacherId" value="${teacherId}"></td>
        </tr>
        <tr>
            <td>请输入教师姓名：</td>
            <td><input type="text" id="teacherName" name="teacherName" value="${teacherName}"></td>
        </tr>
        <tr>
            <td>请输入教师所教课程号：</td>
            <td><input type="text" id="teacherNum" name="teacherNum" value="${teacherNum}"></td>
        </tr>
          <tr>
            <td>请输入初始登录密码：</td>
            <td><input type="text" id="teacherPassWord" name="teacherPassWord" value="${teacherPassWord}"></td>
        </tr>
         
          
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><font color="red">${error}</font></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>