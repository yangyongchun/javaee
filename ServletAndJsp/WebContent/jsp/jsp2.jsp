<%--page指令 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.yyc.javabean.Users"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--我是jsp声明 --%>
<%!
Date d1=new Date();
%>

<%--我是jsp脚本 --%>
<%
out.println(d1);
%>

<%--我是jsp表达式 --%>
当前的时间是：<%=d1%>

<%--我是include指令 --%>
<%@ include file="jsp1.jsp" %>

<%--新建一个Users的对象存入request中 --%>
<jsp:useBean id="user1" class="com.yyc.javabean.Users" scope="session"/>
<jsp:setProperty name="user1" property="username" value="abc"/>
<jsp:getProperty name="user1" property="username"/>

<%--jsp:include --%>
<jsp:include page="jsp1.jsp"/>

<%--jsp:forword --%>
<jsp:forward page="jsp1.jsp">
<%--jsp:param,嵌在jsp:include或者forward中使用，可以用request.get到该参数--%>
<jsp:param name="username" value="abc"/>
</jsp:forward>


</body>
</html>