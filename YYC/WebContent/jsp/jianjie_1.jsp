<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="dao.GaikuangDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% GaikuangDao dao=new GaikuangDao();
String content =dao.getContent();
%>
<%=content %>
</body>
</html>