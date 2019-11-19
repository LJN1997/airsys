<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,entity.*,java.util.*"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta charset="utf-8">
<title>营业员信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
	<script src="/airsys/assets/layui/layui.js" charset="utf-8"></script>
	<script src="/airsys/assets/js/placeadmin_sales.js" charset="utf-8"></script>
	<script src="/airsys/assets/js/jquery-1.7.2.js"></script>   
	<script src="/airsys/assets/js/test.js"></script>   
	<link rel="stylesheet" href="/airsys/assets/js/main.js">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>营业员信息</legend>
	</fieldset>
	
	<form action="/airsys/placeadmin/searchs" method="post">
		
	<div class="layui-form">
	
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="200">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>工号</th>
					<th>名称</th>
					
				</tr>
			</thead>

		</table>

	</div>
	 
</form>


</body>
</html>