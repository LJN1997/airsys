<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>机票购买</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<!-- <link rel="stylesheet" href="/airsys/assets/css/sales.css"> -->
<style type="text/css">
body, h2 {
	margin: 0;
	padding: 0;
	position: relative;
}

.buyPage {
	width: 100%;
	height: 100%;
}

.one {
	font-size: 25px;
	margin-left: 20px;
	margin-top: 10px;
}

.buyPage-left {
	width: 400px;
	height: 480px;
	border: 4px solid blue;
	margin-left: 50px;
	float: left;
}

.buyPage-right {
	width: 500px;
	height: 480px;
	border: 4px solid grey;
	margin-left: 550px;
	margin-top: 10px;
}

.manInfo {
	width: 400px;
	height: 300px;
	border: 1px solid red;
}

.ratio {
margin-top:20px;
	float: left;
}

.info {
margin-top:20px;
	float: left;
}

.addMan button {
    width:250px;
	margin-left:10px;
	margin-top:50px;
}

.addInfo{
   width:22px;
   height:22px;
   border:1px solid grey;
   float:left;
   margin-left:-250px;
   margin-top:65px;
   cursor:pointer;
}
.addInfo a:hover{
   color: red;
}
</style>
</head>

<body>
	<form class="layui-form" action="http://localhost:8080/airsys/sales/buy" method="post">

		<input Type="hidden" name="sid" value=<%=session.getAttribute("sid")%>>
		<input Type="hidden" name="planId" value=${planId }>
		<div class="buyPage">
			<div class="buyPage-left">
				<div class="one">机票信息</div>


				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<div class="layui-form-item">

							<label class="layui-form-label">航班号</label>
							<div class="layui-input-block">
								<input type="text" name="fnumber" required lay-verify="required"
									readonly unselectable="on" value=${fnumber } autocomplete="off"
									class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">出发城市</label>
							<div class="layui-input-block">
								<input type="text" name="from" required lay-verify="required"
									readonly unselectable="on" value=${from } autocomplete="off"
									class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">到达城市</label>
							<div class="layui-input-block">
								<input type="text" name="to" required lay-verify="required"
									readonly unselectable="on" value=${to } autocomplete="off"
									class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">起飞时间</label>
							<div class="layui-input-block">
								<input value=${time } readonly unselectable="on" type="text"
									name="starttime" required lay-verify="required"
									value="2019-11-05 19:20:02" autocomplete="off"
									class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">到达时间</label>
							<div class="layui-input-block">
								<input value=${time2 } readonly unselectable="on" type="text"
									name="endtime" required lay-verify="required"
									value="2019-11-05 00:12:18" autocomplete="off"
									class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</label>
							<div class="layui-input-block">
								<input type="text" readonly unselectable="on" name="price"
									required lay-verify="required" value=${price }
									autocomplete="off" class="layui-input">
							</div>

						</div>

					</div>
				</div>
			</div>

			<div class="buyPage-right">
				<div class="one">乘客信息</div>
				<div class="ratio">
					<label class="layui-form-label">乘客类型</label>
					<div class="layui-input-block">
						<input type="radio" id="man" name="people" value="成人" title="成人"
							checked> <input type="radio" id="child" name="people"
							value="儿童" title="儿童">
					</div>
				</div>
				<div class="ratio">
					<label class="layui-form-label">座位等级</label>
					<div class="layui-input-block">
						<input type="radio" id="grade1" name="grade"
							value="first_class_remain_seats" title="头等舱"> <input
							type="radio" id="grade2" name="grade"
							value="business_class_remain_seats" title="商务舱"> <input
							type="radio" id="grade3" name="grade"
							value="economy_class_remain_seats" title="经济舱" checked>
					</div>
				</div>

				<div class="info">
					<label class="layui-form-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
					<div class="layui-input-block">
						<input type="text" name="name" placeholder="请输入乘客姓名" required lay-verify="required"
							autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="info">
					<label class="layui-form-label">证件号码</label>
					<div class="layui-input-block">
						<input type="text" placeholder="请输入乘客证件号码" name="idcard" required
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="info">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-block">
						<input type="text" placeholder="请输入乘客联系方式" name="phone" required
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="addInfo">
				<a href="#"><i class="layui-icon layui-icon-add-1" style="font-size: 20px; color: #1E9FFF;"></i>  </a>
				</div>
                

				<div class="addMan">
					<button class="layui-btn" lay-submit lay-filter="formDemo">下一步</button>
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