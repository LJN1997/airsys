<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,entity.*,java.util.*"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta charset="utf-8">
<title>营业员售票信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
	<script src="/airsys/assets/layui/layui.js" charset="utf-8"></script>
	<script src="/airsys/assets/js/placeadmin_sales.js" charset="utf-8"></script>
	<script src="/airsys/assets/js/jquery-1.7.2.js"></script>   

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>营业员售票记录</legend>
	</fieldset>
	
	<form action="/airsys/placeadmin/ret2" method="post">
		
	<div class="layui-form">
	<div>
			<button type="submit" id="" class="layui-btn layui-btn-warm layui-btn-radius" ><<</button>
	</div>
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="200">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>机票编号</th>
					<th>航班编号</th>
					<th>营业员编号</th>
					<th>营业员名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${likeTicket}" var="sales">
				<tbody style="border:1px solid red">
					<tr id="">
						<td name = "tnumber">${sales.tnumber}</td>
						<td name = "fnumber">${sales.fnumber}</td>
						<td name = "snumber">${sales.snumber }</td>
						<td name = "sname">${sales.sname}</td>
						<td name = "caozuo">
							<button type="button" id="${sales.tid}" class="layui-btn layui-btn-primary delete" onclick="view(${sales.tid})">查看</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		

	</div>
	 
	
</form>

<!-- <script>
layui.use(['laypage', 'layer'], function(){
  $ = layui.jquery;
  var pageNum =${pageNum}
  var laypage = layui.laypage
  ,layer = layui.layer;
 
  laypage.render({
    elem: 'pageNo'
    ,count: pageNum
    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
    ,jump: function(obj){
      console.log(obj)
    }
  });
  
});
</script> -->

</body>
</html>