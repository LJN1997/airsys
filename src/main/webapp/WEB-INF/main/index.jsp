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
   
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/airsys/assets/layui/images/face/62.gif" class="layui-nav-img">
                   ${admin.aname }
                </a>
               <%--  <dl class="layui-nav-child">
                    <dd><a href="http://localhost:8080/airsys/air/userpwd/${admin.aid}" target="main">安全设置</a></dd>
                </dl>  --%>
            </li>
            <li class="layui-nav-item"><a href="/airsys/main/login" class="exitbtn">退出</a></li>
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
                <li class="layui-nav-item"><a href="/airsys/plan/planinfo" target="main">航班计划</a></li>
                <li class="layui-nav-item"><a href="/airsys/flight/flightinfo" target="main">航班信息</a></li>
                <li class="layui-nav-item"><a href="/airsys/placeNote/placeNotesinfo" target="main">订单信息</a></li>
                <li class="layui-nav-item"><a href="/airsys/data/main" target="main">营业点业绩</a></li>
                 
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe name="main" frameborder="0"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>

</body>
</html>