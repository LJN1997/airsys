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
<style type="text/css">

  h3{
    font-size:30px;
    float: left;
    margin-top: 10px;
    margin-left: 20px;
    margin-bottom: 20px;
  }
	.layui-table{
	width:1120px;
	}
	
</style>
</head>
<body>
	<form action="" method="get">
     <h3 align="center">机票查询信息</h3>
     <center>
     <table class="layui-table">
         <tr>
             <th>航班号</th>
             <th>出发地</th>
             <th>目的地</th>
             <th>起飞时间</th>
             <th>到达时间</th>
             <th>头等舱剩余</th>
             <th>商务舱剩余</th>
             <th>经济舱剩余</th>
             <th>票价</th>
             <th>操作</th>
         </tr>
 
         <c:forEach items="${info}" var="query">
         
         <tr class="tr" id="${query.planId}">
             <td>${query.fnumber}</td>
             <td>${query.fromCity}</td>
             <td>${query.toCity}</td>
             <td>${query.expStartTime}</td>
             <td>${query.expEndTime}</td>
             <td>${query.firstClassRemainSeats}</td>
             <td>${query.businessClassRemainSeats}</td>
             <td>${query.economyClassRemainSeats}</td>
             <td>${query.tprice}</td>
             <td ><button type="button" name="planId" class="layui-btn layui-btn-radius layui-btn-warm reserve">预定</button></td>
         </tr>
         </c:forEach>
     </table> 

     </center> 
     </form>        
</body>
<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
<script>

$(".reserve").click(function(){
	var planId = $(this).parent().parent().attr('id');
	var fnumber=$(this).parent().parent().children()[0].innerText;
	var from=$(this).parent().parent().children()[1].innerText;
	var to=$(this).parent().parent().children()[2].innerText;
	var expStartTime=$(this).parent().parent().children()[3].innerText;
	var expEndTime=$(this).parent().parent().children()[4].innerText;
	var price=$(this).parent().parent().children()[8].innerText;
	location.href="reserve/"+from+"/"+to+"/"+expStartTime+"/"+expEndTime+"/"+price+"/"+fnumber+"/"+planId;
})
</script>
</html>