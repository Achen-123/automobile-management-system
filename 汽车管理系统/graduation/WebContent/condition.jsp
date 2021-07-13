<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>维修汽车状态信息</title>
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
	String mess = (String)request.getAttribute("mess");
	if(mess==null){
		mess="";
	}

%>
<%=mess %>
<h2>车辆维修状态管理</h2>
	<a href="admin.jsp">首页</a> | <a href="logoutAction.action">注销</a>
	<form class="form1" name="search" method="post" action="searchCarnumAction.action">
	<span style="color:#292929;vertical-align:middle;">请输入你要查询的车辆序号</span>
	<input type="text" style="color:#a4a4a4;vertical-align:middle;" name="carnumber"  value="请输入车辆序号"  onfocus="this.value=''" /> &nbsp;
	<input type="submit"  value="查询" />
	</form>
	
	<div class="text">
	<div class="one"><a href="carstate.jsp">添加车辆维修状态信息</a></div>
	<div class="two"><a href="searchCarstateAction.action">显示全部车辆维修状态</a></div>
	<div class="three"><a href="carstatechange.jsp">车辆维修状态更改</a></div>
	</div>
	
</body>
</html>