<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师登录</title>
</head>
<body>
<center>
<form action="teaLogin" method="post">
    <table>
        <tr>
            <th colspan="3"><center>教师登录</center></th>
        </tr>
        <tr>
            <td>教工号</td>
            <td><input type="text" id="teacherId" name="teacherId" value="${teacherId}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="teacherPassword" name="teacherPassword" value="${teacherPassword}"></td>
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