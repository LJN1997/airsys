<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<meta charset="utf-8">
<head>
</head>
<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css" />
<link rel="stylesheet" href="/airsys/assets/css/bookingflight.css">
<link rel="stylesheet" href="/airsys/assets/css/flightInfo.css">
<style>
body {
	background: url("/airsys/assets/img/timg.jpg") no-repeat center;
	background-size: 100%;
}

.box {
	width: 1000px;
	height: 500px;
	margin: auto;
	margin-top: 10%;
	background: rgba(0, 0, 0, .5);
	border-radius: 20px;
	position: relative;
}
</style>
<body>
	<div class="container">
		<div class="box">
			<div class="info"
				style="height: 100px; background: rgba(0, 0, 0, 0.2)">

				<div class="top">
					<form action="/airsys/user/buy" methon="get">
						<table>
							<tr>
								<td><h5 style="width: 90px;">${type}</h5></td>
								<td class="t2">
									<div>
										<div class="con-three-bot-left">
											<p>
												<fmt:formatDate value="${expStartTime}" type="time"
													timeStyle="medium" />
											</p>
											<p>${fromCity}</p>
										</div>
										<div class="con-three-bot-mid">
											<span class="p1">${temp}分</span> <span class="p2">——</span>

										</div>
										<div class="con-three-bot-right" style="margin-left: 100px;">
											<p>
												<fmt:formatDate value="${expEndTime}" type="time"
													timeStyle="medium" />
											</p>
											<p>${toCity}</p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 100px;">
											<p>折扣:${season_discount}折</p>
											<p>价格:${tprice}</p>
										</div>
									</div>
								</td>
								<td style="width: 80px;"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>