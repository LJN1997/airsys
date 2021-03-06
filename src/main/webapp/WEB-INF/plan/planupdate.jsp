<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Airport,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<style type="text/css">
.container {
	width: 420px;
	height: 450px;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	margin: auto;
	padding: 20px;
	z-index: 130;
	border: 2px solid #009688;
	border-radius: 8px;
	background-color: #fff;
	font-size: 16px;
}

.close {
	background-color: white;
	border: none;
	font-size: 18px;
	margin-left: 410px;
	margin-top: -10px;
}

.layui-input {
	border-radius: 5px;
	width: 300px;
	height: 40px;
	font-size: 15px;
}


#logoid {
	margin-top: -16px;
	padding-left: 150px;
	padding-bottom: 15px;
}

.layui-btn {
	margin-left: -50px;
	border-radius: 5px;
	width: 350px;
	height: 40px;
	font-size: 15px;
}

.verity {
	width: 120px;
}

.font-set {
	font-size: 13px;
	text-decoration: none;
	margin-left: 120px;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<form class="layui-form" action="/airsys/plan/data" method="post">

		<div class="container">
			<button class="close" title="关闭" onclick=back()>X</button>
			<!--<div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="06.png" height="35">
        </div>-->
			<c:forEach items="${planinfo}" var="plan">
			<input type="hidden" value="${plan.planId }" name="planId">
				<div class="layui-form-item">
					<label class="layui-form-label">航班编号</label>
					<div class="layui-input-block">
						<input type="text" name="fnumber" required lay-verify="required"
							value="${plan.fnumber}" autocomplete="off" class="layui-input">
					</div>
				</div>
				</p>
				<div class="layui-form-item">
					<label class="layui-form-label">出发城市</label>
					<div class="layui-input-inline">
						<input type="text" name="fromCity" required lay-verify="required"
							value="${plan.fromCity}" autocomplete="off" class="layui-input">
					</div>
					<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">目的城市</label>
					<div class="layui-input-inline">
						<input type="text" name="toCity" required lay-verify="required"
							value="${plan.toCity}" autocomplete="off" class="layui-input">
					</div>
					<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">出发时间</label>
					<div class="layui-input-inline">
						<input type="Date" name="startdate" required lay-verify="required"
							value="${plan.startDate}" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">到达时间</label>
					<div class="layui-input-inline">
						<input type="Date" name="enddate" required lay-verify="required"
							value="${plan.endDate}" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">航班类型</label>
					<div class="layui-input-inline">
						<input type="text" name="type" required lay-verify="required"
							value="${plan.type}" autocomplete="off" class="layui-input">
					</div>
				</div>
			</c:forEach>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">确定修改</button>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="reset" class="layui-btn layui-btn-primary" lay-submit
						lay-filter="formDemo">重置</button>
				</div>
			</div>
		</div>
	</form>



	<script type="text/javascript" src="/airsys/assets/layui/layui.js"></script>
	<script type="text/javascript" src="/airsys/assets/js/plan.js"></script>

</body>
</html>
