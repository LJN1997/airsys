<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*,util.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列出账号</title>
</head>
<body>
	<form action="listacts" method="get">
     <h3 align="center">机票查询信息</h3>
     <center>
     <table border="1">
         <tr>
             <th>航班号</th>
             <th>出发地</th>
             <th>目的地</th>
             <th>出发时间</th>
             <th>起飞时间</th>
             <th>到达时间</th>
             <th>头等舱剩余座位</th>
             <th>公务员剩余座位</th>
             <th>经济舱剩余座位</th>
             <th>票价</th>
             <th>操作</th>
         </tr>
 
         <c:forEach items="${info}" var="query">
         
         <tr>
             <th>${query.fnumber}</th>
             <th>${query.from_city}</th>
             <th>${query.to_city}</th>
             <th>${query.start_date}</th>
             <th>${query.departure_time}</th>
             <th>${query.arrival_time}</th>
             <th>${query.first_class_remain_seats}</th>
             <th>${query.business_class_remain_seats}</th>
             <th>${query.economy_class_remain_seats}</th>
             <th>${query.tprice}</th>
             <th><a href="http://localhost:8080/airsys/sales/saleinfo/1"><button type="button" class="layui-btn layui-btn-radius layui-btn-warm">购买</button></a></th>
         </tr>
         </c:forEach>
     </table> 

     </center> 
     </form>        
</body>
</html>