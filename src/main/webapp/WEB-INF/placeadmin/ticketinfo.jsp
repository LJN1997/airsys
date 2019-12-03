<%@ page language="java" contentType="text/html; charset=utf-8"
	import="util.*,entity.*,java.util.*" pageEncoding="utf-8"%>
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
<style>
.but {
	width: 300px;
	float: right;
}

.inp {
	width: 240px;
	float: left;
}

.ser {
	width: 60px;
	float: right;
}

ul {
	float: right;
	width: 200px;
	list-style: none;
	display: flex;
	justify-content: space-around;
	width: 200px;
}
</style>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>营业员售票记录</legend>
	</fieldset>

	<form class="layui-form for" action="/airsys/placeadmin/searcht" method="post">

		<div class="layui-form">
			<div class="but">
				<input lay-verify="snumber" autocomplete="off" type="text" name="keys" placeholder="请输入关键字 "
					class="layui-form-label layui-input inp">
				<button type="submit" id="" class="layui-btn layui-btn-primary ser">搜索</button>
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
						<th>营业员编号</th>
						<th>营业员姓名</th>
						<th>机票编号</th>
						<th>航班编号</th>
						<th>机票状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach items="${data}" var="sales">
					<tbody style="border: 1px solid red">
						<tr id="">
							<td name="snumber">${sales.snumber}</td>
							<td name="sname">${sales.sname}</td>
							<td name="tnumber">${sales.tid}</td>
							<td name="fnumber">${sales.fnumber}</td>
							<c:choose>
								<c:when test="${sales.status==1}">
									<td name="status">出票完成</td>
								</c:when>
								<c:when test="${sales.status==0}">
									<td name="status">已退票</td>
								</c:when>
								<c:when test="${sales.status==2}">
									<td name="status">已改签</td>
								</c:when>
							</c:choose>
							<td name="caozuo">
								<button type="button" id="${sales.tid}"
									class="layui-btn layui-btn-primary delete"
									onclick="view(${sales.tid},${pid})">查看</button>
							</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
			<ul>
				<c:choose>

					<c:when test="${pageNo==1}">
						<li><a href="#"> << </a></li>
					</c:when>
					<c:when test="${pageNo>1&&pageNo<=pageNum1}">
						<li><a
							href="http://localhost:8080/airsys/placeadmin/ticketinfo1/${pid}/${pageNo-1}">&lt;&lt;</a></li>
					</c:when>

				</c:choose>


				<c:forEach var="pager" begin="1" end="${pageNum1}">
					<li><a
						href="http://localhost:8080/airsys/placeadmin/ticketinfo1/${pid}/${pager}">${pager}</a></li>
				</c:forEach>

				<c:choose>

					<c:when test="${pageNo==pageNum1}">
						<li><a href="#"> >> </a></li>
					</c:when>
					<c:when test="${pageNo!=pageNum1||pageNo==1}">
						<li><a
							href="http://localhost:8080/airsys/placeadmin/ticketinfo1/${pid}/${pageNo+1}">
								>> </a></li>
					</c:when>

				</c:choose>


			</ul>
			<span>总页数：${pageNum1},每页5条数据</span> <input type="hidden" name="pid"
				value="${pid}">

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
 
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
 
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
	  keys: function(value){
	      if(value.length ==0){
	        return '不能为空';
	      }
	    }
	    
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
    
});
</script>

</body>
</html>