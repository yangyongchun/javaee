<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="dao.Goods"%>
    <%@page import="dao.GoodsDao"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

body {
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String name=request.getParameter("name");
name = java.net.URLDecoder.decode(name,"UTF-8"); 
System.out.print(name);
GoodsDao dao=new GoodsDao();
List goodslist=(List)dao.getGoodsByName1(name);
Goods goods=(Goods)goodslist.get(0);
%>
<br><br>
产品名：<%=goods.getName() %><br><br>
图片：<br><img src="http://localhost:8080/YYC/img/<%=goods.getPic()%>" width="200px" height="200px"><br><br>
介绍：<br><%=goods.getIntroduce() %><br>
</body>
</html>