<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>已离职员工信息</title>
<link rel="stylesheet" href="css/view.css">
<style type="text/css">
body{
	
	width:100%;
	height:725px;
	background:url(Picture/background.jpg) no-repeat;
	/* 让背景图基于容器大小伸缩 */
	background-size:100% 100%;
	}
	table{
	margin-top:50px;
	
	}
</style>
</head>
<body>
	<h2>离职员工信息</h2>

				<table>
				<thead>
				<tr>
					<td>姓名</td>
					<td>性别</td>
					<td>工号</td>
					<td>部门</td>
				</tr>
				</thead>
			<s:iterator value="#request.quitlist">
				<tr>
				<td><s:property value="username"/> </td>
				<td><s:property value="sex"/></td>
				<td><s:property value="number"/></td>
				<td><s:property value="department"/></td>
				<td><a href='deleteWorkerAction.action?number=<s:property value="number" />' >删除</a></td>
				</tr>
				</s:iterator>
				</table>
				
</body>
</html>