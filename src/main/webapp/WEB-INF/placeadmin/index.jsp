<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,entity.*,java.util.*"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>航天航空订票系统</title>
    <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
    <link rel="stylesheet" href="/airsys/assets/layui/css/index.css">
	<script src="/airsys/assets/layui/layui.js"></script>
	<script>
	    //JavaScript代码区域
	    layui.use('element', function(){
	        var element = layui.element;
	
	    });
	</script>
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <div class="layui-header">
        <div class="layui-logo">航天航空订票系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
       <!-- <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="" class="layui-nav-img">
                 ${placeAdmin.paname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/airsys/placeadmin/selfinfo/${placeAdmin.panumber}" target="main">基本资料</a></dd>
                    <dd><a href="/airsys/placeadmin/updatepwd/${placeAdmin.paid}/${placeAdmin.panumber}" target="main">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/airsys/main/login">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    
                <li class="layui-nav-item"><a href="/airsys/placeadmin/sales/${placeAdmin.pid}" target="main">营业员信息</a></li>
                <li class="layui-nav-item"><a href="/airsys/placeadmin/ticketinfo/${placeAdmin.pid}" target="main">营业员售票记录</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe name="main" frameborder="0" ></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>

</body>
</html>