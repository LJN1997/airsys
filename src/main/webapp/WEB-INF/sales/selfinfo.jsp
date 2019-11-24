<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.*,util.*,controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<style type="text/css">
h2 {
	font-size: 30px;
	margin-bottom: 30px;
}

.container {
	width: 380px;
	height:470px;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	margin: auto;
	padding: 20px;
	z-index: 130;
	border-radius: 8px;
	background-color: #fff;
	box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
	font-size: 16px;
}

.layui-input {
	border-radius: 5px;
	width: 250px;
	height: 40px;
	font-size: 15px;
}

.layui-form-item {
	margin-left: -20px;
}

#logoid {
	margin-top: -16px;
	padding-left: 150px;
	padding-bottom: 15px;
}

.layui-btn {
	margin-left: -50px;
	border-radius: 5px;
	width: 300px;
	height: 40px;
	font-size: 15px;
	margin-top: 10px;
}

.font-set {
	font-size: 13px;
	text-decoration: none;
	margin-left: 120px;
}
</style>
</head>

<body>
		<c:forEach items="${sale}" var="info">
			<div class="container">
				<h2>个人信息</h2>
				<div class="layui-form-item">
					<label class="layui-form-label">工号</label>
					<div class="layui-input-block">
						<input type="text" id="snumber" value="${info.snumber}" name="num" required
							lay-verify="required" placeholder="请输入工号" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" id="name" value="${info.sname}" name="num" required
							lay-verify="required" placeholder="请输入姓名" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">联系电话</label>
					<div class="layui-input-block">
						<input type="text" id="phone" value="${info.sphone}" name="num" required
							lay-verify="required" placeholder="请输入联系电话" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">所在省市</label>
					<div class="layui-input-block">
						<input type="text" id="province" value="${info.province}" name="num" required
							lay-verify="required" placeholder="请输入营业点所在省份" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">营业点地址</label>
					<div class="layui-input-block">
						<input type="text" id="psite" value="${info.psite}" name="num" required
							lay-verify="required" placeholder="请输入营业点地址" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">营业点名字</label>
					<div class="layui-input-block">
						<input type="text" id="pname" value="${info.pname}" name="num" required
							lay-verify="required" placeholder="请输入营业点名称" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn edit" lay-submit lay-filter="formDemo">确定编辑</button>
					</div>
				</div>

			</div>
		</c:forEach>
	

	<script type="text/javascript" src="/airsys/assets/layui/layui.js"></script>
	<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
	<script>
	window.onload=function(){
		$(".edit").click(function(){
			var snumber = $("#snumber").val();
			var name = $("#name").val();
			var phone = $("#phone").val();
			var province = $("#province").val();
			var psite = $("#psite").val();
			var pname = $("#pname").val();
			alert(snumber+name+phone+province+psite+pname)
			$.ajax({
				url:"editCon",
				type:"post",
				dataType:"json",
				data:{
					snumber:snumber,
					name:name,
					phone:phone,
					province:province,
					psite:psite,
					pname:pname
				},
				success:function(e){
			 		 console(e)
				}
			})
		})
	}
		
	
	</script>
</body>
</html>
