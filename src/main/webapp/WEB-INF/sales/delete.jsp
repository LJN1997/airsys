<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% response.setContentType("text/html;charset=utf-8"); %>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>退票</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<link rel="stylesheet" href="/airsys/assets/css/sales.css">
<style type="text/css">
body {
	margin: 0;
	padding: 0
}

.del {
	width: 400px;
	height: 300px;
	border: 2px solid rgb(144, 144, 144, 0.8);
	margin-left: 50px;
	margin-top: 30px;
}

.select {
	font-size: 25px;
	margin-left: 20px;
	margin-top: 10px;
	margin-bottom: 30px;
}

.del-con {
	width: 850px;
	height: 180px;
	margin-top: 10px;
	margin-left: 50px;
	margin-top: 10px;
}
</style>
</head>

<body>
	<form class="layui-form" action="">
		<div class="del">
			<div class="select">退票信息查询</div>
			<div class="layui-form-item">
				<label class="layui-form-label">订单编号</label>
				<div class="layui-input-block">
					<input type="text" class="oid" name="oid" required
						lay-verify="required" placeholder="请输入订单编号" autocomplete="off"
						class="layui-input">
				</div>

			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-block">
					<input type="text" class="oname" name="oname" required
						lay-verify="required" placeholder="请输入用户姓名" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证号</label>
				<div class="layui-input-block">
					<input type="text" class="idcard" name="idcard" required
						lay-verify="required" placeholder="请输入用户身份证号" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn selectOid" lay-submit
						lay-filter="formDemo">查询</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</div>
		<div class="del-con">
			<h2>查询信息</h2>
			<center>
				<table class="layui-table">
					<tr>
						<th>订单号</th>
						<th>乘客姓名</th>
						<th>出票日期</th>
						<th>座位等级</th>
						<th>乘客类型</th>
						<th>机票价格</th>
						<th>机票状态</th>
						<th>操作</th>
					</tr>
            
				</table>

			</center>

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
<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
<script>
	window.onload=function(){
		$(".selectOid").click(function(){
			var oid=$(".oid").val()
			var oname=$(".oname").val()
			var idcard=$(".idcard").val()
			$.ajax({
				url:"selectOid",
				data:{
					oid:oid,
					oname:oname,
					idcard:idcard,
				},
				success:function(e){
					console.log(e)
				}
			})
		})
		}
	
	
	</script>




</html>