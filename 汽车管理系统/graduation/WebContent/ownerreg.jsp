<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加车主信息</title>
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
	<h1 class="hi">车主信息添加</h1>
</div>

<div class="form1"><a href="regcar.jsp"><input type="button" value="添加汽车信息" /></a></div>
<div class="ci">
<form action="AddinformationAction.action" method="post">
	<table>
		<tr>
			<td>会员号：</td>
			<td><input type="text" name="memberid" /></td>
		</tr>
		
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="carowner"/>
		</tr>
	
		<tr>
			<td>车牌号：</td>
			<td><input type="text" name="carnumber" /></td>
		</tr>
		
		<tr>
			<td>电话号码：</td>
			<td><input type="text" name="phonenum" /></td>
		</tr>
		<tr>
		<td>性别：</td>
			<td>
			<input type="radio" name="ownersex" value="man"/>男
			<input type="radio" name="ownersex" value="woman"/>女
			</td>
		</tr>
		<tr>
				<td><input type="submit" value="添加"></td>
				<td><input type="reset" value="重置"></td>
				<td><a href="ownchange.jsp"><input type="button" value="修改信息" /></a></td>
		</tr>
	</table>	

</form>
</div>
</body>
</html>