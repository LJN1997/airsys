<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>营业员界面</title>
  <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
  <style type="text/css">
  iframe{
  width:100%;height:100%;
  }
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">营业员</div>
    
 
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573561160741&di=a48bf83390ad5a1818229a885f623a1a&imgtype=0&src=http%3A%2F%2Fwww.unithermal.com.cn%2Fdata%2Fimages%2Fcase%2F20161223134959_895.jpg" class="layui-nav-img">
          营业员
        </a>
        <dl class="layui-nav-child">
          <dd><a href="http://localhost:8080/airsys/sales/saleinfo/1" target="aa">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="http://localhost:8080/airsys/sales/login">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">票务管理</a>
          <dl class="layui-nav-child">
            <dd><a href="http://localhost:8080/airsys/sales/user1" target="aa">查询</a></dd>
            <dd><a href="http://localhost:8080/airsys/sales/user3" target="aa">退票</a></dd>
            <dd><a href="http://localhost:8080/airsys/sales/user4" target="aa">改签</a></dd>
           
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">历史记录</a>
          <dl class="layui-nav-child">
            <dd><a href="http://localhost:8080/airsys/sales/history/1" target="aa">查看已售机票信息</a></dd>
            
          </dl>
        </li>
        <li class="layui-nav-item" ><a href="http://localhost:8080/airsys/sales/saleinfo/1" target="aa">个人信息</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe src="" frameborder="0" name="aa"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © uek.com - ubdf1907版权所有
  </div>
</div>
<script src="/airsys/assets/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>