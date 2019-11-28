<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="entity.UserInfo"%>
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
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/airsys/assets/js/index.js"></script>
<script src="/airsys/assets/js/manageBook.js"></script>

<body>

	<%-- ${sessionScope.uid}
${usts} --%>

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
					<a href="/airsys/user/login" class="go">登陆</a>
				</div>
				<div class="head-right-3">
					<a href="/airsys/user/reg">注册</a>
				</div>
				<div class="head-right-2">
					<!-- /airsys/user/airsys -->
					<a href="/airsys/user/session" class="exit">退出</a>
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
			<input type = "hidden" class="Catch" value="${Catch }">
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
							<input type="text" name="toCity" placeholder="终点"> <input
								type="hidden" value="${sessionScope.uid}" class="uid"> <input
								type="hidden" value="${usts}" class="usts">
						</div>

						<div class="date">
							<div class="date-date">
								<b>&nbsp;&nbsp;日期</b> <input type="date" name="start">
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

				<%-- <c:if test=""> --%>
				<div class="topp">
					<c:forEach items="${usts}" var="list">
						<!-- 航班 -->
						<div class="top tr-bottom">
							<form action="/airsys/user/outticket" method="get">
								<table style="color: white;">
									<tr>
										<td><h5>${list.fnumber}</h5></td>
										<td class="t2">
											<div>
												<div class="con-three-bot-left">
													<p><fmt:formatDate value="${list.departureTime}" type="both"/></p>
													<p>${list.fromCity}</p>
												</div>
												<div class="con-three-bot-mid">
													<span class="p1">${list.temp }</span>分 <span class="p2">——</span>

												</div>
												<div class="con-three-bot-right">
													<p><fmt:formatDate value="${list.arrivalTime}" type="both"/></p>
													<p>${list.toCity}</p>
												</div>
												<div class="con-three-bot-right"style="margin-left:50px;">
													<p>${list.tclass}</p>
												</div>
												<div class="con-three-bot-right"style="margin-left:50px;">
													姓名:<p>${list.oname}</p>
												</div>
			
												<input type="hidden" value="${list.tid}" name="tid">
												<input type="hidden" value="${list.fid}" name="fid">
												<input type="hidden" value="${list.tclass}" name="tclass">
												<input type="hidden" value="${list.oname}" name="oname">
												<input type="hidden" value="${list.idcard}" name="idcard">
											</div>
										</td>
										<td style="width: 70px;"><button type="submit">退票</button></td>
										<td style="width: 70px;"><button type="button" onclick="window.location.href = '/airsys/user/update/user?fnumber=${list.fnumber}&&startDate=${list.startDate }&&tid=${list.tid}&&tclass=${list.tclass}&&oname=${list.oname}&&idcard=${list.idcard}'">改签</button></td>

									</tr>
								</table>
							</form>
						</div>
					</c:forEach>
				</div>
				<%-- </c:if> --%>

				<%-- <c:if test="${empty list} "> --%>
				<div class="loginbox1">
					<b>暂无订单！</b>
				</div>
				<%-- </c:if> --%>
				<!-- 登陆 -->
				<%-- <c:if test="1==1"> --%>
				<div class="loginbox2">
					<b>您还没有登陆，请<a href="/airsys/user/login">登陆！</a></b>
				</div>
				<%-- </c:if> --%>

			</div>
			<!--航班状态-->
			<div class="back-test-box3 buff3-box">
				<form action="airsys/userbuff" method="get">
					<br> <br>
					<div class="class-id">
						<b style="color: #99a5b4; font-size: 20px;">航班号</b>
					</div>
					<div class="start" style="width: 500px;">
						<div class="start-lcon-box">
							<div class="start-lcon">
								<img src="/airsys/assets/img/start.png" alt="">
							</div>
						</div>
						<input type="text" placeholder="请输入航班号" name="fnumber"
							style="width: 350px;">
					</div>
					<div class="class-id">
						<e style="color: #99a5b4; font-size: 20px;margin-top:10px;">日期：</e>
						<br> <br> <input type="date" name="startDate"
							style="background: rgba(0, 0, 0, 0); color: #99a5b4;">
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