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
.layui-table{
	width:550px;
}


</style>

</head>
<body>
	<form action="listacts" method="get">
      <h3 align="center">已售机票信息</h3>
     <center>
    
     <table class="layui-table">
         <tr>
             <th>工号</th>
             <th>出票日期</th>
             <th>乘客类型</th>
             <th>价格</th>
             <th>操作</th>
         </tr>
 
         <c:forEach items="${history}" var="his">
         
         <tr>
             <th>${his.snumber}</th>
             <th>${his.tdate}</th>
             <th>${his.passengerType}</th>
             <th>${his.tprice}</th>
             <th><a href="#" class="layui-btn layui-btn-radius layui-btn-warm">查看详情</a></th>
         </tr>
         </c:forEach>
     </table> 

     </center> 
     </form>        
</body>
</html>