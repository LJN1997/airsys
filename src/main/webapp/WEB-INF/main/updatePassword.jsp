<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>修改密码</title>
</head>

<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<body>
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

	<form class="layui-form" action="/airsys/admin/updatepwd" method="post">
		<div class="container">
			<button class="close" title="关闭" onclick=back()>X</button>
			<!--<div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="06.png" height="35">
        </div>-->
			<input type="hidden" value="${admin.aid}" name="aid">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input type="text" name="pwd" required lay-verify="required"
						value="${admin.aname}" autocomplete="off" class="layui-input">
				</div>
			</div>
			</p>
			<div class="layui-form-item">
				<label class="layui-form-label">新密码</label>
				<div class="layui-input-inline">
					<input type="password" name="pwd1" lay-verify="pass"
						placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
				<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码</label>
				<div class="layui-input-inline">
					<input type="password" name="pwd2" lay-verify="pass"
						placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
				<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">重置</button>
				</div>
			</div>
		</div>
	</form>
	<script src="/airsys/assets/layui/layui.js"></script>
	<script src="/airsys/assets/js/pwd.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="//g.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script>
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
						})
	</script>
</body>
</html>