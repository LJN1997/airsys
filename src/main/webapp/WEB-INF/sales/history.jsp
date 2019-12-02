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
	width:850px;
}
.history{
  width:200px;
  height:50px;
  font-size: 20px;
  margin-top:50px;
  margin-left:100px;
}

</style>

</head>
<body>
	<form action="listacts" method="get">
      <div class = "history">已售机票信息</div>
   
    <center>
     <table class="layui-table">
         <tr>
             <th>工号</th>
             <th>出票日期</th>
             <th>乘客类型</th>
             <th>舱位等级</th>
             <th>价格</th>
             <th>状态</th>
         </tr>
 
         <c:forEach items="${history}" var="his">
         
         <tr>
             <th>${his.snumber}</th>
             <th>${his.tdate}</th>
             <th>${his.passengerType}</th>
             <th>${his.tclass}</th>
             <th>${his.tprice}</th>
             
             <c:if test="${his.status==0}"> <th>此票已退</th></c:if>
             <c:if test="${his.status==1}"> <th>正在进行</th></c:if>
             <c:if test="${his.status==2}"> <th>此票改签</th></c:if>
         </tr>
         </c:forEach>
     </table> 
	</center>
   
     </form>        
</body>
</html>