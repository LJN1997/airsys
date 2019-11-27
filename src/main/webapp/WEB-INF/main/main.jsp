<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Airport,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>机场信息</title>
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>机场信息</legend>
	</fieldset>
	 
	<input type="text" name="key">
	<button type="button" id="${plan.fnumber }show"
		class="layui-btn layui-btn-primary"
		onclick="onshow('${plan.fnumber}')">搜索</button>

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
					<th>机场编号</th>
					<th>机场名称</th>
					<th>机场位置</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${air}" var="act">
				<tbody>
					<tr>
						<td>${act.airportNumber}</td>
						<td>${act.airportName }</td>
						<td>${act.airportCity }</td>
						<td>
							<button type="button" id="${act.airportNumber }update"
								class="layui-btn layui-btn-warm "
								onclick="onupdate('${act.airportNumber}')">修改</button>
							<button type="button" id="${act.airportNumber }delete"
								class="layui-btn layui-btn-danger"
								onclick="ondelete('${act.airportNumber}')">删除</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<button type="button" class="layui-btn layui-btn-normal"
			onclick="adds()">添加</button>

	</div>

	<script src="/airsys/assets/js/airport.js" charset="utf-8"></script>

	<!-- <script src="/airsys/assets/layui/layui.js" charset="utf-8"></script> -->

</body>
</html>