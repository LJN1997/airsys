<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.*,util.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<style type="text/css">
h2 {
	font-size: 30px;
	margin-bottom: 30px;
}

.container {
	width: 350px;
	min-height: 420px;
	max-height: 460px;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	margin: auto;
	padding: 20px;
	z-index: 130;
	border-radius: 8px;
	background-color: #fff;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
	font-size: 16px;
}

.layui-input {
	border-radius: 5px;
	width: 250px;
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
	margin-left: -80px;
	border-radius: 5px;
	width: 300px;
	height: 40px;
	font-size: 15px;
	margin-top: 20px;
}

.font-set {
	font-size: 13px;
	text-decoration: none;
	margin-left: 120px;
}
</style>
</head>

<body>

	<form class="layui-form"
		action="http://localhost:8080/airsys/sales/saleinfo/1" method="post">
		<c:forEach items="${sale}" var="info">
			<div class="container">
				<h2>个人信息</h2>
				<div class="layui-form-item">
					<label class="layui-form-label">工号</label>
					<div class="layui-input-block">
						<input type="text" value="${info.snumber}" name="num" required
							lay-verify="required" placeholder="请输入工号" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" value="${info.sname}" name="num" required
							lay-verify="required" placeholder="请输入姓名" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">营业点名称</label>
					<div class="layui-input-block">
						<input type="text" value="${info.pname}" name="num" required
							lay-verify="required" placeholder="请输入营业点名称" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-block">
						<input type="text" value="${info.psite}" name="num" required
							lay-verify="required" placeholder="请输入地址" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">联系电话</label>
					<div class="layui-input-block">
						<input type="text" value="${info.sphone}" name="num" required
							lay-verify="required" placeholder="请输入联系电话" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">编辑资料</button>
					</div>
				</div>

			</div>
		</c:forEach>
	</form>

	<script type="text/javascript" src="/airsys/assets/layui/layui.js"></script>
	<script>
		layui
				.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

							form.on('submit(demo1)', function(data) {
								layer.alert(JSON.stringify(data.field), {
									title : '最终的提交信息'
								})
								return false;
							});

						});
	</script>
</body>
</html>
