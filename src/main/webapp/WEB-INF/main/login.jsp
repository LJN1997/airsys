<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<link rel="stylesheet" href="/airsys/assets/css/main.css">

</head>
<body>
	<form class="layui-form" action="/airsys/login/log" method="post">
		<div class="container">
			<h2>登录</h2>
			<!--<div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="06.png" height="35">
        </div>-->
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input type="text" name="name" required lay-verify="required"
						placeholder="请输入用户名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密 &nbsp;&nbsp;码</label>
				<div class="layui-input-inline">
					<input type="password" name="password" required
						lay-verify="required" placeholder="请输入密码" autocomplete="off"
						class="layui-input">
				</div>
				<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">验证码</label>
				<div class="layui-input-inline">
					<input type="text" name="title" required lay-verify="required"
						placeholder="请输入验证码" autocomplete="off" class="layui-input verity">
				</div>
			</div>
			<!-- 			  <div class="layui-form-item">
                            <label class="layui-form-label">记住密码</label>
                            <div class="layui-input-block">
                              <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                            </div>
                      </div> -->
			<div class="layui-form-item">
				<label class="layui-form-label">用户选择</label>
				<div class="layui-input-block">
					<input type="radio" name="role" value="1" title="管理员" checked="">
					<input type="radio" name="role" value="2" title="营业员"> <input
						type="radio" name="role" value="3" title="营业员管理员">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
				</div>
			</div>
			<a href="http://localhost:8080/airsys/main/pwd" class="font-set">忘记密码?</a>
			<a href="http://localhost:8080/airsys/main/resign" class="font-set">立即注册</a>
		</div>
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
