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
int pageSize;
int totalSize;
int totalPage;
int currentPage;
 String strPage; 
int a,id;
pageSize=3;
List<News> newslist=(List<News>)request.getAttribute("newslist");
if(newslist==null){
	
%>
<jsp:forward page="../SearchNews"></jsp:forward>
<%} totalSize=newslist.size();
	totalPage=(totalSize+pageSize-1)/pageSize;
	strPage=session.getAttribute("currentPage").toString();
	if(strPage==null){
		currentPage=1;
		session.setAttribute("currentPage",currentPage);
	}else if(Integer.parseInt(strPage)<1){
		currentPage=1;
		session.setAttribute("currentPage",currentPage);
	}
	else if(Integer.parseInt(strPage)>totalPage){
		currentPage=totalPage;
		session.setAttribute("currentPage",currentPage);
	}
	else{
		currentPage=Integer.parseInt(strPage);
		session.setAttribute("currentPage",currentPage);
	}
	int index;
	if(currentPage==totalPage){index=newslist.size()+1;}
	else{index=(currentPage-1)*pageSize+1+pageSize;}%>
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
<td style="width:40%"><input type="text" name="title" size="30%" style="width:100%;"></td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td><button onClick="select()" style="width:100%" value="查询">查询
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
<div style="position:fixed;left:250px;bottom:20px;z-index:1000;">
<table width="100%" border="0">
<tr><td style="cursor:hand;">
<button style="width:100%" onClick="addNews()">新增新闻</button>

</td></tr>
</table>
</div>
<div style="position:fixed;right:100px;bottom:100px;z-index:1000;">
<table width="150%" >
<tr><td style="cursor:hand;">
<a href="../Diyiye_news">第一页</a>&nbsp;&nbsp;&nbsp;
<a href="../Shangyiye_news">上一页</a>&nbsp;&nbsp;&nbsp;
<a href="../Xiayiye_news">下一页</a>&nbsp;&nbsp;&nbsp;
<a href="../Zuihouyiye_news">最后一页</a>
</td></tr>
</table>
</div>
<div>
<table width="200%" border="1" style="border-collapse :collapse;">
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

for(int i=(currentPage-1)*pageSize+1;i<index;i++){
	News news=newslist.get(i-1);
%>

<tr>
<td align="center"><%=i %></td>
<td align="center"><%=news.getTitle() %></td>
<td align="center"><a href="#" onclick="show('<%=news.getTitle() %>')">详细信息</a></td>
<td align="center"><a href="#" onclick="deleteNews('<%=news.getTitle() %>')">删除</a> <a href="#" onclick="editNews('<%=news.getTitle() %>')">修改</a></td>
</tr>
<%}%>
</tbody>
</table>
</div>
</td>
</tr>


</body>
</html>