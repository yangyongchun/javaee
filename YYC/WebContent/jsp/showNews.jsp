<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="dao.News"%>
    <%@page import="dao.NewsDao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

body {
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String title=request.getParameter("title");
title = java.net.URLDecoder.decode(title,"UTF-8"); 
System.out.print(title);
NewsDao dao=new NewsDao();
List newslist=(List)dao.getNewsByTitle1(title);
News news=(News)newslist.get(0);
%>
<br><br>
标题：<br><%=news.getTitle()%><br><br>
发布人：<br><%=news.getAuthor()%><br><br>
发布时间：<br><%=news.getTime()%><br><br>
内容：<br><%=news.getContent()%><br><br>
</body>
</html>