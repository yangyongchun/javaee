<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.Goods"%>
    <%@page import="dao.GoodsDao"%><%@page import="dao.PageBean"%>
    <%@page import="java.util.List"%>
<%@ include file="daohangtiao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script language="javascript">
function show(name){
	var url="http://localhost:8080/YYC/jsp/showGoods.jsp?name="+name;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location.href=url;
}
</script>
<title>Insert title here</title>
</head>
<body>
<%!int curPage = 1; %>
<%

List<Goods> goodslist=(List<Goods>)request.getAttribute("goodslist");
if(goodslist==null){
	
%>
<jsp:forward page="../SearchGoods_qian"></jsp:forward>
<%}%>
<div class="div1" style="position:absolute;top:70px;width:1270px; height:220px; background:url(http://localhost:8080/YYC/img/4.jpg)center center no-repeat">
</div>
<div class="div2" style="position:absolute;top:220px;">
<h2>核心产品：</h2>
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
<table width="100%" border="0" cellspacing="50">
<tbody>
<tr>
<%

for(int i=0;i<goodslist.size();i++){
	Goods goods=goodslist.get(i);
	if((i+1)%3==0){
%>

<td align="center"><a href="#" onclick="show('<%=goods.getName() %>')"><img src="http://localhost:8080/YYC/img/<%=goods.getPic()%>" width="300px" height="300px"></a></td>
<tr>
<%}
	else{%>
		<td align="center"><a href="#" onclick="show('<%=goods.getName() %>')"><img src="http://localhost:8080/YYC/img/<%=goods.getPic()%>" width="300px" height="300px"></a></td>	
<%}}%>
</tbody>
</table>
</div>
</td>
</tr>
</table>

</tr>
</table>

</table>
</div>
<div style="position:absolute;right:200px;bottom:250px;z-index:1000;">
<table width="150%" >
<tr><td style="cursor:hand;">
<a href="http://localhost:8080/YYC/SearchGoods_qian?curPage=1">第一页</a>&nbsp;&nbsp;&nbsp;
<a href="http://localhost:8080/YYC/SearchGoods_qian?curPage=${pageGoods.curPage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
<a href="http://localhost:8080/YYC/SearchGoods_qian?curPage=${pageGoods.curPage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
<a href="http://localhost:8080/YYC/SearchGoods_qian?curPage=${pageGoods.totalPage}">最后一页</a>
</td></tr>
</table>
</div>
</body>
</html>