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
<form class="layui-form" action="/airsys/placeadmin/updatepwd2" method="post">

  <div class="layui-form-item">
    <div class="layui-input-block">

  </div>
  
    <input type="hidden" name="paid" value="${paid}">
  <div class="layui-form-item">
    <label class="layui-form-label ">新密码</label>
    <div class="layui-input-inline">
      <input type="password"  name="papwd" lay-verify="papwd" autocomplete="off" placeholder="请输入新密码"  class="layui-input papwd">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写5到12位密码</div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label ">确认密码</label>
    <div class="layui-input-inline">
      <input type="password"  name="papwd1" lay-verify="papwd1" autocomplete="off" placeholder="请再次确认密码" class="layui-input papwd1">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写5到12位密码</div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>

  </div>

</form>
 
 
 
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
	  papwd: function(value) {
		    if (value === "") 
		      return "密码不能为空！";
		    var regExpDigital = /^[\S]{5,12}$/;		   
		    if (regExpDigital.test(value)) {
		        return '密码必须5到12位，且不能出现空格';
		    }
		},
		papwd1: function(value) {
		    if (value === "") 
		      return "请输入二次密码！";
		    var papwd = $('input[name=papwd').val();
		    if (papwd !== value) 
		      return "二次输入的密码不一致！";
		    var regExpDigital = /^[\S]{5,12}$/;		   
		    if (regExpDigital.test(value)) {
		        return '密码必须5到12位，且不能出现空格';
		}
    
  });
    
});
</script>
 

</body>
</html>