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
		<button style="float: right" type="button" 
			class="layui-btn layui-btn-danger"
			onclick="back()">返回</button>
	</fieldset>

	<c:forEach items="${flight}" var="flight">
	<div style="width: 1000px;float: left">
		<div class="layui-form-item">
			<label class="layui-form-label">编号</label>
			<div class="layui-input-block">
				<input type="text" name="fnumber" value="${flight.fnumber }"
					lay-verify="title" readonly unselectable="on" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">出发地</label>
			<div class="layui-input-block">
				<input type="text" name="fromCity" value="${flight.fromCity}"
					lay-verify="title" readonly unselectable="on" autocomplete="off"
					class="layui-input">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">目的地</label>
			<div class="layui-input-block">
				<input type="text" name="toCity" value="${flight.toCity}"
					lay-verify="title" readonly unselectable="on" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">起飞时间</label>
			<div class="layui-input-block">
				<input type="text" name="departureTime"
					value="${flight.departureTime }" lay-verify="title" readonly
					unselectable="on" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">到达时间</label>
			<div class="layui-input-block">
				<input type="text" name="arrivalTime" value="${flight.arrivalTime}"
					lay-verify="title" readonly unselectable="on" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">头等舱剩余座位</label>
			<div class="layui-input-block">
				<input type="text" name="firstClassRemainSeats"
					value="${flight.firstClassRemainSeats }" lay-verify="title"
					readonly unselectable="on" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">经济舱剩余座位</label>
			<div class="layui-input-block">
				<input type="text" name="businessClassRemainSeats"
					value="${flight.businessClassRemainSeats}" lay-verify="title"
					readonly unselectable="on" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商务舱剩余座位</label>
			<div class="layui-input-block">
				<input type="text" name="economyClassRemainSeats"
					value="${flight.economyClassRemainSeats }" lay-verify="title"
					readonly unselectable="on" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">价格</label>
			<div class="layui-input-block">
				<input type="text" name="tprice" value="${flight.tprice }"
					lay-verify="title" readonly unselectable="on" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">折扣</label>
			<div class="layui-input-block">
				<input type="text" name="seasonDiscount"
					value="${flight.seasonDiscount }" lay-verify="title" readonly
					unselectable="on" autocomplete="off" class="layui-input">
			</div>
		</div>
</div>
	</c:forEach>
</body>
	<script src="/airsys/assets/js/flight.js" charset="utf-8"></script>
</html>

