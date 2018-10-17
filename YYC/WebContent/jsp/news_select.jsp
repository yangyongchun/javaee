<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.News"%>
    <%@page import="dao.NewsDao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
a {
	color: black;
	
}
</style>
<script language="javascript">

function show(title){
	var url="http://localhost:8080/YYC/jsp/showNews.jsp?title="+title;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location.href=url;
	}
function addNews(){
	
	
		window.location.href="http://localhost:8080/YYC/jsp/addNews.jsp";
	
	
}
function deleteNews(title){
	
	
		var url="http://localhost:8080/YYC/deleteNews?title="+title;
		url=encodeURI(url);
		url=encodeURI(url);
		window.location.href=url;
		
		
		}


function editNews(title){
	
		var url="http://localhost:8080/YYC/jsp/editNews.jsp?title="+title;
		url=encodeURI(url);
		url=encodeURI(url);
		window.location.href=url;
	
}
</script>
<title>Insert title here</title>
</head>
<body scroll="no">
<%

List<News> newslist=(List<News>)request.getAttribute("newslist");
if(newslist==null){
	
%>
<jsp:forward page="../SearchNews"></jsp:forward>
<%} %>
<table width="100%" height="100%" border=0 cellspacing="0" cellpadding="0">
<tr style="height:2%;">
<td>
<table border="0" width="100%" >
<tr>
<td><h3>新闻</h3></td>
</tr>
</table>
</td> 
</tr>
<tr style="height:96%">
<td>
<form method="POST" name="search" action="http://localhost:8080/YYC/SelectNews">
<table width="100%">
<tr>
<td width="30%" >标题：</td>
<td style="width:20%"><input type="text" name="title" size="30%" style="width:100%;"></td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td><button onClick="select()" style="width:20%" value="查询">查询
</button></td>
</tr>
</table>
</form>
<table border="0" width="100%" align="center">
<tr>
<td>
新闻列表:
</td>
</tr>
</table>
<div style="position:fixed;left:50px;bottom:20px;z-index:1000;">
<table width="100%" border="0">
<tr><td style="cursor:hand;">
<button style="width:200%" onClick="addGoods()">新增新闻</button>

</td></tr>
</table>
</div>

<div>
<table width="100%" border="1" style="border-collapse :collapse;">
<thead>
<tr>
<th width="15%"><span>序号</span></th>
<th width="15%"><span>标题</span></th>
<th width="25%"><span>详细信息</span></th>
<th width="30%"><span>操作</span></th>

</tr>
</thead>
<tbody>
<%

for(int i=0;i<newslist.size();i++){
	News news=newslist.get(i);
%>

<tr>
<td align="center"><%=i+1 %></td>
<td align="center"><%=news.getTitle() %></td>
<td align="center"><a href="#" onclick="show('<%=news.getTitle() %>')">详细信息</a></td>
<td align="center"><a href="#" onclick="deleteNews('<%=news.getTitle() %>')">删除</a> <a href="#" onclick="editNews('<%=news.getTitle() %>')">修改</a></td></tr>
<%}%>
</tbody>
</table>
</div>
</td>
</tr>


</body>
</html>