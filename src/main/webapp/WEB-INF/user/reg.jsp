<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
body {
	background: url("/airsys/assets/img/timg.jpg") no-repeat center;
	background-size: 100%;
}

form {
	width: 400px;
	height: 300px;
	position: absolute;
	color: #cccccc;
	left: 50px;
	top: 0;
	right: 0;
	bottom: 0;
}

.box {
	width: 500px;
	height: 450px;
	margin: auto;
	margin-top: 200px;
	background: rgba(0, 0, 0, .5);
	border-radius: 20px;
	position: relative;
}
</style>
<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css" />
<script type="text/javascript" src="/airsys/assets/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/airsys/assets/js/jquery.validate.js"></script>
<html>
<meta charset="utf-8">
<html>
<head>
</head>
<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css" />
<body>
	<div class="container">
		<div class="box">
			<form action="/airsys/user/regcon" mothed="post" id="formcon" name="form">
				<h3>注册</h3>
				<div class="form-group">
					<label for="uname">账号：</label> <input type="text"
						class="form-control" id="uname" placeholder="Phone" name="uphone">
				</div>
				<div class="form-group">
					<label for="upwd">密码</label> <input type="password"
						class="form-control" id="upwd" placeholder="Password" name="upwd">
				</div>
				<div class="form-group">
					<label for="upwd2">确认密码</label> <input type="password"
						class="form-control" id="upwd2" placeholder="Password"
						name="upwd2">
				</div>
				<button type="submit" class="btn btn-default">提交</button>
				<div>
					已有账号，请点击 <a href="/airsys/user/login">这里</a>

				</div>
			</form>
		</div>
	</div>
</body>
<script>
	window.onload = function() {
		$("form").validate({
			rules : {
				uphone : {
					required : true,
					rangelength : [ 11, 11 ]
				},
				upwd : {
					required : true
				},
				upwd2 : {
					required : true
				}
			},
			messages : {
				uphone : {
					required : "请输入手机号",
					rangelength : "长度为11"
				},
				upwd : {
					required : "请输入密码"
				},
				upwd2 : {
					required : "请再次输入密码"
				}
			}
		});
	}
</script>
</html>