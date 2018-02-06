<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
<center>
<form action="adminLogin" method="post">
    <table>
        <tr>
            <th colspan="3"><center>管理员登录</center></th>
        </tr>
        <tr>
            <td>账号</td>
            <td><input type="text" id="adminName" name="adminName" value="${adminName}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" id="adminPassword" name="adminPassword" value="${adminPassword}"></td>
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