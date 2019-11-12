<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="http://localhost:8080/airsys/air/userinfo" target="main">基本资料</a></dd>
                    <dd><a href="http://localhost:8080/airsys/air/userpwd" target="main">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="http://localhost:8080/airsys/air/airinfo" target="main">机场信息</a>
                    <!--<dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>-->
                </li>
                <li class="layui-nav-item">
                    <a href="http://localhost:8080/airsys/place/placeinfo" target="main">营业点信息</a>
                 <!--   <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>-->
                </li>
                <li class="layui-nav-item"><a href="/airsys/user/userinfo" target="main">用户信息</a></li>
                <li class="layui-nav-item"><a href="">航班信息</a></li>
                  <li class="layui-nav-item">
                    <a href="#" >票务管理</a>
                  <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查询</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/airsys/placeadmin/sales" target="main">营业员信息</a></li>
                <li class="layui-nav-item"><a href="/airsys/placeadmin/ticketinfo" target="main">营业员售票记录</a></li>
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