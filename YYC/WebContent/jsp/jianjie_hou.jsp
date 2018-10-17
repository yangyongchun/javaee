<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="dao.GaikuangDao"%>
        <%@page import="dao.RenzhengDao"%>
        <%@page import="dao.Renzheng"%>
        <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% GaikuangDao dao=new GaikuangDao();
RenzhengDao dao1=new RenzhengDao();
String content =dao.getContent();
List renzhenglist=dao1.getAllRenzheng();
%>
企业概况管理：
<br>
<form action="../editGaikuang" method="post">
<input type="hidden" name="content2" value="<%=content %>">
<textarea name="content1"><%=content %></textarea>
<input type="submit" value="修改">
</form>
企业认证管理：
<br>
<%
for(int i=0;i<renzhenglist.size();i++){
	Renzheng renzheng=(Renzheng)renzhenglist.get(i);
%>
<img src="http://localhost:8080/YYC/img/<%=renzheng.getPath() %>" title="有效期至：<%=renzheng.getTime() %>" width="100px" height="100px">
<a href="http://localhost:8080/YYC/deleteRenzheng?id=<%=renzheng.getId() %>">删除</a>
<a href="http://localhost:8080/YYC/jsp/editRenzheng.jsp?id=<%=renzheng.getId() %>">修改</a>
<%}%>
<form action="http://localhost:8080/YYC/jsp/addRenzheng.jsp" method="post">
<input type="submit" value="新增认证图片">
</form>
</body>
</html>