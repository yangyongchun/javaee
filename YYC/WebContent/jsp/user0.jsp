<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%      String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		String createtime=(String)session.getAttribute("createtime");
		String power=(String)session.getAttribute("power");
		%>
<h2>您不是管理员，只可修改自己的信息。</h2>
<hr>
<form action="../editUser0" method="post">
用户名：<br><input type="text" name="username" readonly="readonly" value="<%=username%>"><br>
密码：<br><input type="text" name="password" value="<%=password%>"><br>
创建时间：<br><input type="text" name="createtime" value="<%=createtime%>"><br>
权限：<br><input type="text" name="power" value="<%=power%>" readonly="readonly"><br>
<input type="submit" value="确定">
</form>
</body>
</html>