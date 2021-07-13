<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店内维修车辆添加</title>
<link rel="stylesheet" href="css/loginreg.css">
<style type="text/css">
.ci{
	/*进行覆盖*/
	
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
	<h1 class="hi">车辆信息添加</h1>
</div>
<div class="ci">
<form action="addCarinformationAction.action" method="post">
	<table>
		<tr>
			<td>车牌号：</td>
			<td><input type="text" name="carnumber" /></td>
		</tr>
		
		<tr>
			<td>汽车名称：</td>
			<td><input type="text" name="carname"/>
		</tr>
		<tr>
			<td>汽车颜色：</td>
			<td><input type="text" name="carcolor" /></td>
		</tr>
		
		<tr>
				<td><input type="submit" value="添加"></td>
				<td><input type="reset" value="重置"></td>
				<td><a href="carchange.jsp"><input type="button"  value="修改车辆" /></a></td>
		</tr>
	</table>	

</form>
</div>
</body>
</html>