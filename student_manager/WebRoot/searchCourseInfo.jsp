<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除课程信息</title>
<script type="text/javascript">


</script>
</head>
<body>
<center>
<form action="searchCourseInfo" method="post" name="addForm" >
    <table style="width: 581px; height: 190px; ">
        <tr>
            <th colspan="3"><center>查询课程信息</center></th>
        </tr>
        <tr>
            <td style="width: 373px; ">请输入要查询的课程号：</td>
            <td><input type="text" id="courseId" name="courseId" value="${courseId}"></td>
        </tr>
         <tr style="width: 431px; ">
           <td style="width: 355px; "><input type="text" value="如果想要查询全部信息，直接点击查询按钮即可！" style="width: 414px; "></td>
         
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
