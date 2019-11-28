<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<meta charset="utf-8">
<head>
</head>
<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css" />
<script type="text/javascript" src="/airsys/assets/js/jquery-1.7.2.js"></script>
<style>
body {
	background: url("/airsys/assets/img/timg.jpg") no-repeat center;
	background-size: 100%;
}

form {
	width: 400px;
	height: 350px;
	position: absolute;
	color: #cccccc;
	left: 50px;
	top: 0;
	right: 0;
	bottom: 0;
}

.box {
	width: 500px;
	height: 350px;
	margin: auto;
	margin-top: 200px;
	background: rgba(0, 0, 0, .5);
	border-radius: 20px;
	position: relative;
}
</style>
<body>
	<div class="container">
		<div class="box">
			<form action="/airsys/user/sigcon" method="post">
				<h3>登录</h3>
				<div class="form-group">
					<label for="exampleInputEmail1">账号</label> <input type="text"
						class="form-control uphone" id="exampleInputEmail1"
						placeholder="账号" name="uphone">

					<div class="form-group" style="margin-top: 20px;">
						<label for="exampleInputEmail1"></label> <input type="text"
							name="ljn" class="form-control " placeholder="请输入验证码"
							style="width: 150px; float: left; margin-right: 20px;"> <input
							type="button" class="btn btn-default dropdown-toggle but"
							value="获取验证码"> <input type="hidden" class="code"
							name="code" value="1213">

					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">密码</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="密码" name="upwd">
					</div>

					<button type="submit" class="btn btn-default">提交</button>
					<div>
						没有账号？点击 <a href="/airsys/user/reg">这里</a>

					</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		/* window.onload=function(){
		$(".but").on("click",function(){
			var uphone = $(".uphone").val()
			var code = $(".code").val()
			  $.ajax({ 
				  url:"http://api.feige.ee/SmsService/Template",
				  type:"post",
				  contentType:'application/x-www-form-urlencoded;charset=utf-8',
				  data:{
					  Account:17335081644,
					  Pwd:'ec02efa704c211b70809aaec4',
					  Content:code,
					  Mobile:uphone,
					  TemplateId:116876,
					  SignId:203342,
				  },
				  dataType:"json",
				  success:function(data){
					  console.log()
				}
			 });
		})
		
		} */
	</script>

</body>
</html>