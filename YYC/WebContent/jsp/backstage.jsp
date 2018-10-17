<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<script>
function userCancel(){
	var r=confirm("确定注销？");
	if(r==true){
		window.location.href="../Logout";
	}
}
        $(function() {
            $(".menu").on("click", "li", function() {
                var sId = $(this).data("id"); //获取data-id的值
                window.location.hash = sId; //设置锚点
                loadInner(sId);
            });
 
            function loadInner(sId) {
                var sId = window.location.hash;
                var pathn, i;
                switch(sId) {
                    case "#users":                    	
                        pathn = "users.jsp";                  
                        i = 0;
                        break; 
                    case "#news":
                        pathn = "news_hou.jsp";
                        i = 1;
                        break;
                     case "#goods":
                    	
                        pathn = "goods_hou.jsp";                  
                        i = 2;
                        break; 
                     case "#jianjie":
                     	
                         pathn = "jianjie_hou.jsp";                  
                         i = 3;
                         break; 
                }
                $("#content").load(pathn); //加载相对应的内容
             
            }
            var sId = window.location.hash;
            loadInner(sId);
        });
    </script>

<style type="text/css">

.menu {
	float: left;
	width: 200px;
}

#content {
	float: left;
}

ul, li {
    font-size:20px;
	display: block;
	position: relative;
}
a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: #2a5f00;
}
</style>
</head>
<body>

<%
String username=(String)session.getAttribute("username");
String logtime=(String)session.getAttribute("logtime");
%>
<div style="background:#DDDDDD; height:55px;  font-size:30px;">
&nbsp;&nbsp;YYC科技公司<span style="font-size:15px;">后台管理</span>
<p style="position:fixed;font-size:15px;top:20px;right:20px;">登录名：<%=username %>&nbsp;&nbsp;登录时间：<%=logtime %>&nbsp;&nbsp;<span onClick="userCancel()" style="cursor:pointer;">[注销]</span></p>
</div>
<hr/>
	<div class="backstage" style="position:fixed;top:80px;">
		<ul class="menu">
			<li data-id="users"><a href="javascript:;">人员管理</a></li>
			<hr style="float:left; width:110px;"/>
			<br/>
			<li data-id="news"><a href="javascript:;">新闻管理</a></li>
			<hr style="float:left; width:110px;"/>
			<br/>
			<li data-id="goods"><a href="javascript:;">产品管理</a></li>
			<hr style="float:left; width:110px;"/>
			<br/>
			<li data-id="jianjie"><a href="javascript:;">简介管理</a></li>
			<hr style="float:left; width:110px;"/>
			<br/>
		</ul>
		<div id="content"></div>
	</div>
	<div  id="content">
		<div class="mainbox"></div>
	</div>

</body>
</html>