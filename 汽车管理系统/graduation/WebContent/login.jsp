<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工登录</title>
<link rel="stylesheet" href="css/loginreg.css">
<style>
body{
	
	width:100%;
	height:725px;
	background:url(Picture/reglogin.jpg) no-repeat;
	/* 让背景图基于容器大小伸缩 */
	background-size:100% 100%;
	}

</style>

</head>
<body>
<%
//解决乱码
	request.setCharacterEncoding("utf-8");
//显示信息
	String mess = (String)request.getAttribute("mess");
	if(mess==null){//要有这个否则上面会有一个null
		mess="";
	}
	
%>
<%=mess %>
<div class="di">
	<h1 class="hi">欢迎登录</h1>
</div>
<form action="loginAction.action" method="post">
	<table class="ta">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>工号：</td>
			<td><input type="text" name="number" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="pwd" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" ></td>
			<td><input type="reset" value="重置" /></td>
		</tr>
	</table>
</form>
</body>
</html>