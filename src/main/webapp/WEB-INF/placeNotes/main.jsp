<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Airport,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>订单信息</title>
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>订单信息</legend>
	</fieldset>

	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>联系人</th>
					<th>订单日期</th>
					<th>航班编号</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${placeNote}" var="plcNote">
				<tbody>
					<tr>
						<td>${plcNote.oname}</td>
						<td>${plcNote.tdate }</td>
						<td>${plcNote.fnumber }</td>
						<td>${plcNote.tprice }</td>
						<td>
							   <button type="button" id="${plcNote.oid }show" class="layui-btn layui-btn-primary" onclick="onshow(${plcNote.oid})">查看</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>

	<script src="/airsys/assets/js/placeNotes.js" charset="utf-8"></script>

	<!-- <script src="/airsys/assets/layui/layui.js" charset="utf-8"></script> -->

</body>
</html>