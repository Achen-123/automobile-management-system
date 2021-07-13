<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改订单</title>
<link rel="stylesheet" href="css/loginreg.css">
<style>
		.form1{
			float:right;
		}
	.ci{
	
		width:350px;
		height:50px;
		opacity:0.6;
		/*水平居中*/
		margin:50px auto;
	
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
<div class="di">
	<h1 class="hi">订单信息修改</h1>
</div>

<div class="form1"><a href="ownerreg.jsp"><input type="button" value="添加车主信息" /></a></div>

<div class="ci">
<form action="UpdateordeleteAction.action" method="post">
	<table>
		<tr>
			<td>订单号：</td>
			<td><input type="text" name="carorder" /></td>
		</tr>
		
		<tr>
			<td>会员号：</td>
			<td><input type="text" name="memberid" /></td>
		</tr>
		<tr>
		
		<tr>
				<td><input type="submit" value="修改"></td>
				<td><input type="reset" value="重置"></td>
				<td><a href="orderreg.jsp"><input type="button" value="添加信息" /></a></td>
		</tr>
	</table>	

</form>
</div>
</body>
</html>