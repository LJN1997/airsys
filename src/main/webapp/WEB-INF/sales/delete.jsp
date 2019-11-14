<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>退票</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<link rel="stylesheet" href="/airsys/assets/css/sales.css">
</head>

<body>
	<form class="layui-form" action="/airsys/sales/buy" >
		<div class="buyPage">
			<div class="one">退票</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
				
					<div class="layui-form-item">
						
						<label class="layui-form-label">航班号</label>
						<div class="layui-input-block">
							<input type="text" name="fnumber" required lay-verify="required"
								readonly unselectable="on"
								 value=${fnumber } autocomplete="off" class="layui-input">
						</div>
						
						<label class="layui-form-label">出发城市</label>
						<div class="layui-input-block">
							<input type="text" name="from" required lay-verify="required"
								readonly unselectable="on" value=${from } autocomplete="off" class="layui-input">
						</div>

						<label class="layui-form-label">到达城市</label>
						<div class="layui-input-block">
							<input type="text" name="to" required lay-verify="required"
								readonly unselectable="on" value=${to } autocomplete="off" class="layui-input">
						</div>

						<label class="layui-form-label">出港时间</label>
						<div class="layui-input-block">
							<input value=${time } readonly unselectable="on" type="text" name="starttime" required
								lay-verify="required" value="2019-11-05 19:20:02"
								autocomplete="off" class="layui-input">
						</div>

						<label class="layui-form-label">到港时间</label>
						<div class="layui-input-block">
							<input value=${time2 } readonly unselectable="on" type="text" name="endtime" required
								lay-verify="required" value="2019-11-05 00:12:18"
								autocomplete="off" class="layui-input">
						</div>

						<label class="layui-form-label">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</label>
						<div class="layui-input-block">
							<input type="text" readonly unselectable="on" name="price" required lay-verify="required"
								value=${price } autocomplete="off" class="layui-input">
						</div>

					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">支付方式</label>
						<div class="layui-input-block">
							<select name="city" lay-verify="required">
								<option value="0">微信</option>
								<option value="1">支付宝</option>
								<option value="2">现金</option>
								<option value="3">其他</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">立即购买</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<script src="/airsys/assets/layui/layui.js"></script>
	<script>
		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function() {
			var element = layui.element;

			//…
		});

		//Demo
		layui.use('form', function() {
			var form = layui.form;

		});
	</script>
</body>
</html>