<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,entity.*,java.util.*"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>个人信息设置</title>
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
		<legend>个人详细信息</legend>
	</fieldset>
<form class="layui-form" action="/airsys/placeadmin/" method="post">

  <div class="layui-form-item">
    <div class="layui-input-block">

  </div>
    <input type="hidden" name="pid" value="${findPlaceAdmin.pid}">
  <div class="layui-form-item">
    <label class="layui-form-label panumber">工号</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="panumber" lay-verify="panumber" autocomplete="off" value="${findPlaceAdmin.panumber}" class="layui-input panumber">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label paname">姓名</label>
    <div class="layui-input-inline">
      <input type="text" readonly="readonly" name="paname" lay-verify="paname" autocomplete="off" value="${findPlaceAdmin.paname}" class="layui-input paname">
    </div>
  </div>
 

  </div>

</form>
 

</body>
</html>