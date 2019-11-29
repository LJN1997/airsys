<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% response.setContentType("text/html;charset=utf-8"); %>
<%request.setCharacterEncoding("utf-8"); %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>改签信息</title>
    <style>
        body{
            margin: 0;padding: 0;
        }
        .box{
            width: 380px;
            height: 460px;
            background: darkgray;
            border-radius: 50px;
            margin-left: 200px;
            margin-top: 50px;
        }
        h2{
            margin-left: 30px;
           padding-top: 20px;
            color: white;
            font-size: 30px;
            margin-bottom: 40px;
        }
        .con{

            margin-left: 50px;
            margin-bottom: 25px;
            color: white;

        }
        .con input{
            width: 173px;height: 22px;
        }
        .tofind{
            width: 250px;height: 35px;
            margin-left: 50px;
            margin-top: 20px;
            font-size: 20px;

        }
         .date{
             width: 173px;height: 21px;
        }
        .typeMan{
            width: 173px;height: 24px;
        }
    </style>
</head>
<body>
<div class="box">
<h2>改签机票信息</h2>


    <div class="con">
        出&nbsp;&nbsp;发&nbsp;&nbsp;地：<input type="text" name="fnumber">
    </div>
    <div class="con">
        目&nbsp;&nbsp;的&nbsp;&nbsp;地：<input type="text" name="fnumber">
    </div>
    <div class="con">
        起飞时间：<input class="date" type="date" name="fnumber">
    </div>
    <div class="con">
        乘客类型：
        <select class="typeMan">
            <option>成人</option>
            <option>儿童</option>
        </select>
    </div>
    <div class="con">
        座位等级：
        <select class="typeMan">
            <option>经济舱</option>
            <option>商务舱</option>
            <option>头等舱</option>
        </select>
    </div>
    <input type="submit" class="tofind" value="确定修改，立即查询"></button>

</div>
</body>
</html>