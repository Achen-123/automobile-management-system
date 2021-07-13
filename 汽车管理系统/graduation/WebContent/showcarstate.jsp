<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>汽车维修状态信息</title>
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
<h2>车辆维修状态</h2>

				<table>
				<thead>
				<tr>
					<td>车牌号</td>
					<td>位置</td>
					<td>汽车维修状态</td>
					
				</tr>
				<thead>
				<s:iterator value="#request.carstatelist">
				<tr>
				<td><s:property value="carnumber"/> </td>
				<td><s:property value="located"/></td>
				<td><s:property value="carcond"/></td>
				</tr>
				</s:iterator>
				</table>

</body>
</html>