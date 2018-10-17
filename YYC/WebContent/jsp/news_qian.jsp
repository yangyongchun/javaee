<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.News"%>
    <%@page import="dao.NewsDao"%>
    <%@page import="java.util.List"%>
<%@ include file="daohangtiao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script language="javascript">
function show(title){
	var url="http://localhost:8080/YYC/jsp/showNews.jsp?title="+title;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location.href=url;
}
</script>
<title>Insert title here</title>
</head>
<body>
<%
List<News> newslist=(List<News>)request.getAttribute("newslist");
if(newslist==null){
	
%>
<jsp:forward page="../SearchNews_qian"></jsp:forward>
<%}%>
<div class="div1" style="position:absolute;top:70px;width:1270px; height:220px; background:url(http://localhost:8080/YYC/img/5.jpg)center center no-repeat">
</div>
<div class="div2" style="position:absolute;top:220px;">
<h2>新闻：</h2>
</div>
<div class="div3" style="position:absolute;top:280px;">
<table border="0">
<tr>
<table width="100%" height="100%" border=0 cellspacing="0" cellpadding="0">
<tr style="height:2%;">
<td>
<table border="0" width="100%" >

<tr style="height:96%">
<td>
<table border="0" width="100%" align="center">
</table>

<div>
<table width="100%" border="1" cellspacing="30">

<tr>
<%

for(int i=0;i<newslist.size();i++){
	News news=newslist.get(i);
	
%>
<td>标题：&nbsp;&nbsp;&nbsp;<a href="#" onclick="show('<%=news.getTitle() %>')"><%=news.getTitle()%></a></td>
<td>发布时间：<%=news.getTime() %></td>
<tr>
<%}%>

<table width="150%" >
<tr><td style="cursor:hand;">
<a href="http://localhost:8080/YYC/SearchNews_qian?curPage=1">第一页</a>&nbsp;&nbsp;&nbsp;
<a href="http://localhost:8080/YYC/SearchNews_qian?curPage=${pageNews.curPage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
<a href="http://localhost:8080/YYC/SearchNews_qian?curPage=${pageNews.curPage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
<a href="http://localhost:8080/YYC/SearchNews_qian?curPage=${pageNews.totalPage}">最后一页</a>
</td></tr>
</table>
</table>
</div>
</td>
</tr>
</table>
</tr>
</table>
</table>
</div>
</body>
</html>