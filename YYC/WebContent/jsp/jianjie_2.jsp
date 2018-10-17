<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.Renzheng"%>
    <%@page import="dao.RenzhengDao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>


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
<%

List<Renzheng> renzhenglist=(List<Renzheng>)request.getAttribute("renzhenglist");
if(renzhenglist==null){
	
%>
<jsp:forward page="../SearchRenzheng_qian"></jsp:forward>
<%}%>
<div class="div1">
<h2>认证证书：</h2>



<%

for(int i=0;i<renzhenglist.size();i++){
	Renzheng renzheng=renzhenglist.get(i);
		
%>
<img src="http://localhost:8080/YYC/img/<%=renzheng.getPath() %>" title="有效期至：<%=renzheng.getTime() %>" width="100px" height="100px">
<%}%>
</div>
</body>
</html>