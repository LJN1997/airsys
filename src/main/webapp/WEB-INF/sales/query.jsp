<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.*,util.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="/airsys/assets/js/cityselect.js"></script>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<link rel="stylesheet" href="/airsys/assets/css/cityselect.css">
<title>查票</title>
<style>
body {
	margin: 0;
	padding: 0;
}

.box {
	width: 600px;
	height: 330px;
	border: 2px solid rgb(144, 144, 144, 0.8);
	margin-left: 50px;
	margin-top: 30px;
}

h2 {
	margin-top: 10px;
	margin-left: 20px;
	font-size: 30px;
}

.radio {
	margin-top: 20px;
	margin-left: 22px;
}

label {
	margin-left: 10px;
}

.inputInfo {
	width: 250px;
	height: 30px;
	margin-left: 20px;
	margin-top: 30px;
	float: left;
}

.inputInfo input {
	width: 160px;
	height: 30px;
}

.select {
	width: 400px;
	height: 35px;
	margin-left: 90px;
	margin-top: 40px;
	font-size: 20px;
	letter-spacing: 15px;
}

</style>
</head>
<body>
  <form action="/airsys/sales/queryCon">
	<div class="box">
		<h2>机票查询</h2>
		<div class="radio">
			航程类型： 
			<label><input name="type" class="one" type="radio" value="one" checked/>单程</label> 
			<label><input name="type" class="two" type="radio" value="two" />往返</label>
		</div>

		<div class="inputInfo">
			出&nbsp;&nbsp;发&nbsp;&nbsp;地：<input type="text" name="from"  autocomplete="off" class="cityinput"  required id="start" placeholder="请输入出发地">
		</div>
		<div class="inputInfo">
			目&nbsp;&nbsp;的&nbsp;&nbsp;地：<input type="text" name="to"  autocomplete="off" required class="cityinput" id="end" placeholder="请输入目的地">
		</div>
		<div class="inputInfo">
			出发时间：<input type="date" class ="startTime" name="starttime" required placeholder="请输入出发时间">
		</div>
		<div class="inputInfo">
			到达时间：<input class ="arriveTime"  disabled="true" type="date" required placeholder="请输入到达时间">
		</div>

		<button class="select">立即查询</button>

	</div>
	</form>
	<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		var test = new Vcity.CitySelector({
			input : 'start'
		});
		var test = new Vcity.CitySelector({
			input : 'end'
		});
		
		$(".one").click(function(){
			$(".arriveTime").attr("disabled",true)
		})	
		
		$(".two").click(function(){
			$(".arriveTime").attr("disabled",false)
		})		
				
	</script>
</body>

</html>