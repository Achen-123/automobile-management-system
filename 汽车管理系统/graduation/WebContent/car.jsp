<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>维修车辆出入店信息管理</title>
<link rel="stylesheet" href="css/view.css">
<style>

	body{
	
	width:100%;
	height:725px;
	background:url(Picture/background.jpg) no-repeat;
	/* 让背景图基于容器大小伸缩 */
	background-size:100% 100%;
	}
   .form1{
			float:right;
		}
		
</style>
</head>
<body>
	<span>工号：<s:property value="#session.userinfo.number"/></span>
	<span>姓名：<s:property value="#session.userinfo.username"/>&nbsp;&nbsp; 欢迎登录！</span>
	<h2>车辆信息管理</h2>
	<a href="admin.jsp">首页</a> | <a href="logoutAction.action">注销</a>
	
	<form class="form1" name="search" method="post" action="searchcarnumberAction.action">
	<span style="color:#292929;vertical-align:middle;">维修车辆信息（车牌号）</span>
	<input type="text" style="color:#a4a4a4;vertical-align:middle;" name="carnumber"  value="请输入关键字"  onfocus="this.value=''" /> &nbsp;
	<input type="submit"  value="查询" />
	</form>
	<div class="text">
	<div class="one"><a href="regcar.jsp">添加维修车辆信息</a></div>
	<div class="two"><a href="searchAllcarAction.action">店内全部维修车辆信息查询</a></div>
	<div class="three"><a href="carchange.jsp">维修车辆信息更改</a></div>
	</div>
</body>
</html>