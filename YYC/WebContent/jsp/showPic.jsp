<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<%String pic=request.getParameter("pic"); %>
<div style="text-align:center;vertical-align: middle;">
<img src="http://localhost:8080/YYC/img/<%=pic%>">
</div>
</body>
</html>