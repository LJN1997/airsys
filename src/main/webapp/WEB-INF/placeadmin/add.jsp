<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,entity.*,java.util.*"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta charset="utf-8">
<title>添加营业员信息</title>
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
		<legend>添加营业员信息</legend>
	</fieldset>
 
<form class="layui-form" action="/airsys/placeadmin/add2" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label snumber">工号</label>
    <div class="layui-input-block">
      <input type="text" name="snumber" lay-verify="snumber" autocomplete="off" placeholder="请输入工号" class="layui-input snumber">
    </div>
  </div>
<input type="hidden" name="pid" value="${pid}">
  <div class="layui-form-item">
    <label class="layui-form-label sname">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="sname" lay-verify="sname" autocomplete="off" placeholder="请输入姓名" class="layui-input sname">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label sphone">联系方式</label>
    <div class="layui-input-inline">
      <input type="text" name="sphone" lay-verify="sphone" placeholder="请输入电话号码" autocomplete="off" class="layui-input sphone">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label spwd">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="spwd" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input spwd">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写5到12位密码</div>
  </div>
  


  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
	  snumber: function(value){
	      if(value.length ==0){
	        return '工号不能为空';
	      }
	    }
	    ,
    sname: function(value){
      if(value.length == 0){
        return '姓名不能为空';
      }
      if(value.length < 2){
          return '不能少于两个字符';
        }
    },
    sphone: function(value){
        if(value.length == 0){
          return '电话号码不能为空';
        }
        if(value.length != 11){
            return '请输入11位电话号码';
          }
      }
    ,pass: [
      /^[\S]{5,12}$/
      ,'密码必须5到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
    
});
</script>



</body>
</html>