<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Airport,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>添加航班计划</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>


	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>添加航班计划</legend>
	</fieldset>

	<form class="layui-form" action="/airsys/plan/adds" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">飞机编号</label>
			<div class="layui-input-block">
				<input type="text" name="fnumber" lay-verify="title"
					autocomplete="off" placeholder="请输入机场编号" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">出发地</label>
			<div class="layui-input-block">
				<input type="text" name="fromCity" lay-verify="title"
					autocomplete="off" placeholder="请输入出发地" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">目的地</label>
			<div class="layui-input-block">
				<input type="text" name="tocity" lay-verify="title"
					autocomplete="off" placeholder="请输入目的地" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">出发日期</label>
			<div class="layui-input-block">
				<input type="date" name="startdate" lay-verify="title"
					autocomplete="off" placeholder="请输入出发时间" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">到达日期</label>
			<div class="layui-input-block">
				<input type="date" name="enddate" lay-verify="title"
					autocomplete="off" placeholder="请输入到达时间" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">飞机类型</label>
			<div class="layui-input-block">
				<input type="text" name="type" lay-verify="title"
					autocomplete="off" placeholder="请输入飞机类型" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">价格</label>
			<div class="layui-input-block">
				<input type="text" name="tprice" lay-verify="title"
					autocomplete="off" placeholder="请输入价格" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">里程/km</label>
			<div class="layui-input-block">
				<input type="text" name="length" lay-verify="title"
					autocomplete="off" placeholder="请输入里程" class="layui-input">
			</div>
		</div>
	<!-- 	<div class="layui-form-item">
			<label class="layui-form-label">预计起飞时间</label>
			<div class="layui-input-block">
				<input type="date" name="expstarttime" lay-verify="title"
					autocomplete="off"  class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">预计达到时间</label>
			<div class="layui-input-block">
				<input type="date" name="expendtime" lay-verify="title"
					autocomplete="off" class="layui-input">
			</div>
		</div> -->
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
				<button type="reset" class="layui-btn layui-btn-primary" lay-submit
					lay-filter="formDemo">重置</button>
			</div>
		</div>
	</form>
</body>
</html>
