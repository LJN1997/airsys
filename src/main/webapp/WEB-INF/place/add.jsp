<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Place,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>添加营业点</title>
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
		<legend>添加营业点</legend>
	</fieldset>

	<form class="layui-form" action="/airsys/place/adds" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">营业点名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" lay-verify="title"
					autocomplete="off" placeholder="请输入营业点名称" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">营业点电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" lay-verify="title"
					autocomplete="off" placeholder="请输入营业点电话" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">营业点位置</label>
			<div class="layui-input-block">
				<input type="text" name="site" lay-verify="title"
					autocomplete="off" placeholder="请输入营业点位置" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">营业点所在所在省份</label>
			<div class="layui-input-block">
				<input type="text" name="province" lay-verify="title"
					autocomplete="off" placeholder="请输入营业点所在所在省份" class="layui-input">
			</div>
		</div>
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
