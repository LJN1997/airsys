<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Info,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>航班信息</title>
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>航班信息</legend>
	</fieldset>

	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="150">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>航班编号</th>
					<th>起飞时间</th>
					<th>出发地</th>
					<th>目的地</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${flight}" var="flight">
				<tbody>
					<tr>
						<td>${flight.fnumber}</td>
						<td>${flight.departureTime }</td>
						<td>${flight.fromCity }</td>
						<td>${flight.toCity}</td>
						<td>${flight.tprice }</td>
						<td>
						<button type="button" id="${flight.fnumber }view"
								class="layui-btn layui-btn-primary "
								onclick="shows(${flight.fnumber})">查看</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>

	<script src="/airsys/assets/js/flight.js" charset="utf-8"></script>

	<!-- <script src="/airsys/assets/layui/layui.js" charset="utf-8"></script> -->

</body>
</html>