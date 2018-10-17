<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.Goods"%>
    <%@page import="dao.GoodsDao"%>
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
function cbkSelect(sta,flag){
	for(var i=0;i<document.getElementsByName(flag).length;i++){
		document.getElementsByName(flag)[i].checked=sta;
	}
}
function addGoods(){
	
	
		window.location.href="http://localhost:8080/YYC/jsp/addGoods.jsp";
	
	
}
function deleteGoods(){
	var allCheck=document.getElementsByName("goodsId");
	var num=0;
	var delstr="";
	for(var i=0;i<allCheck.length;i++){
		if(allCheck[i].checked)
		{
			num++;
			delstr+=allCheck[i].value+"/";
		}
	}
	if(num>0){
		var url="http://localhost:8080/YYC/deleteGoods?del="+delstr;
		url=encodeURI(url);
		url=encodeURI(url);
		window.location.href=url;
		
		}

	else{
		alert("没有选中信息！");
	}
}
function editGoods(){
	var allCheck=document.getElementsByName("goodsId");
	var num=0;
	var goodsname="";
	for(var i=0;i<allCheck.length;i++){
		if(allCheck[i].checked)
		{
			num++;
			goodsname=allCheck[i].value;
		}
	}
	
	if(num==1){
		
		var url="http://localhost:8080/YYC/jsp/editGoods.jsp?name="+goodsname;
		url=encodeURI(url);
		url=encodeURI(url);
		window.location.href=url;
			}
		

	else if(num==0){
		alert("没有选中信息！");
		return;
	}
	else{
		alert("请选择一条信息进行修改！");
		return;
	}
	
}
</script>
<title>Insert title here</title>
</head>
<body scroll="no">
<%
List<Goods> goodslist=(List<Goods>)session.getAttribute("goodslist");
if(goodslist==null){
	
%>
<jsp:forward page="../SearchGoods_qian"></jsp:forward>
<%}%>
<table width="100%" height="100%" border=0 cellspacing="0" cellpadding="0">
<tr style="height:2%;">
<td>
<table border="0" width="100%" >
<tr>
<td><h3>产品信息</h3></td>
</tr>
</table>
</td> 
</tr>
<tr style="height:96%">
<td>
<form method="POST" name="search" action="http://localhost:8080/YYC/SelectGoods">
<table width="100%">
<tr>
<td width="10%" >产品名：</td>
<td style="width:20%"><input type="text" name="name" size="50%" ></td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td><button onClick="select()" style="width:10%" value="查询">查询
</button></td>
</tr>
</table>
</form>
<table border="0" width="100%" align="center">
<tr>
<td>
产品信息列表:
</td>
</tr>
</table>
<div style="position:fixed;left:250px;bottom:50px;z-index:1000;">
<table width="200%" >
<tr><td style="cursor:hand;">
<button style="width:20%" onClick="addGoods()">新增产品</button>
<button style="width:20%" onClick="deleteGoods()">删除</button>
<button style="width:40%" onClick="editGoods()">修改产品信息</button>
</td></tr>
</table>
</div>

<div>
<table width="100%" border="0" style="border-collapse :collapse;">
<thead>
<tr>
<th width="10%">
<input type="checkbox" name="checkAll" onClick="cbkSelect(this.checked,'goodsId')">
</th>
<th width="15%"><span>序号</span></th>
<th width="25%"><span>产品名</span></th>
<th width="20%"><span>图片</span></th>
<th width="30%"><span>介绍</span></th>
</tr>
</thead>
<tbody>
<%

for(int i=0;i<goodslist.size();i++){
	Goods goods=goodslist.get(i);
%>

<tr>
<td align="center"><input type="checkbox" name="goodsId" value="<%=goods.getName()%>"></td>
<td align="center"><%=i+1 %></td>
<td align="center"><%=goods.getName() %></td>
<td align="center"><a href="showPic.jsp?pic=<%=goods.getPic() %>"><%=goods.getPic() %></a></td>
<td align="center"><%=goods.getIntroduce() %></td>
</tr>
<%}%>
</tbody>
</table>
</div>
</td>
</tr>
</table>


</body>
</html>