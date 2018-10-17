<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<% 
String id=request.getParameter("id");
int id1=Integer.parseInt(id);
RenzhengDao dao=new RenzhengDao();
List list =dao.getRenzhengById1(id1);
Renzheng renzheng=(Renzheng)list.get(0);

%>
<h2>请修改认证图片</h2>

<form action="../editRenzheng" method="post">
<input type="hidden" name="id" value="<%=renzheng.getId() %>" />
有效期：<br><input type="text" name="time" value="<%=renzheng.getTime() %>"><br>
图片：<br><input id="pic" type="file" name = 'path' /><br>
<input type="submit" value="确定">
</form>
</body>
</html>