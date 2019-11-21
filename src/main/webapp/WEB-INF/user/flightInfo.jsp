<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="entity.UserSelectAll"%>
<html>
<link rel="stylesheet" href="/airsys/assets/css/bookingflight.css">
<link rel="stylesheet" href="/airsys/assets/css/flightInfo.css">
<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
<body>
<%

/*  out.println(session.getAttribute("uid"));  */
%>
<div class="box">
		<div class="title">航班信息</div>
		<div class="infobox">
			<c:forEach items="${usts}" var="list">

				<div class="info"
					style="height: 100px; background: rgba(0, 0, 0, 0.2)">

					<div class="top">

						<table>
							<tr>
								<td><h5 style="width: 90px;" class="type">${list.type}</h5></td>
								<td  style="width: 90px;">航班号：<h5 class="fid">${list.fid}</h5></td>
								<td class="t2">
									<div>
										<div class="con-three-bot-left">
											<p class="expStartTime">
												<fmt:formatDate  value="${list.expStartTime}" type="time"
													timeStyle="medium" />
											</p>
											<p class="fromCity">${list.fromCity}</p>
										</div>
										<div class="con-three-bot-mid">
											<span class="p1"><b class="temp">${list.temp}</b>分</span> <span class="p2">——</span>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p class="expEndTime">
												<fmt:formatDate value="${list.expEndTime}" type="time"
													timeStyle="medium" />
											</p>
											<p class="toCity">${list.toCity}</p>
										</div> 
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p>折扣:<b class="season_discount">${list.season_discount}</b>折</p>
											<p>价格:<b class="tprice">${list.tprice}</b></p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 40px;">
											
											<p>头等舱：<p class="firstClassRemainSeats">${list.firstClassRemainSeats}</p></p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p>
												
											</p>
											商务舱：<p class="businessClassRemainSeats">${list.businessClassRemainSeats}</p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p>
												
											</p>
											<p>经济舱：<p class="economyClassRemainSeats">${list.economyClassRemainSeats}</p></p>
										</div>
									</div>


								</td>
								<td style="width: 80px;"><button type="submit"
										style="background: rgba(0, 0, 0, 0)" class="buy">预订航班</button></td>

							</tr>
						</table>

					</div>
				</div>
		</div>
		</c:forEach>
	</div>
	<script>
		$(".buy").click(function(){
			var type = $(".type").html();
			var expStartTime = $(".expStartTime").html()
			expStartTime = $.trim(expStartTime);
			var expEndTime = $(".expEndTime").html()
			expEndTime = $.trim(expEndTime);
			var temp = $(".temp").html()
			var fromCity = $(".fromCity").html()
			var toCity = $(".toCity").html()
			var season_discount =$(".season_discount").html()
			var firstClassRemainSeats =$(".firstClassRemainSeats").html()
			var businessClassRemainSeats =$(".businessClassRemainSeats").html()
			var economyClassRemainSeats =$(".economyClassRemainSeats").html()
			var tprice = $(".tprice").html();
			var fid = $(".fid").html();
 			location.href="/airsys/user/buy/"+type+"/"+expStartTime+"/"+fid+"/"+tprice+"/"+expEndTime+"/"+temp+"/"+fromCity+"/"+toCity+"/"+season_discount+"/"+firstClassRemainSeats+"/"+businessClassRemainSeats+"/"+economyClassRemainSeats
 	})
	</script>


</body>
</html>