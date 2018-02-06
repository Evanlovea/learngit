<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生登录</title>
</head>
<body>
<center>
<form action="stuLogin" method="post">
    <table>
        <tr>
            <th colspan="3"><center>学生登录</center></th>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" id="studentId" name="studentId" value="${studentId}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="studentPassword" name="studentPassword" value="${studentPassword}"></td>
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