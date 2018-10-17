<%@ page language="java" import="dao.*" import="java.util.List" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%      String username=request.getParameter("username");
		EmpDao dao=new EmpDao();
		List list=dao.getEmpByUsername1(username);
		Emp user=(Emp)list.get(0);
		%>
<h2>请输入修改成员的信息</h2>
<hr>
<form action="../editUser" method="post">
用户名：<br><input type="text" name="username" readonly="readonly" value="<%=username%>"><br>
密码：<br><input type="text" name="password" value="<%=user.getPassword()%>"><br>
创建时间：<br><input type="text" name="createtime" value="<%=user.getCreateTime()%>"><br>
权限：<br><input type="text" name="power" value="<%=user.getPower()%>"><br>
<input type="submit" value="确定">
</form>
</body>
</html>