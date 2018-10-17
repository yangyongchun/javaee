<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="daohangtiao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.login_form {
	position: fixed;
	left: 40%;
}

</style>
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<br/>
<br/>
<br/>
	<h1 align="center">YYC科技公司</h1>
	<div class="login_form">
		<form action="../Login" method="post">
			用户名： <br /> <input type="text" name="username" style="width:220px;height:20px;"><br /> 密码： <br /> 
			<input type="password" name="password" style="width:220px;height:20px;"><br /> 
				<input type="submit" value="登录" style="font-size:50px;">
		</form>
	</div>
</body>
</html>