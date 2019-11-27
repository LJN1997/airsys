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
<style type="text/css">
.container {
	width: 420px;
	height: 320px;
	min-height: 320px;
	max-height: 320px;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	margin: auto;
	padding: 20px;
	z-index: 130;
	border: 2px solid #009688;
	border-radius: 8px;
	background-color: #fff;
	font-size: 16px;
}

.close {
	background-color: white;
	border: none;
	font-size: 18px;
	margin-left: 410px;
	margin-top: -10px;
}

.layui-input {
	border-radius: 5px;
	width: 300px;
	height: 40px;
	font-size: 15px;
}

.layui-form-item {
	margin-left: -20px;
}

#logoid {
	margin-top: -16px;
	padding-left: 150px;
	padding-bottom: 15px;
}

.layui-btn {
	margin-left: -50px;
	border-radius: 5px;
	width: 350px;
	height: 40px;
	font-size: 15px;
}

.verity {
	width: 120px;
}

.font-set {
	font-size: 13px;
	text-decoration: none;
	margin-left: 120px;
}

a:hover {
	text-decoration: underline;
}
</style>
<body>


	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>添加营业点</legend>
	</fieldset>
	<form class="layui-form" action="/airsys/place/adds" method="post">
		<div class="container">
			<button class="close" title="关闭" onclick=back()>X</button>
			<!--<div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="06.png" height="35">
        </div>-->

			<div class="layui-form-item">
				<label class="layui-form-label">营业点名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" required lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">营业点电话</label>
				<div class="layui-input-inline">
					<input type="text" name="phone" required lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
				<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">营业点位置</label>
				<div class="layui-input-inline">
					<input type="text" name="site" required lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
				<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">营业点省份</label>
				<div class="layui-input-inline">
					<input type="text" name="province" required lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="reset" class="layui-btn layui-btn-primary" lay-submit
						lay-filter="formDemo">重置</button>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="/airsys/assets/js/place.js"></script>
</body>
</html>
