<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/jquery-1.7.2.js"></script>
<script src="../js/jquery.validate.js"></script>
<script>
	$().ready(function(){
		$("#formcon").validate({
			rules:{
				uname:{
					required:true,
					minlength:2,
					remote:"../ajax/selectName.jsp"
				},
				upwd:{
					required:true,
					minlength:3
				},
				upwd2:{
					required:true,
					minlength:3,
					equalTo:"#upwd"
				}
			},
			messages:{
				uname:{
					required:"请输入用户名",
					minlength:"用户名必须由两个字母组成",
					remote:"用户名已存在"
				},
				upwd:{
					required:"请输入密码",
					minlength:"密码长度不能小于3个字母",
				},
				upwd2:{
					required:"请输入密码",
					minlength:"密码长度不能小于3个字母",
					equalTo:"两次密码输入不一致"
				}
			}
		})
	});
</script>
<style>
body{
	background: url("../img/timg.jpg") no-repeat center;
	background-size:100%;
}
form{
	width:400px;
	height:300px;
	 position: absolute;
	color:#cccccc;
	left:50px;top:0;right:0;bottom:0;

}
.box{
	width:500px;
	height:380px;
	margin:auto;
	margin-top:200px;
	background:rgba(0,0,0,.5);
	border-radius:20px;
	position: relative;
}
</style>
<html>
<meta charset="utf-8">

<html>
<head>
</head>
<link rel="stylesheet"  href="../css/bootstrap.css"/>
<body>
<div class="container">
	<div class="box">
	<form action="regCon.jsp" mothed="post" id="formcon">
	<h3>注册</h3>
	  <div class="form-group">
	    <label for="uname">账号：</label>
	    <input type="text" class="form-control" id="uname" placeholder="Phone" name="uphone">
	  </div>
	  <div class="form-group">
	    <label for="upwd">密码</label>
	    <input type="password" class="form-control" id="upwd" placeholder="Password" name = "upwd">
	  </div>
	    <div class="form-group">
	    <label for="upwd2">确认密码</label>
	    <input type="password" class="form-control" id="upwd2" placeholder="Password" name="upwd2">
	  </div>
	  <button type="submit" class="btn btn-default">提交</button>
	  	<div>
已有账号，请点击
<a href = "signIn.jsp">这里</a>

</div>
	</form>
</div>
</div>


</body>
</html>