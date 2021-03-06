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
					<th>折扣</th>
					<th>头等舱剩余座位</th>
					<th>经济座剩余座位</th>
					<th>商务舱剩余座位</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${flight}" var="flight">
				<tbody>
					<tr>
						<td>${flight.fnumber}</td>
						<td>${flight.discount}</td>
						<td>${flight.firstClassRemainSeats}</td>
						<td>${flight.businessClassRemainSeats}</td>
						<td>${flight.economyClassRemainSeats }</td>
						<td>
							<button type="button" id="${flight.fnumber}delete" class="layui-btn layui-btn-danger" onclick="ondelete('${flight.fnumber}')">删除</button>
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