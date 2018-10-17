<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>请添加认证图片</h2>

<form action="../addRenzheng" method="post">
有效期：<br><input type="text" name="time"><br>
图片：<br><input id="pic" type="file" name = 'path'/><br>
<input type="submit" value="确定">
</form>
</body>
</html>