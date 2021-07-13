<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工工作状态</title>
<link rel="stylesheet" href="css/loginreg.css">
<style>
	.mi{
	margin:0px 300px;
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
<div class="di">
	<h1 class="hi">员工工作状态</h1>
</div>
<div class="mi" ><div class="one"><a href="showWorkstateAction.action">显示全部员工工作状态</a></div></div>

<form action="addStateAction.action" method="post">
	<table class="ta">
		<tr>
			<td>工号：</td>
			<td><input type="text" name="number" /></td>
		</tr>
		<tr>
			<td>员工工作状态：</td>
			<td><input type="radio" name="scondition" value="上班"/>上班
				<input type="radio" name="scondition" value="休假"/>请假 
				<input type="radio" name="scondition" value="离职"/>离职 </td>
		</tr>
		
		<tr>
			<td><input type="submit" value="添加"/></td>
			<td><input type="reset" value="重置" /></td>
		 	<td><a href="statechange.jsp"><input type="button"  value="修改状态" /></a></td>  
		</tr>
	</table>
</form>
</body>
</html>