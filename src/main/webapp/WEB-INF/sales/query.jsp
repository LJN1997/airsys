<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>营业员查询界面</title>
  <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
  <link rel="stylesheet" href="/airsys/assets/css/sales.css">
</head>   

<body>
<form class="layui-form" action="http://localhost:8080/airsys/sales/query">
<div class="contain">
<div class="one">机票查询</div>

<div class="layui-tab">
  <ul class="layui-tab-title">
    <li class="layui-this">国内</li>
    <li>国外·港澳台</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
	    
	    <div class="layui-form-item">
    		<label class="layui-form-label">航程类型</label>
    		
    		<div class="layui-input-block">
     		 	<input type="radio" name="route" value="单程" title="单程">
      			<input type="radio" name="route" value="往返" title="往返" checked>
    		</div>
  		</div>
	    
	    <div class="layui-form-item">
	    	
	    	<label class="layui-form-label">出发城市</label>
		    <div class="layui-input-block">
		      <input type="text" name="from" required  lay-verify="required" placeholder="请输入出发城市" autocomplete="off" class="layui-input">
		    </div>
    		
    		<label class="layui-form-label">到达城市</label>
		    <div class="layui-input-block">
		      <input type="text" name="to" required  lay-verify="required" placeholder="请输入到达城市" autocomplete="off" class="layui-input">
		    </div>
    		
    		<label class="layui-form-label">出发时间</label>
		    <div class="layui-input-block">
		      <input type="date" name="starttime" required  lay-verify="required" placeholder="请输入出发时间" autocomplete="off" class="layui-input">
		    </div>
    		
    		<label class="layui-form-label">结束时间</label>
		    <div class="layui-input-block">
		      <input type="date" name="endtime" required  lay-verify="required" placeholder="请输入结束时间" autocomplete="off" class="layui-input">
		    </div>
    	    </div>
    <!-- 	
    	 <div class="layui-form-item ptype">
		    <label class="layui-form-label">乘客类型</label>
		    <div class="layui-input-block">
		      <select name="city" lay-verify="required">
		        <option value=""></option>
		        <option value="0">儿童</option>
		        <option value="1">成人</option>
		      </select>
	    	</div>
	    
	     </div>
    	<div class="layui-form-item ftype">
    		   <label class="layui-form-label">舱位等级</label>
		     <div class="layui-input-block">
		      <select name="city" lay-verify="required">
		        <option value=""></option>
		        <option value="0">经济舱</option>
		        <option value="1">公务舱</option>
		        <option value="3">头等舱</option>
		      </select>
	    	</div>
    	</div> -->
    	
    	<div class="layui-form-item">
    		<div class="layui-input-block">
     		 	<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
    		</div>
  		</div>
    	
    	
    </div>
<!--     <div class="layui-tab-item">
    	<div class="layui-form-item">
    		<label class="layui-form-label">航程类型</label>
    		
    		<div class="layui-input-block">
     		 	<input type="radio" name="sex" value="单程" title="单程">
      			<input type="radio" name="sex" value="往返" title="往返" checked>
    		</div>
  		</div>
	    
	    <div class="layui-form-item">
	    	
	    	<label class="layui-form-label">出发城市</label>
		    <div class="layui-input-block">
		      <input type="text" name="title" required  lay-verify="required" placeholder="请输入出发城市" autocomplete="off" class="layui-input">
		    </div>
    		
    		<label class="layui-form-label">到达城市</label>
		    <div class="layui-input-block">
		      <input type="text" name="title" required  lay-verify="required" placeholder="请输入到达城市" autocomplete="off" class="layui-input">
		    </div>
    		
    		<label class="layui-form-label">出发时间</label>
		    <div class="layui-input-block">
		      <input type="text" name="title" required  lay-verify="required" placeholder="请输入出发时间" autocomplete="off" class="layui-input">
		    </div>
    		
    		<label class="layui-form-label">结束时间</label>
		    <div class="layui-input-block">
		      <input type="text" name="title" required  lay-verify="required" placeholder="请输入结束时间" autocomplete="off" class="layui-input">
		    </div>
    	</div>
    	
    	 <div class="layui-form-item ptype">
		    <label class="layui-form-label">乘客类型</label>
		    <div class="layui-input-block">
		      <select name="city" lay-verify="required">
		        <option value=""></option>
		        <option value="0">儿童</option>
		        <option value="1">成人</option>
		      </select>
	    	</div>
	    
	     </div>
    	<div class="layui-form-item ftype">
    		   <label class="layui-form-label">舱位等级</label>
		     <div class="layui-input-block">
		      <select name="city" lay-verify="required">
		        <option value=""></option>
		        <option value="0">经济舱</option>
		        <option value="1">公务舱</option>
		        <option value="3">头等舱</option>
		      </select>
	    	</div>
    	</div> 
    	
    	<div class="layui-form-item">
    		<div class="layui-input-block">
     		 	<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
    		</div>
  		</div>
  		
    </div> -->
  </div>
</div>
</div>
</form>

 <script src="/airsys/assets/layui/layui.js"></script>
<script>

//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});


//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  /* form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  }); */
});
</script>
</body>
</html>