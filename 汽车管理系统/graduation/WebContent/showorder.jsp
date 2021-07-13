<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全部订单信息</title>
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
<h2>订单信息</h2>

				<table>
				<thead>
				<tr>
					<td>会员号</td>
					<td>订单号</td>
				</tr>
				</thead>
				<s:iterator value="#request.orderlist">
				<tr>
				<td><s:property value="memberid"/> </td>
				<td><s:property value="carorder"/></td>
				<td><a href='DeleteorderAction.action?carorder=<s:property value="carorder" />' >删除</a></td>
				</tr>
				
				
				</s:iterator>
				</table>
				
</body>
</html>