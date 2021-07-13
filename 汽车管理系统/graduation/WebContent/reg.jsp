<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工注册</title>
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
	//解决乱码问题
	request.setCharacterEncoding("utf-8");
	//接收提示信息并显示
	String mess = (String)request.getAttribute("mess");
	if(mess==null){
		mess="";
	}
%>
<%=mess %>
<div class="di">
	<h1 class="hi">欢迎注册</h1>
</div>

<form action="regAction.action" method="post">
	<table class="ta">
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="username"/>
		</tr>
		
		<tr>
			<td>工号：</td>
			<td><input type="text" name="number" /></td>
		</tr>
		
		<tr>
			<td>密码：</td>
			<td><input type="password" name="pwd"/></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="password" name="pwd1"/></td>
		</tr>
		<tr>
		<td>性别：</td>
			<td>
			<input type="radio" name="sex" value="man"/>男
			<input type="radio" name="sex" value="woman"/>女
			</td>
		</tr>
		<tr>
		<td>部门：</td>
			<td>
			<input type="radio" name="department" value="sale"/>售前部
			<input type="radio" name="department" value="aftermarket"/>售后部
			<input type="radio" name="department" value="group"/>综合部（人事、财务、后勤部）
			<input type="radio" name="department" value="management"/>管理员
			</td>
		</tr>
		<tr>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置"></td>
		</tr>
	</table>	

</form>


</body>
</html>