<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.Emp"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script language="javascript">
function select(){
	window.location.href="../selectUser?username=";
}
function cbkSelect(sta,flag){
	for(var i=0;i<document.getElementsByName(flag).length;i++){
		document.getElementsByName(flag)[i].checked=sta;
	}
}
function addUser(){
	window.location.href="http://localhost:8080/YYC/jsp/addUser.jsp";
		
	
}
function deleteUser(){
	var allCheck=document.getElementsByName("userId");
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
		
		window.location.href="http://localhost:8080/YYC/deleteUser?del="+delstr;
		
		
		}

	else{
		alert("没有选中信息！");
	}
}
function editUser(){
	var allCheck=document.getElementsByName("userId");
	var num=0;
	var username="";
	for(var i=0;i<allCheck.length;i++){
		if(allCheck[i].checked)
		{
			num++;
			username=allCheck[i].value;
		}
	}
	if(num==1){
		
		window.location.href="http://localhost:8080/YYC/jsp/editUser.jsp?username="+username;
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
List<Emp> userlist=(List<Emp>)request.getAttribute("userlist");
if(userlist==null){
%>
<jsp:forward page="../SearchUser"></jsp:forward>
<%} %>
<table width="100%" height="100%" border=0 cellspacing="0" cellpadding="0">
<tr style="height:2%;">
<td>
<table border="0" width="100%" >
<tr>
<td><h3>用户信息</h3></td>
</tr>
</table>
</td> 
</tr>
<tr style="height:96%">
<td>
<form method="POST" name="search" action="http://localhost:8080/YYC/SelectUser">
<table width="100%">
<tr>
<td width="10%" >用户名：</td>
<td style="width:30%"><input type="text" name="username" size="100%" style="width:100%;"></td>
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
用户信息列表
</td>
</tr>
</table>
<div style="position:fixed;left:250px;bottom:20px;z-index:1000;">
<table width="200%">
<tr><td style="cursor:hand;">
<button style="width:20%" onClick="addUser()">新增用户</button>
<button style="width:20%" onClick="deleteUser()">删除</button>
<button style="width:30%" onClick="editUser()">修改用户信息</button>
</td></tr>
</table>
</div>
<div>
<table width="100%" border="1" style="border-collapse :collapse;">
<thead>
<tr>
<th width="1%">
<input type="checkbox" name="checkAll" onClick="cbkSelect(this.checked,'userId')">
</th>
<th width="10%"><span>序号</span></th>
<th width="15%"><span>用户名</span></th>
<th width="10%"><span>密码</span></th>
<th width="20%"><span>注册时间</span></th>
<th width="10%"><span>权限</span></th>
</tr>
</thead>
<tbody>
<%

for(int i=0;i<userlist.size();i++){
	Emp emp=userlist.get(i);
%>

<tr>
<td align="center"><input type="checkbox" name="userId" value="<%=emp.getUsername()%>"></td>
<td align="center"><%=i+1 %></td>
<td align="center"><%=emp.getUsername() %></td>
<td align="center"><%=emp.getPassword() %></td>
<td align="center"><%=emp.getCreateTime() %></td>
<td align="center"><%=emp.getPower() %></td>
</tr>
<%} %>
</tbody>
</table>
</div>
</td>
</tr>

</table>

</body>
</html>