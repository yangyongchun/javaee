<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="jsp/daohangtiao.jsp" %>
    <%@ include file="jsp/bottom.jsp" %>
    <%@page import="dao.PageBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        *{
            padding: 0px;
            margin: 0px;
            font-family: "微软雅黑", "宋体";
        }
        body{
            position: relative;
        }
        #box{
            overflow: hidden;
            position: relative;
            width: 1280px;
            height: 525px;
            border-top:3px slateblue solid;
            border-bottom: 3px slateblue solid;
            top:50px;
            margin: auto;
        }
        #list{
            position: absolute;
            font-size: 0px;
            width:8960px;
            z-index: 1;
            -webkit-transition: left .2s linear ;
        }
        #bottom{
            position: absolute;
            width: 100px;
            height:40px;
            text-align: center;
            line-height: 40px;
            /*border: 1px red solid;*/
            top: 450px;
            z-index: 2;
        }
        #bottom span{
            display:inline-block;
            width: 8px;
            height: 8px;
            border-radius: 8px;
            padding:1px;
          /*//  border: 1px #6F6F6F solid;*/
            background: #6F6F6F;
            cursor: pointer;
        }
        #bottom .on{
            background: #E6821B;!important;
        }
        #prev{
            display: block;
            width: 40px;
            height: 40px;
            text-align:center;
            line-height: 40px;
            /*border: 1px red solid;*/
            position: absolute;
            z-index: 2;
            text-decoration: none;
            font-size: 35px;
            top: 250px;
            color:white ;
            background:rgba(255,255,255,.2);
            -webkit-transition: all .2s linear;
            opacity: 0;
        }
        #box:hover>#prev{
            opacity: 1;
        }
        #prev:hover{
            background: rgba(0,0,0,.3);
        }
        #next{
            display: block;
            width: 40px;
            height: 40px;
            text-align:center;
            line-height: 40px;
            /*border: 1px red solid;*/
            position: absolute;
            z-index: 2;
            text-decoration: none;
            font-size: 35px;
            top: 250px;
            right: 0px;
            color:white ;
            background:rgba(255,255,255,.2);
            -webkit-transition: all .2s linear;
            opacity: 0;
        }
        #box:hover>#next{
            opacity: 1;
        }
        #next:hover{
            background: rgba(0,0,0,.3);
        }
    </style>
</head>
<body>
<div id="box">
    <div id="list" style="left: -1280px;">
        <img src="http://localhost:8080/YYC/img/lunbo5.jpg" alt="1"/>
        <img src="http://localhost:8080/YYC/img/1.jpg" alt="1"/>
        <img src="http://localhost:8080/YYC/img/lunbo2.jpg" alt="2"/>
        <img src="http://localhost:8080/YYC/img/lunbo3.jpg" alt="3"/>
        <img src="http://localhost:8080/YYC/img/lunbo4.jpg" alt="4"/>
        <img src="http://localhost:8080/YYC/img/lunbo5.jpg" alt="5"/>
        <img src="http://localhost:8080/YYC/img/1.jpg" alt="5"/>
    </div>
    <div id="bottom">
        <span index="1" class="on"></span>
        <span index="2"></span>
        <span index="3"></span>
        <span index="4"></span>
        <span index="5"></span>
    </div>
    <a href="javascript:;" id="prev" class="arrow"><</a>
    <a href="javascript:;" id="next" class="arrow">></a>
</div>
 
  <script>
      window.onload=function(){
          var box=document.getElementById("box");
          var list=document.getElementById("list");
          var bottom=document.getElementById("bottom").getElementsByTagName("span");
          console.log(bottom);
          var prev=document.getElementById("prev");
          var next=document.getElementById("next");
 
          /**
           * 封装函数，点击时左右移动，判断是否为最后和最前一张图的位置，调用函数触发
           * @param n
           */
          function animate(n){
           var left=parseInt(list.style.left)+n;
               list.style.left=left+"px";
              if(left<-6400){
                  list.style.left=-1280+"px";
              }
              if(left>-1280){
                  list.style.left=-6400+"px";
              }
          }
          var index=1;
          //点击左键
          prev.onclick=function(){
              //如果为第一个圆点时，点击后切换到第二个圆点
              if(index==1){
                  index=5;
              }else{
                  index-=1;
              }
 
              for(var i=0;i<bottom.length;i++){
                      if(bottom[i].className="on"){
                          bottom[i].className="";
                      }
              }
              bottom[index-1].className="on";
              console.log(bottom);
              animate(1280);
          }
 
 
 
          //点击右键
          next.onclick=function() {
              animate(-1280);
              //如果为第一个圆点时，点击后切换到最后一个圆点。
              if (index ==5) {
                  index = 1;
              } else {
                  index += 1;
              }
              //循环每个圆点，如果点击之前为色圆点，改变为无色圆点。
              for (var i = 0; i < bottom.length; i++) {
                  if (bottom[i].className = "on") {
                      bottom[i].className = "";
                  }
              }
              //下一个圆点颜色添加。
              bottom[index - 1].className = "on";
              //console.log(bottom);
          }
                //函数封装
              function buttom(){
                  //循环每个圆点，如果点击之前为色圆点，改变为无色圆点。
                  for(var i=0;i<bottom.length;i++){
                      if(bottom[i].className="on"){
                          bottom[i].className="";
                      }
                  }
                  //下一个圆点颜色添加。
                  bottom[index-1].className="on";
                  //console.log(bottom);
              }
              //点击小圆点图片切换
               var index=1;
               for(var i=0;i<bottom.length;i++){
                        bottom[i].onclick=function(){
                            if(this.className=="on"){
                                return;
                            }
                            var mydex=parseInt(this.getAttribute("index"));
                            console.log(mydex);
                            var  dex=-1280*(mydex-index);
                            animate(dex);
                            index=mydex;
                            //点击小圆点颜色改变，调用buttom，改变颜色
                            buttom();
                            console.log(dex+"dd");
                        }
                }
          //实现轮播自动播放
          var time;
          function play(){
              time=setInterval(function(){
                  next.onclick();
              },2000)
              function clear(){
                  time=clearInterval(time);
              }
          }
          box.onmouseover=play();
          box.onmouseout=clear();
 
      }
 
  </script>
</body>
</html>
