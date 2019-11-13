<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="entity.UserSelect"%>
<html>
<link rel="stylesheet" href="/airsys/assets/css/bookingflight.css">
<link rel="stylesheet" href="/airsys/assets/css/flightInfo.css">
<body>
	<c:forEach items="${usts}" var="list">
${list.fnumber}
${list.tprice}
${list.departureTime}
${list.arrivalTime}
</c:forEach>

	<div class="box">
		<div class="title">预订航班</div>
		<div class="infobox">
			<div class="info">
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
							<td style="width: 70px;"><a href="">预订航班</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>



</body>
</html>