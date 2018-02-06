<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生信息</title>
<script type="text/javascript">
function check(){

   if(document.addForm.stuName.value==""){

    alert("姓名不得为空！");//弹出提示框
   return false;

  }
     if(document.addForm.stuId.value==""){

    alert("学号不得为空！");//弹出提示框
   return false;

  }

 if(document.addForm.stuPassWord.value==""){

    alert("密码不得为空！");//弹出提示框
   return false;

  }
 }

</script>
</head>
<body>
<center>
<form action="addStuInfo" method="post" name="addForm" onsubmit="return check()">
    <table>
        <tr>
            <th colspan="3"><center>添加学生信息</center></th>
        </tr>
        <tr>
            <td>请输入学号：</td>
            <td><input type="text" id="stuId" name="stuId" value="${stuId}"></td>
        </tr>
        <tr>
            <td>请输入学生姓名：</td>
            <td><input type="text" id="stuName" name="stuName" value="${stuName}"></td>
        </tr>
          <tr>
            <td>请输入初始登录密码：</td>
            <td><input type="text" id="stuPassWord" name="stuPassWord" value="${stuPassWord}"></td>
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
