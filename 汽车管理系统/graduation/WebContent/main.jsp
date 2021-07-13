<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s" %>
<jsp:useBean id="userinfo" class="com.po.Userinfo" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理页面</title>
<link rel="stylesheet" href="css/mainview.css" />
<style type="text/css">
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

<!-- 提取员工的工号，姓名 （s:property是struts的标签）-->
<%
		if(userinfo.getNumber()==null){%>
			<a href="login.jsp">登录</a>|<a href="admin.jsp">首页</a>
		<% }else{%>
	
	<span>工号：<s:property value="#session.userinfo.number"/></span>
	<span>姓名：<s:property value="#session.userinfo.username"/>&nbsp;&nbsp; 欢迎登录！</span>
	/<a href="logoutAction.action">注销</a>|<a href="admin.jsp">首页</a>	<%  }%>

	<div class="text">
	<div class="mian">管理主页面</div>
	
	<div class="one"><a href="ifemployeeAction.action">员工信息管理</a> </div>
	<div class="two"><a href="ifcarAction.action">维修车辆出入店信息管理</a></div>
	<div class="three"><a href="ifconditionAction.action">维修汽车状态信息</a></div>
	<div class="four"><a href="ifownerAction.action">汽车车主信息管理</a></div>
	<div class="five"><a href="iforderAction.action">订单信息管理</a></div>
	
	
	
	</div>
</body>
</html>