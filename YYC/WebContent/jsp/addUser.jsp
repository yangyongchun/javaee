<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>请输入添加成员的信息</h2>

<form action="../addUser" method="post">
用户名：<br><input type="text" name="username"><br>
密码：<br><input type="text" name="password"><br>
创建时间：<br><input type="text" name="createtime"><br>
权限：<br><input type="text" name="power"><br>
<input type="submit" value="确定">
</form>
</body>
</html>