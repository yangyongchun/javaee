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
    position:absolute;
    top:0px;
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
      <li><a href="http://localhost:8080/YYC" title="首页">首页</a></li>
      <li><a href="http://localhost:8080/YYC/jsp/jianjie.jsp" title="企业简介">企业简介</a></li>
      <li><a href="http://localhost:8080/YYC/jsp/news_qian.jsp" title="新闻">新闻</a></li>
      <li><a href="http://localhost:8080/YYC/jsp/goods_qian.jsp" title="核心产品">核心产品</a></li>
      <li><a href="http://localhost:8080/YYC/jsp/dingwei.jsp" title="联系我们">联系我们</a></li>
      <li><a href="http://localhost:8080/YYC/jsp/login.jsp" title="用户登录">用户登录</a></li>
    </ul>
  </nav>
</header>
</body>
</html>