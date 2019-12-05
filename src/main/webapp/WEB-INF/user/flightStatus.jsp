<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="entity.UserSelectAll"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>航班状态</title>
<link rel="stylesheet" href="/airsys/assets/css/flight-status.css">
</head>
<script src="/airsys/assets/js/flightbuff.js"></script>

<body>
	<c:forEach items="${usts}" var="list">

		<fmt:parseDate var="dateObj" value="${list.startDate}" type="DATE"
			pattern="yyyy-MM-dd" />
		<fmt:formatDate var="reTime" value='${dateObj}' pattern='yyyy-MM-dd' />


		<fmt:parseDate var="dateObj2" value="${list.endDate}" type="DATE"
			pattern="yyyy-MM-dd" />
		<fmt:formatDate var="reTime2" value='${dateObj2}' pattern='yyyy-MM-dd' />
		<fmt:formatDate value="${now}" type="time" timeStyle="medium"
			var="now" />

		<%-- <fmt:formatDate value="${list.endDate}" type="date" dateStyle="full"/>

<fmt:formatDate value="${list.departureTime}" type="time" timeStyle="medium"/>
<fmt:formatDate value="${list.arrivalTime}" type="time" timeStyle="medium"/>
${list.fid}
${list.discount}
${list.firstClassRemainSeats}
${list.businessClassRemainSeats}
${list.economyClassRemainSeats}

${reTime}
${reTime2}
${list.fromCity}
${list.toCity}
${list.departureTime}
${list.arrivalTime}
${list.sailLength}
${list.tprice} --%>
<link rel="stylesheet" href="/airsys/assets/css/updateFlight.css">


		<div class="con">
			<div class="con-one">
				<div class="con-one-left">
					<form action="/airsys/user/sigcon" method="get">
				<input type="hidden" value="1" name="status">
				<button type="submit" class="button-return">返回主页</button>
			</form>
				</div>

			</div>
			<hr>
			<div class="con-two">
				<div class="con-two-left">
					<div>航班号和航线</div>
					<div>${list.fnumber}|${reTime}至<fmt:formatDate
							value="${list.endDate}" type="date" dateStyle="full" />
					</div>
				</div>
				<div class="con-two-right">
					<div>航班状态</div>
					<div><p class="js2">${list.str}</p></div>
				</div>
			</div>
			<div class="con-three">
				<div class="con-three-top">
					<p>
						计划时间：
						<fmt:formatDate value="${list.expStartTime}" type="time"
							timeStyle="medium" />
					</p>
					<p>——</p>
					<p>
						计划时间：
						<fmt:formatDate value="${list.expEndTime}" type="time"
							timeStyle="medium" />
					</p>
				</div>
				<div class="con-three-bot">
					<div class="con-three-bot-left">
						<p class="js1">
							实际：
							<fmt:formatDate value="${list.departureTime}" type="time"
								timeStyle="medium" />
						</p>
						<p>${list.fromCity}</p>
					</div>
					<div class="con-three-bot-mid">
						<p>——</p>
						<p>${list.temp}分钟</p>
					</div>
					<div class="con-three-bot-right">
						<p>
							实际：
							<fmt:formatDate value="${list.arrivalTime}" type="time"
								timeStyle="medium" />
						</p>
						<p>${list.toCity}</p>
					</div>
				</div>
			</div>
			<div class="con-four">
				<div class="con-four-1">
					<div class="con-four-1-top">
						<span>航班</span>
					</div>
					<div class="con-four-1-bot">
						<h3>${list.fnumber}</h3>
						<p>营运：Turkish Airlines</p>
						<p>
							<span>${list.type}</span>
						</p>
					</div>
				</div>
				<div class="con-four-1">
					<div class="con-four-1-top">
						<span>起飞</span>
					</div>
					<div class="con-four-1-bot">
						<div class="cfb1">
							<div>
								<fmt:formatDate value="${list.departureTime}" type="time"
									timeStyle="medium" />
							</div>
							<div>
								计划:
								<fmt:formatDate value="${list.expStartTime}" type="time"
									timeStyle="medium" />
							</div>
						</div>
						<div class="cfb2">
							<div>${list.fromCity}</div>
							<div>${list.fromCity}（${list.fromCity}）</div>

						</div>
					</div>
				</div>
				<div class="con-four-1">
					<div class="con-four-1-top">
						<span>抵达</span>
					</div>
					<div class="con-four-1-bot">
						<div class="cfb1">
							<div>
								<fmt:formatDate value="${list.arrivalTime}" type="time"
									timeStyle="medium" />
							</div>
							<div>
								计划:
								<fmt:formatDate value="${list.expEndTime}" type="time"
									timeStyle="medium" />
							</div>
						</div>
						<div class="cfb2">
							<div>${list.toCity}</div>
							<div>${list.toCity}(${list.toCity})</div>
						</div>
					</div>
				</div>
				<div class="con-four-1">
					<div class="con-four-1-top">
						<span>时长</span>
					</div>
					<div class="con-four-bot">
						<p>${list.temp}分钟</p>
						<p>距离</p>
						<p>${list.sailLength}千米</p>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>

	<div class="bottom"></div>
</body>
</html>