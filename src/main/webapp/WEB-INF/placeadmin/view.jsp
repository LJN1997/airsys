<%@ page language="java" contentType="text/html; charset=utf-8"
	import="util.*,entity.*,java.util.*" pageEncoding="utf-8"%>
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
<style type="text/css">
.for {
	width: 700px;
	height: 400px;
	margin: auto;
	border: 1px solid gray;
}

.b {
	width: 650px;
	height: 400px;
	margin: auto;
	margin-top: 40px;
}

.b>div {
	float: left;
}

.a {
	display: block;
	float: left;
	

}

.inp {
	float: left;
}

.C{
	float: right;
}
</style>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>查看详细信息</legend>
	</fieldset>
	<form class="layui-form for" action="/airsys/placeadmin/saleticket"
		method="post">

		<button type="button"
			class="layui-btn layui-btn-danger layui-btn-sm C" lay-filter="demo1"
			onclick="ret(${pid})">X</button>



		<c:forEach items="${findTicket}" var="tlistPaged">

			<div class="b">

				<input type="hidden" name="pid" value="${pid}">
				<div class="a">
					<div class="layui-form-item  ">
						<label class="layui-form-label oname">乘客姓名</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="oname"
								lay-verify="oname" autocomplete="off"
								value="${tlistPaged.oname}" class="layui-input inp "oname"">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label idcard">身份证</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="idcard"
								lay-verify="idcard" autocomplete="off"
								value="${tlistPaged.idcard}" class="layui-input inp "idcard"">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item bbb">
						<label class="layui-form-label ophone">联系方式</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="ophone"
								lay-verify="ophone" autocomplete="off"
								value="${tlistPaged.ophone}" class="layui-input inp"ophone"">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label fromCity">出发地</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="fromCity"
								lay-verify="fromCity" autocomplete="off"
								value="${tlistPaged.fromCity}" class="layui-input inp fromCity">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label sname">目的地</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="toCity"
								lay-verify="toCity" autocomplete="off"
								value="${tlistPaged.toCity}" class="layui-input inp"toCity"">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label startDate">出发时间</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="startDate"
								lay-verify="startDate" value="${tlistPaged.expStartTime}"
								autocomplete="off" class="layui-input startDate">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label endDate">到达时间</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="endDate"
								lay-verify="endDate" value="${tlistPaged.expEndTime}"
								autocomplete="off" class="layui-input inp endDate">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label tclass">舱位等级</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="tclass"
								lay-verify="tclass" value="${tlistPaged.tclass}"
								autocomplete="off" class="layui-input inp tclass">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label passengerType">乘客类型</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="passengerType"
								lay-verify="passengerType" value="${tlistPaged.passengerType}"
								autocomplete="off" class="layui-input inp passengerType">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label tprice">票价</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="tprice"
								lay-verify="tprice" value="${tlistPaged.tprice}"
								autocomplete="off" class="layui-input inp tprice">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label type">机型</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="type"
								lay-verify="type" value="${tlistPaged.type}" autocomplete="off"
								class="layui-input inp type">
						</div>
					</div>
				</div>

				<div class="a">
					<div class="layui-form-item ">
						<label class="layui-form-label sailLength">里程</label>
						<div class="layui-input-inline">
							<input type="text" readonly="readonly" name="sailLength"
								lay-verify="sailLength" value="${tlistPaged.sailLength}"
								autocomplete="off" class="layui-input inp sailLength">
						</div>
					</div>
				</div>


			</div>
		</c:forEach>

	</form>


</body>
</html>