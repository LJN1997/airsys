<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Place,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>营业点信息</title>
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>营业点信息</legend>
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
					<th>营业点名称</th>
					<th>营业点电话</th>
					<th>营业点位置</th>
					<th>营业点所在省份</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${place}" var="place">
				<tbody>
					<tr>
						<td>${place.pname}</td>
						<td>${place.pphone }</td>
						<td>${place.psite }</td>
						<td>${place.province }</td>
						<td>
							<button type="button" id="${place.pid }update" class="layui-btn layui-btn-warm " onclick="onupdate(${place.pid})">修改</button>
							<button type="button" id="${place.pid }delete" class="layui-btn layui-btn-danger" onclick="ondelete(${place.pid})">删除</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
			<button type="button"  class="layui-btn layui-btn-normal" onclick="add()">添加</button>
	</div>
	
	<script src="/airsys/assets/js/place.js" charset="utf-8"></script>


</body>
</html>