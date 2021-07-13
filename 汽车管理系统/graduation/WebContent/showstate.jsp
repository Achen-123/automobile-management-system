<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示员工工作状态</title>
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
	<h2>员工工作状态</h2>

				<table>
				<thead>
				<tr>
					<td>工号</td>
					<td>工作状态</td>
				</tr>
				<thead>
				<s:iterator value="#request.showstatelist">
				<tr>
				<td><s:property value="number"/> </td>
				<td><s:property value="scondition"/></td>
				</tr>
				</s:iterator>
				</table>
				
</body>
</html>