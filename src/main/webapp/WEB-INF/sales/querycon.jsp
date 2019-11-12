<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*,util.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出账号</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<script type="text/javascript" src="/airsys/assets/layui/layui.js"></script>
</head>
<body>
	<form action="listacts" method="get">
     <h3 align="center">机票查询信息</h3>
     <center>
     <table class="layui-table">
         <tr>
             <th>航班号</th>
             <th>出发地</th>
             <th>目的地</th>
             <th>起飞时间</th>
             <th>到达时间</th>
             <th>头等舱剩余座位</th>
             <th>公务员剩余座位</th>
             <th>经济舱剩余座位</th>
             <th>票价</th>
             <th>操作</th>
         </tr>
 
         <c:forEach items="${info}" var="query">
         
         <tr class="tr">
             <td>${query.fnumber}</td>
             <td>${query.from_city}</td>
             <td>${query.to_city}</td>
             <td>${query.departure_time}</td>
             <td>${query.arrival_time}</td>
             <td>${query.first_class_remain_seats}</td>
             <td>${query.business_class_remain_seats}</td>
             <td>${query.economy_class_remain_seats}</td>
             <td>${query.tprice}</td>
             <td><button type="button" class="layui-btn layui-btn-radius layui-btn-warm buy">购买</button></td>
         </tr>
         </c:forEach>
     </table> 

     </center> 
     </form>        
</body>
<!-- "http://localhost:8080/airsys/sales/user2" -->
<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
<script>
$(".buy").click(function(){
	var from=$(this).parent().parent().children()[1].innerText;
	var to=$(this).parent().parent().children()[2].innerText;
	var time=$(this).parent().parent().children()[3].innerText;
	
	var time2=$(this).parent().parent().children()[4].innerText;
	var price=$(this).parent().parent().children()[8].innerText;
	location.href="http://localhost:8080/airsys/sales/user2/"+from+"/"+to+"/"+time+"/"+time2+"/"+price
})
</script>
</html>