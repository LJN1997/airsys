<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Place,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户信息</title>
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>用户信息</legend>
	</fieldset>

	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="200">
				<col width="300">
				<col width="200">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>姓名</th>
					<th>身份证号</th>
					<th>联系方式</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${user}" var="user">
				<tbody>
					<tr>
						<td>${user.uname}</td>
						<td>${user.idcard }</td>
						<td>${user.uphone }</td>
						<td>
							<button type="button" id="${user.uid }delete" class="layui-btn layui-btn-danger" onclick="ondelete(${user.uid})">拉黑</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	
	<script src="/airsys/assets/js/usershow.js" charset="utf-8"></script>


</body>
</html>