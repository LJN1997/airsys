<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Air China</title>
</head>
<link rel="stylesheet" href="/airsys/assets/css/head.css">
<link rel="stylesheet" href="/airsys/assets/css/background.css">
<link rel="stylesheet" href="/airsys/assets/css/bottom.css">
<link rel="stylesheet" href="/airsys/assets/css/flightInfo.css">
<link rel="stylesheet" href="/airsys/assets/css/flightBuff.css">
<link rel="stylesheet" href="/airsys/assets/css/manageBook.css">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<script src="/airsys/assets/js/index.js"></script>
<body>
	<div class="head">
		<div class="head-top"></div>
		<div class="head-bottom">
			<div class="head-img">
				<img
					src="https://turkishairlines.ssl.cdn.sdlmedia.com/636807091249123590KU.png"
					alt="">
			</div>
			<div class="head-right-box">
				<div class="head-right-4">
					<a href="">登陆</a>
				</div>
				<div class="head-right-3">
					<a href="">注册</a>
				</div>
				<div class="head-right-2">
					<a href="">发现</a>
				</div>

				<div class="head-right-1">
					<a href="">与众不同的飞行体验</a>
				</div>
				<div class="head-right-5">
					<a href="">计划和预定</a>
				</div>
			</div>
		</div>
	</div>
	<div class="background">
		<div class="background-center-box">
			<br> <br>
			<div class="back-text-box-1">您好</div>
			<div class="back-text-box-1">您想要探索哪里?</div>
			<br>
			<div class="back-input-box">
				<div class="back-input buff1">
					<b>预订航班</b>
				</div>
				<div class="back-input buff2">
					<b>管理预订</b>
				</div>
				<div class="back-input buff3">
					<b>航班状态</b>
				</div>
			</div>
			<br>
			<!--预订航班-->
			<div class="back-test-box buff1-box">
				<div class="back-text-top">
					<div class="back-text-top-input ii">

						<label><input type="radio" value="1" name="aa"
							class="abcd">往返</label>
					</div>
					<div class="back-text-top-input ij" style="border: 1px solid red;">
						<label><input type="radio" value="1" name="aa"
							class="abcd" checked>单程</label>
					</div>
				</div>
				<div class="back-text-center">
					<form action="airsys/users" method="get">
						<div class="start">
							<div class="start-lcon-box">
								<div class="start-lcon">
									<img src="/airsys/assets/img/start.png" alt="">
								</div>
							</div>

							<input type="text" name="fromCity" placeholder="起点">
						</div>

						<div class="start">
							<div class="start-lcon-box">
								<div class="start-lcon">
									<img src="/airsys/assets/img/end.png" alt="">
								</div>
							</div>
							<input type="text" name="toCity" placeholder="终点">
						</div>

						<div class="date">
							<div class="date-date">
								<b>&nbsp;&nbsp;日期</b> <input type="date" name="start">
							</div>
						</div>

						<div class="class">
							<div class="class-text">
								<label><input type="radio" checked value="1" name="aa"
									class="abcd">经济舱</label> <label><input type="radio"
									value="1" name="aa" class="abcd">商务舱</label> <label><input
									type="radio" value="1" name="aa" class="abcd">头等舱</label>
							</div>
							<div class="count">
								<label><input type="radio" checked value="1" name="aa"
									class="abcd">成人</label> <label><input type="radio"
									value="1" name="aa" class="abcd">儿童</label> <label><input
									type="radio" value="1" name="aa" class="abcd">婴儿</label>
							</div>
						</div>
						<!-- <a href="aaa.jsp"> -->
						<button type="submit" class="enter">
							<div class="jiantou"></div>
						</button>
						<!-- </a> -->
					</form>

				</div>
			</div>
			<!--管理预订-->
			<div class="back-test-box2 buff2-box">
				<div class="top">
					<table>
						<tr>
							<td><h5>TK1890</h5></td>
							<td class="t2">
								<div>
									<div class="con-three-bot-left">
										<p>09：06</p>
										<p>杜布罗夫尼克（DBV）</p>
									</div>
									<div class="con-three-bot-mid">
										<span class="p1">1时44分</span> <span class="p2">——</span>

									</div>
									<div class="con-three-bot-right">
										<p>12：50</p>
										<p>伊斯坦布尔（IST）</p>
									</div>
								</div>
							</td>
							<td style="width: 70px;"><a href="">航班状态</a></td>
						</tr>
					</table>
				</div>
			</div>
			<!--航班状态-->
			<div class="back-test-box3 buff3-box">
				<form action="airsys/userbuff" method="get">
					<br> <br>
					<div class="class-id">
						<b style="color:#99a5b4; font-size:20px;">航班号</b>
					</div>
					<div class="start" style="width: 500px;">
						<div class="start-lcon-box">
							<div class="start-lcon">
								<img src="/airsys/assets/img/start.png" alt="">
							</div>
						</div>
						<input type="text" placeholder="请输入航班号" name="fnumber" style="width: 350px;">
					</div>
					<div class="class-id">
						<e style="color: #99a5b4; font-size: 20px;margin-top:10px;">日期：</e>
						<br> <br> <input type="date" name="startDate" style="background: rgba(0, 0, 0, 0); color: #99a5b4;">
					</div>
					<button type="submit" class="enter">
							<div class="jiantou"></div>
						</button>
				</form>
			</div>
		</div>
	</div>
	<div class="bottom">
		<div class="bottom-size">
			<div class="bottom-a">
				<a href="#">无障碍服务</a>&nbsp;|&nbsp;<a href="#">隐私和Cookie政策</a>&nbsp;|&nbsp;<a
					href="#">法律公告</a>&nbsp;|&nbsp;<a href="#">乘客权限</a>&nbsp;|&nbsp;<a
					href="#">EU Data Subjects Rights</a> |&nbsp;Air航空公司版权所有 @1996-2019
			</div>
		</div>


	</div>
</body>
</html>