<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<meta charset="utf-8">
<head>
</head>
<link rel="stylesheet"  href="../css/bootstrap.css"/>
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
	height:300px;
	margin:auto;
	margin-top:200px;
	background:rgba(0,0,0,.5);
	border-radius:20px;
	position: relative;
}


</style>
<body>
<div class="container">
	<div class="box">
	<form  action="sigCon.jsp" mothed="post">
	<h3>登录</h3>
	  <div class="form-group"> 
	    <label for="exampleInputEmail1">账号</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="账号" name = "uphone">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">密码</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码" name = "upwd">
	  </div>

	  <button type="submit" class="btn btn-default">提交</button>
	  <div>
	没有账号？点击
	<a href = "reg.jsp">这里</a>
	
	</div>
	</form>
	</div>
</div>

</body>
</html>