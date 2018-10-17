<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="dao.News"%>
    <%@page import="dao.NewsDao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>请修改新闻的信息</h2>
<%
String title=request.getParameter("title");
title = java.net.URLDecoder.decode(title,"UTF-8"); 
NewsDao nd=new NewsDao();
List list=(List)nd.getNewsByTitle1(title);
News news=(News)list.get(0);
%>
<form action="../editNews" method="post">
标题：<br><input type="text" name="title" readonly="readonly" value=<%=title %>><br>
发布人：<br><input type="text" name="author"  value=<%=news.getAuthor() %>><br>
发布时间：<br><input type="text" name="time" value=<%=news.getTime() %>><br>
内容：<br><textarea name="content" rows="10" cols="18" ><%=news.getContent() %></textarea><br>

<input type="submit" value="确定">
</form>
</body>
</html>