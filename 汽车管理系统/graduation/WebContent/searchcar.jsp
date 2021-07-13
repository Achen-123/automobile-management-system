<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>维修汽车信息查询</title>
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

<div class="di">
	<h1 class="hi">车辆信息查询</h1>
</div>
<div class="ci">
<form action="searchcarnumberAction.action" method="post">

	<table class="">
		<tr>
			<td>请输入车牌号</td>
			<td><input type="text" name="carnumber" /></td>
		</tr>
		
		<tr>
			 <td><input type="submit" value="查询" /></td>
			 <td><input type="reset"   value="重置" /></td>
		</tr>
		
	</table>
</form>
</div>
		
</body>
</html>