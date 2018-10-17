<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>请输入添加产品的信息</h2>

<form action="../addGoods" method="post">
产品名：<br><input type="text" name="name"><br>
图片：<br><input id="pic" type="file" name = 'pic'/><br>
简介：<br><textarea name="introduce" rows="10" cols="18"></textarea><br>
<input type="submit" value="确定">
</form>
</body>
</html>