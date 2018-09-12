<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
nav{
    float: left;
    width:100%;
    height:50px;
    background-color:black;
    position:fixed;
    top:0
    color:white;
}
nav ul {
    float:left;
    margin: 0px;
    padding: 0 0 0 0;
    width: 920px;
    list-style: none;
}
nav ul li {
    display: inline;
}
nav ul li a {
    float: left;
    padding: 11px 20px; 
    font-size: 20px;
    text-align: center;
    text-decoration: none;
    color: #fff;    
    font-family: Tahoma;
    outline: none;
}
nav li a:hover {
    color: #2a5f00;
}
</style>
</head>
<body>
<header>
  <nav>
    <ul>
      <li><a href="#" title="首页" target="_blank">首页</a></li>
      <li><a href="http://localhost:8080/YYC/jsp/jianjie.jsp" title="企业简介" target="_blank">企业简介</a></li>
      <li><a href="#" title="新闻" target="_blank">新闻</a></li>
      <li><a href="#" title="产品展示" target="_blank">核心竞争力</a></li>
      <li><a href="#" title="联系我们" target="_blank">联系我们</a></li>
      <li><a href="#" title="用户登录" target="_blank">用户登录</a></li>
    </ul>
  </nav>
</header>
</body>
</html>