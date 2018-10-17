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
int pageSize;
int totalSize;
int totalPage;
int currentPage;
 String strPage; 
int a,id;
pageSize=3;
List<Goods> goodslist=(List<Goods>)request.getAttribute("goodslist");
if(goodslist==null){
	
%>
<jsp:forward page="../SearchGoods"></jsp:forward>
<%} totalSize=goodslist.size();
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
	if(currentPage==totalPage){index=goodslist.size()+1;}
	else{index=(currentPage-1)*pageSize+1+pageSize;}%>
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
<td width="30%" >产品名：</td>
<td style="width:40%"><input type="text" name="name" size="30%" style="width:100%;"></td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td style="width:1%">&nbsp;</td>
<td><input type="submit" value="查询"></td>
</tr>
</table>
</form>
<table border="0" width="250%" align="center">
<tr>
<td>
产品信息列表:
</td>
</tr>
</table>
<div style="position:fixed;left:250px;bottom:20px;z-index:1000;">
<table width="150%" >
<tr><td style="cursor:hand;">
<button style="width:30%" onClick="addGoods()">新增产品</button>
<button style="width:20%" onClick="deleteGoods()">删除</button>
<button style="width:30%" onClick="editGoods()">修改产品信息</button>
</td></tr>
</table>
</div>
<div style="position:fixed;right:100px;bottom:100px;z-index:1000;">
<table width="150%" >
<tr><td style="cursor:hand;">
<a href="../Diyiye">第一页</a>&nbsp;&nbsp;&nbsp;
<a href="../Shangyiye">上一页</a>&nbsp;&nbsp;&nbsp;
<a href="../Xiayiye">下一页</a>&nbsp;&nbsp;&nbsp;
<a href="../Zuihouyiye">最后一页</a>
</td></tr>
</table>
</div>
<div>
<table width="200%" border="1" style="border-collapse :collapse;">
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

for(int i=(currentPage-1)*pageSize+1;i<index;i++){
	Goods goods=goodslist.get(i-1);
%>

<tr>
<td align="center"><input type="checkbox" name="goodsId" value="<%=goods.getName()%>"></td>
<td align="center"><%=i %></td>
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


</body>
</html>