<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>请输入添加新闻的信息</h2>

<form action="../addNews" method="post">
标题：<br><input type="text" name="title"><br>
内容：<br><textarea name="content" rows="10" cols="18"></textarea><br>
<input type="submit" value="确定">
</form>
</body>
</html>