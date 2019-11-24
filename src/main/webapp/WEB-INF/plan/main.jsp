<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Airport,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>航班计划</title>
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>航班计划信息</legend>
	</fieldset>

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
					<th>航班编号</th>
					<th>出发城市</th>
					<th>目的城市</th>
					<th>起飞时间</th>
					<th>飞机类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${flightplan}" var="plan">
				<tbody>
					<tr>
						<td>${plan.fnumber}</td>
						<td>${plan.fromCity }</td>
						<td>${plan.toCity }</td>
						<td>${plan.startDate }</td>
						<td>${plan.type }</td>
						<td>
						<%-- 	<button type="button" id="${plan.fnumber }show"
								class="layui-btn layui-btn-primary"
								onclick="onshow('${plan.fnumber}')">查看</button> --%>
							<button type="button" id="${plan.fnumber }update"
								class="layui-btn layui-btn-warm "
								onclick="onupdate('${plan.fnumber}')">修改</button>
							<button type="button" id="${plan.fnumber }delete"
								class="layui-btn layui-btn-danger"
								onclick="ondelete('${plan.fnumber}')">删除</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<button type="button" class="layui-btn layui-btn-normal"
			onclick="adds()">添加</button>

	</div>

	<script src="/airsys/assets/js/plan.js" charset="utf-8"></script>

	<!-- <script src="/airsys/assets/layui/layui.js" charset="utf-8"></script> -->

</body>
</html>