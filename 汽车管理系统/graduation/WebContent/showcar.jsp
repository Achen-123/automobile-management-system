<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>店内全部维修车辆信息</title>
</head>
<body>
	<h2>店内维修车辆信息</h2>

	<table>
				<thead>
				<tr>
					<td>汽车名称</td>
					<td>车牌号</td>
					<td>汽车颜色</td>
				</tr>
				</thead>
				<s:iterator value="#request.carlist">
				<tr>
				<td><s:property value="carname"/> </td>
				<td><s:property value="carnumber"/></td>
				<td><s:property value="carcolor"/></td>
				</tr>
				</s:iterator>
				</table>






</body>
</html>