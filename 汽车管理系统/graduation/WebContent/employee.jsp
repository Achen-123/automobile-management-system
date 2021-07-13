<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工信息管理</title>
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
<span>工号：<s:property value="#session.userinfo.number"/></span>
<span>姓名：<s:property value="#session.userinfo.username"/>&nbsp;&nbsp; 欢迎登录！</span>
	<h2>员工信息管理</h2>
	<a href="admin.jsp">首页</a> | <a href="logoutAction.action">注销</a>
	
	<form class="form1" name="search" method="post" action="vaguequeryActionbyname.action">
	<span style="color:#292929;vertical-align:middle;">按姓名查询员工</span>
	<input type="text" name="username" style="color:#a4a4a4;vertical-align:middle;" value="请输入关键字"  onfocus="this.value=''" /> &nbsp;
	<input type="submit"  value="查询" />
	</form>
	<div class="text">
	
	<div class="one"><a href="showWorkerAction.action">查看店内所有员工</a></div>
	<div class="two"><a href="addWorkerAction.action">增加新员工信息</a></div>
	<div class="three"><a href="lookquitWorkerAction.action">查看已离职员工信息</a></div>
	<div class="four"><a href="addifStateAction.action">员工工作状态添加显示</a></div>
	
	</div>
</body>
</html>