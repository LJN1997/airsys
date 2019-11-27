<%@ page language="java" contentType="text/html; charset=utf-8"
	import="util.*,entity.*,java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta charset="utf-8">
<title>营业员信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
<script src="/airsys/assets/layui/layui.js" charset="utf-8"></script>
<script src="/airsys/assets/js/placeadmin_sales.js" charset="utf-8"></script>
<script src="/airsys/assets/js/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="/airsys/assets/js/main.js">

<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
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

.add {
	width: 60px;
	float: left;
}

span {
	
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
		<legend>营业员信息</legend>
	</fieldset>

	<form action="/airsys/placeadmin/searchs" method="post">

		<div class="layui-form ">
			<div class="but">
				<div>
					<input type="text" name="keys" placeholder="请输入关键字 "
						class="layui-input inp">

					<button type="submit" id="${pid}"
						class="layui-btn layui-btn-primary ser">搜索</button>
				</div>
			</div>
			<button type="button" id="${pid}" class="layui-btn add"
				onclick="add(${pid})">添加</button>
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
						<th>工号</th>
						<th>名称</th>
						<th>联系方式</th>
						<th>操作</th>
					</tr>
				</thead>
 				<c:forEach items="${data}" var="sales">
					<tbody>
						<tr id="${sales.sid }">
							<td name="snumber">${sales.snumber}</td>
							<td name="sname">${sales.sname }</td>
							<td name="sphone">${sales.sphone }</td>

							<td name="caozuo">
								<button type="button" id="${sales.sid }c"
									class="layui-btn layui-btn-danger delete"
									onclick="del(${sales.sid},${pid})">删除</button>
							</td>
						</tr>
					</tbody>
				</c:forEach> 
			</table>

			<ul class="numm">
				<c:choose>

					<c:when test="${pageNo==1}">
						<li><a href="#"> << </a></li>
					</c:when>
					<c:when test="${pageNo>1&&pageNo<=pageNum}">
						<li><a
							href="http://localhost:8080/airsys/placeadmin/saless/${pid}/${pageNo-1}">&lt;&lt;</a></li>
					</c:when>

				</c:choose>


				<c:forEach var="pager" begin="1" end="${pageNum}">
				
					<li >
						<a class="pageNo"
						href="http://localhost:8080/airsys/placeadmin/saless/${pid}/${pager}">${pager}</a>

						<%-- <input class="bu" name="bu" type="button" value="${pager}"> --%>
					</li>
				</c:forEach>

				<c:choose>

					<c:when test="${pageNo==pageNum}">
						<li><a href="#"> >> </a></li>
					</c:when>
					<c:when test="${pageNo!=pageNum||pageNo==1}">
						<li><a
							href="http://localhost:8080/airsys/placeadmin/saless/${pid}/${pageNo+1}">
								>> </a></li>
					</c:when>

				</c:choose>


			</ul>
			<span>总页数：${pageNum},每页5条数据</span> <input type="hidden" name="pid"
				value="${pid}">
		</div>
	</form>

	<!-- <script type="text/javascript">
	window.onload = function(){
		var pid = ${pid}
		var pageNum = ${pageNum}

		$(".numm").on("click",".bu",function(){
			//alert($(this).val())
			var pageNo = $(this).val()
				$.ajax({
			url:"http://localhost:8080/airsys/placeadmin/salesss/"+pid+"/"+pageNo+"", 
			dataType: "json",
			success:function(e){			
		var table = document.querySelector("table tbody");
		var thead = document.querySelector("thead");
	
			console.log(e)
		$("tbody").empty();
			for(var i = 0;i<e.length;i++){
				
				var tr = document.createElement("tr");
	            var td="";
	            //console.log(e[i].snumber)
	            //console.log(e[i].sname)
	            //console.log(e[i].sphone)
	            //console.log(e[i].sid)
	         
	            td+="<td attr='snumber'>"+e[i].snumber+"</td>";   
	            td+="<td attr='sname'>"+e[i].sname+"</td>";
	            td+="<td attr='sphone'>"+e[i].sphone+"</td>";
	            td+="<td attr='caozuo'><button type='button' class='layui-btn layui-btn-danger delete' id="+pid+" onclick='del("+e[i].sid+","+pid+")'>删除</td>";
	            tr.innerHTML=td;
	            table.append(tr);
			}

         
				
				
			
			}
		})				
		
	})
	}
</script> -->


</body>
</html>