<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="daohangtiao.jsp"%>
<%@ include file="bottom.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<script>
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
                    case "#gaikuang":
                        pathn = "jianjie_1.jsp";
                        i = 0;
                        break;　　　　　　　
                    case "#renzheng":
                        pathn = "jianjie_2.jsp";
                        i = 1;
                        break;
                }
                $("#content").load(pathn); //加载相对应的内容
             
            }
            var sId = window.location.hash;
            loadInner(sId);
        });
    </script>

<style type="text/css">
img {
	width: 1280px;
	height: 200px;
}

.menu {
	float: left;
	width: 200px;
}

#content {
	float: left;
}

ul, li {
	display: block;
	position: relative;
}

.biaoti {
	font-size: 30px;
	font-weight: 20px;
	color: blue;
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
	<img src="../img/2.jpg">
	<div class="qiyejianjie">
		<ul class="menu">
			<li class="biaoti" data-id="center">企业简介</li>
			<li><br></li>
			<li data-id="gaikuang"><a href="javascript:;"
				onclick="turnpage('jianjie_1')">企业概况</a></li>
			<li data-id="renzheng"><a href="javascript:;">企业认证</a></li>
		</ul>
		<div id="content"></div>
	</div>
	<div  id="content">
		<div class="mainbox"><p style="position:fixed;top:200px;right:0px">当前位置：企业简介</p></div>
	</div>

</body>
</html>