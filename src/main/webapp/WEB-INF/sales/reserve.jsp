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
    <title>机票预订</title>
    <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
    <style>
        body{
            margin: 0;padding: 0;
        }
        .showTicket{
            width: 800px;height: 230px;
            background: gainsboro;
            margin-left: 60px; 
            margin-top: 40px;
            border-radius: 40px;
            position: relative;
        }
        .passenger{
            border-radius: 40px;
            width: 800px;height: 350px;
            background: gainsboro;
             margin-left: 60px; 
            margin-top: 20px;
            position: absolute;
        }
        h2{
           margin-left: 50px;
           padding-top: 20px;
            font-size:25px;
        }
        .info-top{
           margin-left: 50px;
           padding-top: 20px;
           margin-bottom: 25px;
           font-size:25px;
        }
        .showFnumber{
            width: 300px;height: 30px;
            margin-left: 60px;
             margin-top: 20px;
            float: left;
        }
        .showStart{
            width: 300px;height: 30px;
            margin-left: 60px;
            margin-top: 20px;
            float: left;
        }
        .showEnd{
            width: 300px;height: 30px;
            margin-left: 400px;
            margin-top: 20px;
        }
        .showStartTime{
            width: 300px;height: 30px;
            margin-left: 60px;
            float: left;
            margin-top: 20px;
        }
        .showPrice{
        width: 300px;height: 30px;
            margin-left: 400px;
            margin-top: 20px;
        }
        .showEndTime{
            width: 300px;height: 30px;
            margin-left: 400px;
             margin-top: 20px;
        }
        .fanhui{
            position: relative;
            left: 700px;
            top: -180px;
        }
        .addPassenger{
            width: 200px;height: 35px;
            position: absolute;
            left: 100px;
            font-size: 20px;
            letter-spacing: 10px;
            margin-top: 20px;
        }
        .passengerType {
            margin-top: 20px;
			margin-left: 60px;
        }
        label {
           padding-top: 50px;
            margin-right: 50px;
        }
        .seatGrade{
            margin-top: 15px;
            margin-left: 60px;
        }
        .passengerType input{
            margin-right: 20px;
        }
        .name{
            margin-left: 60px;
            margin-top: 20px;
        }
        .idcard{
            margin-left: 60px;
            margin-top: 20px;
        }
        .phone{
            margin-left: 60px;
            margin-top: 20px;
        }

        .buyTicket{
            width: 200px;height: 35px;
            position: absolute;
            left: 400px;
            font-size: 20px;
            letter-spacing: 10px;
            margin-top: 20px;
        }
        .close{

            position: absolute;
            left: 700px;
            top: 20px;
        }
               
        .chengren{
            width: 50px;
            height: 30px;
            position: absolute;
            left: 155px;
            top: 75px;
        }
        .ertong{
            width: 50px;
            height: 30px;
            position: absolute;
            left: 242px;
            top: 75px;
        }
        .seatGrade label{
            margin-right: 67px;
        }
        .jj{
            width: 50px;
            height: 30px;
            position: absolute;
           left:155px;
            top: 108px;
            margin-right: 10px;
        }
        .sw{
            width: 50px;
            height: 30px;
            position: absolute;
            left:240px;
            top: 108px;
            margin-right: 10px;
        }
        .td{
            width: 50px;
            height: 30px;
            position: absolute;
            left:325px;
            top: 108px;
            margin-right: 10px;
        }
        .seat{
          width:170px;
        }
    </style>
</head>
<body>
<form action="/airsys/sales/buy">
		<input Type="hidden" name="sid" value=<%=session.getAttribute("sid")%>>
		<input Type="hidden" name="planId" value=${planId }>
    <div class="showTicket">
        <h2>机票信息</h2>
        <div class="showFnumber">
            航&nbsp;&nbsp;班&nbsp;&nbsp;号：<input name="fnumber" type="text" value=${fnumber }>
        </div>
          <div class="showPrice">
            价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：<input name="price" type="text" value=${price }>
        </div>
        <div class="showStart">
            出发城市：<input type="text" name="from" value=${from }>
        </div>
        <div class="showEnd">
            到达城市：<input type="text" name="to" value=${to }>
        </div>
        <div class="showStartTime">
            起飞时间：<input type="text" name="starttime" value="2019-11-05 19:20:02">
        </div>
        <div class="showEndTime">
            到达时间：<input type="text" name="endtime" value="2019-11-05 00:12:18">
        </div>
        <a><button class="fanhui">返回</button></a>
    </div>

    <div class="passenger">
          <div class="info-top">乘客信息</div>
        <div class="passengerType">
            乘客类型：
            <label><input name="people" class="one" type="radio" value="one" checked/><div class="chengren">成人</div></label>
            <label><input name="people" class="two" type="radio" value="two" /><div class="ertong">儿童</div></label>
        </div>
        <div class="seatGrade">
            座位等级：
            <!-- <label> <input type="radio"  name="grade" value="first_class_remain_seats" checked><div class="jj">经济舱</div></label>
            <label> <input type="radio"  name="grade" value="business_class_remain_seats" ><div class="sw">商务舱</div></label>
            <label>  <input type="radio"  name="grade" value="economy_class_remain_seats" ><div class="td">头等舱</div></label> -->
       <select name="grade" class="seat">
		  <option  value ="first_class_remain_seats">经济舱</option>
		  <option  value ="business_class_remain_seats">商务舱</option>
		  <option  value="economy_class_remain_seats">头等舱</option>
		</select>
       
       
        </div> 
        <div class="name">
            姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="name" required placeholder="请输入姓名">
        </div>
        <div class="idcard">
            证件号码：<input type="text" required name="idcard" placeholder="请输入身份证号">
        </div>
        <div class="phone">
            联系方式：<input type="text" required name="phone"  placeholder="请输入联系方式">
        </div>
        <button class="addPassenger">添加乘客</button>
      <button class="layui-btn buyTicket" lay-submit lay-filter="formDemo">立即购票</button>
        <a><button class="close">关闭</button></a>

    </div>
    
    </form>
</body>
</html>