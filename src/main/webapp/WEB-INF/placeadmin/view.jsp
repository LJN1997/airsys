<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,entity.*,java.util.*"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>查看售票记录详细信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
	<script src="/airsys/assets/layui/layui.js" charset="utf-8"></script>
	<script src="/airsys/assets/js/placeadmin_sales.js" charset="utf-8"></script>
	<script src="/airsys/assets/js/jquery-1.7.2.js"></script>   
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>查看详细信息</legend>
	</fieldset>
<form class="layui-form" action="/airsys/placeadmin/saleticket" method="post">
<c:forEach items="${findTicket}" var="tlistPaged">  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="button" class="layui-btn layui-btn-warm layui-btn-radius" lay-filter="demo1"onclick="ret(${pid})"> << </button>
  </div>
    <input type="hidden" name="pid" value="${pid}">
  <div class="layui-form-item">
    <label class="layui-form-label fromCity">出发地</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="fromCity" lay-verify="fromCity" autocomplete="off" value="${tlistPaged.fromCity}" class="layui-input fromCity">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label sname">目的地</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="toCity" lay-verify="toCity" autocomplete="off" value="${tlistPaged.toCity}" class="layui-input "toCity"">
    </div>
  </div>
 
  <div class="layui-form-item">
    <label class="layui-form-label startDate">出发时间</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="startDate" lay-verify="startDate" value="${tlistPaged.expStartTime}" autocomplete="off" class="layui-input startDate">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label endDate">到达时间</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="endDate" lay-verify="endDate" value="${tlistPaged.expEndTime}" autocomplete="off" class="layui-input endDate">
    </div>
  </div>
  
    <div class="layui-form-item">
    <label class="layui-form-label tclass">舱位等级</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="tclass" lay-verify="tclass" value="${tlistPaged.tclass}" autocomplete="off" class="layui-input tclass">
    </div>
  </div>
  
      <div class="layui-form-item">
    <label class="layui-form-label passengerType">乘客类型</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="passengerType" lay-verify="passengerType" value="${tlistPaged.passengerType}" autocomplete="off" class="layui-input passengerType">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label tprice">票价</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="tprice" lay-verify="tprice" value="${tlistPaged.tprice}" autocomplete="off" class="layui-input tprice">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label type">机型</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="type" lay-verify="type" value="${tlistPaged.type}" autocomplete="off" class="layui-input type">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label sailLength">里程</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="sailLength" lay-verify="sailLength" value="${tlistPaged.sailLength}" autocomplete="off" class="layui-input sailLength">
    </div>
  </div>
  

  </div>
</c:forEach>
</form>
 

</body>
</html>