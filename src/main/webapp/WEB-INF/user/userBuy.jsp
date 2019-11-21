<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<meta charset="utf-8">
<head>
</head>
<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css" />
<link rel="stylesheet" href="/airsys/assets/css/buy.css" />
<link rel="stylesheet" href="/airsys/assets/css/bookingflight.css">
<link rel="stylesheet" href="/airsys/assets/css/flightInfo.css">
<script src="/airsys/assets/js/jquery.js"></script>
<style>
body {
	background: url("/airsys/assets/img/timg.jpg") no-repeat center;
	background-size: 100%;
}

.box {
	width: 80%;
	height: 500px;
	margin: auto;
	background: rgba(255, 255, 255, .3);
	border-radius: 20px;
	overflow: auto;
}
</style>
<body>
	<%

/*  out.println(session.getAttribute("uid"));   */
%>

	<div class="head">填写订单</div>
	<div class="box">
		<div class="info">
			<table>
				<tr>
					<td><h5 style="width: 130px; margin: 0 50px 0 200px;"
							class="type">${type}</h5></td>
					<td class="t2">
						<div>
							<div class="con-three-bot-left">
								<p class="expStartTime">${expStartTime}</p>
								<p class="fromCity">${fromCity}</p>
							</div>
							<div class="con-three-bot-mid">
								<span class="p1"><b class="temp">${temp}</b>分</span> <span
									class="p2">——</span>

							</div>
							<div class="con-three-bot-right" style="margin-left: 30px;">
								<p class="expEndTime">${expEndTime}</p>
								<br>
								<p class="toCity">${toCity}</p>
							</div>
							<div class="con-three-bot-right" style="margin: 20px 50px;">
								<p>
									折扣:<b class="season_discount">${season_discount}</b>折
								</p>
								<p class="tprice">价格:${tprice}</p>
							</div>
							<div class="con-three-bot-right" style="margin: 0 30px;">
								<p>
									<br>
								</p>
								头等舱：
								<p class="firstClassRemainSeats">${firstClassRemainSeats}</p>
							</div>
							<div class="con-three-bot-right" style="margin: 0 30px;">
								<p>
									<br>
								</p>
								商务舱：
								<p class="businessClassRemainSeats">${businessClassRemainSeats}</p>
							</div>
							<div class="con-three-bot-right" style="margin: 0 30px;">
								<p>
									<br>
								</p>
								经济舱：
								<p class="economyClassRemainSeats">${economyClassRemainSeats}</p>
							</div>
						</div>
					</td>


				</tr>
			</table>
		</div>
		<form action="/airsys/user/userbuy" methon="post">
			<div class="passenger-box">
				<div class="p-message-left">
					<b>姓名</b> <input type="text" class="form-control"
						id="exampleInputEmail1" placeholder="姓名，请与登机证件姓名保持一致" name="oname">

					<div class="shen">
						<b>身份证号</b>
					</div>
					<div class="p-num">

						<input type="text" class="form-control" id="exampleInputEmail"
							placeholder="登机证件号码" sytle="width:80px" name="idcard">
					</div>
						<input type="hidden" value="${fid}" name = "fid">
					<div class="shen">
						<b>中国区号86</b>
					</div>
					<div class="p-num">
						<input type="text" class="form-control" id="exampleInputEmai"
							placeholder="乘机人手机号码" sytle="width:80px" name="ophone">
					</div>
					
					<div class="cang">
					头等舱：
						<input type="radio" name="seats" value="1">
						商务舱：
						<input type="radio" name="seats"  value="2">
						经济舱：
						<input type="radio" name="seats" checked  value="3">
					</div>
					
				</div>

			</div>

			<button type="button" class="btn btn-primary"
				style="margin-left: 10%;">+ 添加乘客</button>
			<button type="submit" class="submit" style="margin-left:130px;">微信支付</button>
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			$('.btn')
					.click(
							function() {
								$('.box')
										.append(
												'  <div class="passenger-box passenger-box-add">\n'
														+ '                <div class="p-message-left">\n'
														+ '                    <b>姓名</b><input type="email" class="form-control" id="exampleInputEmail1" placeholder="姓名，请于登机证件姓名保持一致" >\n'
														+ '\n'
														+ '                    <div class="shen">\n'
														+ '                        <b>身份证号</b>\n'
														+ '                    </div>\n'
														+ '                    <div class="p-num">\n'
														+ '\n'
														+ '                        <input type="email" class="form-control" id="exampleInputEmail" placeholder="登机证件号码" sytle="width:80px">\n'
														+

														'                    <div class="shen">\n'
														+ '                        <b>中国区号86</b>\n'
														+ '                    </div>\n'
														+ '                    <div class="p-num">\n'
														+ '                        <input type="email" class="form-control" id="exampleInputEmai" placeholder="乘机人手机号码(选填)"sytle="width:80px">\n'
														+ '                    </div>\n'
														+ '                    <div class="checkbox">\n'
														+

														'                    </div>\n'
														+ '                </div>\n'
														+ '                    <div class="delet delet-add">\n'
														+ '                        <button type="button">X</button>\n'
														+ '                    </div>\n'
														+ '<!--                    <img src=https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=359791056,3191805917&fm=15&gp=0.jpg alt="" width="330px" height="207px">-->\n'
														+ '                </div>\n'
														+ '            </div>')
								$('.delet-add').click(function() {
									// alert(1)
									$(this).parent().parent().remove().empty()
									// ($('.delet-add').parent().parent().remove().empty();
								});
							});
		})
	</script>

</body>
</html>