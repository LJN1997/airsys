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

	<input type="hidden" value="${buff}" name="buff" class="buff">
	<input type="hidden" value="${tid}" name="tid" class="tid">
	<input type="hidden" value="${tclass}" name="tclass" class="tclass">
	<input type="hidden" value="${oname}" name="oname" class="oname">
	<input type="hidden" value="${idcard}" name="idcard" class="idcard">
	<input type="hidden" value="${Catch}" name="Catch" class="Catch">
	
	<style>
		body{
			background: url("https://turkishairlines.ssl.cdn.sdlmedia.com/636866809060120078CY.jpg") no-repeat ;
			background-size: 100%;
		}
	</style>
	
	<form action="/airsys/user/sigcon" method="get" class="form">
	<input type="hidden" value="1" name="status">
	<script type="text/javascript">
	var Catch = $(".Catch").val();
	var form = document.querySelector(".form");
	if (Catch == 1 || Catch == "1") {
		alert("抱歉，没有找到您要查询的航班，请重新输入！");
		form.submit();
	}
	</script>
	</form>
	<div class="box">
		<div class="title">航班信息</div>
		<div class="infobox">
			<c:forEach items="${usts}" var="list">
				<div class="info" id="${list.planId}"
					style="height: 100px; background: rgba(0, 0, 0, 0.2)">
					<div class="top1">
						<table>
							<tr>
								<td><h5 style="width: 90px;" class="type">${list.type}</h5></td>
								<td style="width: 90px;">航班号：
									<h5 class="fid">${list.fid}</h5>
								</td>
								<td class="t2">
									<div>
										<div class="con-three-bot-left">
											<p class="expStartTime">
												<fmt:formatDate value="${list.expStartTime}" type="time"
													timeStyle="medium" />
											</p>
											<p class="fromCity">${list.fromCity}</p>
										</div>
										<div class="con-three-bot-mid">
											<span class="p1"><b class="temp">${list.temp}</b>分</span> <span
												class="p2">——</span>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p class="expEndTime">
												<fmt:formatDate value="${list.expEndTime}" type="time"
													timeStyle="medium" />
											</p>
											<p class="toCity">${list.toCity}</p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p>
												折扣:<b class="season_discount">${list.season_discount}</b>折
											</p>
											<p>
												价格:<b class="tprice">${list.tprice}</b>
											</p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 40px;">

											<p>头等舱：
											<p class="firstClassRemainSeats">${list.firstClassRemainSeats}</p>
											</p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p></p>
											商务舱：
											<p class="businessClassRemainSeats">${list.businessClassRemainSeats}</p>
										</div>
										<div class="con-three-bot-right" style="margin-left: 30px;">
											<p></p>
											<p>经济舱：
											<p class="economyClassRemainSeats">${list.economyClassRemainSeats}</p>
											</p>
										</div>
									</div>
								</td>
								<td style="width: 90px;"><button type="submit" id="${list.planId }"
										style="background: rgba(0, 0, 0, 0)" class="buy">预订航班</button></td>
							</tr>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script>
		//$(".buy").click(
				$("table").on("click",".buy",function(){
					var type = $(this).parent().parent().children("td:eq(0)").text();
					var fid = $.trim($(this).parent().parent().children("td:eq(1)").children().text());
					var expStartTime = $.trim($(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(1)").children("p:nth-child(1)").text());
					var fromCity = $.trim($(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(1)").children("p:nth-child(2)").text());
					var temp = $.trim($(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(2)").children().children().text());
					var expEndTime = $.trim($(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(3)").children("p:nth-child(1)").text());
					var toCity = $.trim($(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(3)").children("p:nth-child(2)").text());
					var season_discount = $(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(4)").children("p:nth-child(1)").children().text();
					var tprice = $(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(4)").children("p:nth-child(2)").children().text();
					var firstClassRemainSeats = $(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(5)").children("p:nth-child(2)").text();
					var businessClassRemainSeats = $(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(6)").children("p:nth-child(2)").text();
					var economyClassRemainSeats = $(this).parent().parent().children("td:eq(2)").children().children("div:nth-child(7)").children("p:nth-child(3)").text();
					
					/* var planId = $("#planId").val; */
					
					var buff = $(".buff").val();
					var tid = $(".tid").val();
					var tclass = $(".tclass").val();
					var oname = $(".oname").val();
					var idcard = $(".idcard").val();
					if (buff == 1) {
						location.href = "/airsys/user/buy/" + type + "/"
								+ expStartTime + "/" + fid + "/" + tprice + "/"
								+ expEndTime + "/" + temp + "/" + fromCity
								+ "/" + toCity + "/" + season_discount + "/"
								+ firstClassRemainSeats + "/"
								+ businessClassRemainSeats + "/"
								+ economyClassRemainSeats + "/" + buff + "/"
								+ tid + "/" + tclass + "/" + oname + "/"
								+ idcard
					} else {
						location.href = "/airsys/user/buy1/" + type + "/"
								+ expStartTime + "/" + fid + "/" + tprice + "/"
								+ expEndTime + "/" + temp + "/" + fromCity
								+ "/" + toCity + "/" + season_discount + "/"
								+ firstClassRemainSeats + "/"
								+ businessClassRemainSeats + "/"
								+ economyClassRemainSeats
					}
				})
				
	</script>


</body>
</html>