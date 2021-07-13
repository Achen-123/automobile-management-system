<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改汽车维修状态</title>
<link rel="stylesheet" href="css/loginreg.css">
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
<%
	String mess = (String)request.getAttribute("mess");
	if(mess==null){
		mess="";
	}

%>
<%=mess %>
<div class="di">
	<h1 class="hi">修改维修状态</h1>
</div>
	<form action="changeCarstateAction.action" method="post">
	<table class="ta">
		<tr>
			<td>车牌号：</td>
			<td><input type="text" name="carnumber" /></td>
		</tr>
		
		
		<tr>
			<td>位置</td>
			<td><input type="radio" name="located" value="入店" />店内
				<input type="radio" name="located" value="出店" />店外</td>
		</tr>
		
		<tr>
			<td>汽车维修状态：</td>
			<td><input type="radio" name="carcond" value="待维修"/>待维修
				<input type="radio" name="carcond" value="维修中"/>维修中
				<input type="radio" name="carcond" value="已维修"/>已维修 </td>
		</tr>
		
		<tr>
			<td><input type="submit" value="修改"/></td>
			<td><input type="reset" value="重置" /></td>
			<td><a href="carstate.jsp"><input type="button"  value="添加汽车" /></a></td>  
		</tr>
		</table>
		</form>
</body>
</html>