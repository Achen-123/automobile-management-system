<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单信息管理</title>
<link rel="stylesheet" href="css/view.css">
<style>
		.form1{
			float:right;
		}
		

body{
	
	width:100%;
	height:725px;
	background:url(Picture/background.jpg) no-repeat;
	/* 让背景图基于容器大小伸缩 */
	background-size:100% 100%;
	}

</style>
</head>
<body>
<%
	//解决乱码问题
	request.setCharacterEncoding("utf-8");
	//接收提示信息并显示
	String mess = (String)request.getAttribute("mess");
	if(mess==null){
		mess="";
	}
%>
<%=mess %>
<h2>订单管理</h2>
	<a href="admin.jsp">首页</a> | <a href="logoutAction.action">注销</a>
	
	<form class="form1" name="search" method="post" action="vaguequeryAction.action">
	<span style="color:#292929;vertical-align:middle;">查询订单号</span>
	<input type="text" name="carorder" style="color:#a4a4a4;vertical-align:middle;" value="请输入订单号"  onfocus="this.value=''" /> &nbsp;
	<input type="submit"  value="查询" />
	</form>
	<div class="text">
	<div class="one"><a href="orderreg.jsp">添加订单信息</a></div>
	<div class="two"><a href="searchAllAction.action">查询全部订单信息</a></div>
	<div class="three"><a href="searchAllAction.action">删除订单信息</a></div>
	</div>
</body>
</html>