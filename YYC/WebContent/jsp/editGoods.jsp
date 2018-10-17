
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
name = java.net.URLDecoder.decode(name,"UTF-8"); 
System.out.print(name);

%>
<h2>请修改产品的信息</h2>

<form action="../editGoods" method="post">
产品名：<br><input type="text" name="name" readonly="readonly" value=<%=name %>><br>
图片：<br><input id="pic" type="file" name = 'pic'/><br>
简介：<br><textarea name="introduce" rows="10" cols="18"></textarea><br>
<input type="submit" value="确定">
</form>
</body>
</html>