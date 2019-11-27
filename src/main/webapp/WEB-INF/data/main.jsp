<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="util.Pager,entity.Info,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main" style="width: 700px; height: 500px; margin: auto"></div>
</body>
<script type="text/javascript" src="/airsys/assets/js/echarts.min.js"></script>
<script type="text/javascript" src="/airsys/assets/js/jquery.js"></script>
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main'));
	
	$.ajax({
		url : "/airsys/data/datainfo",
		type : "post",
		dataType : "json",
		success : function(e) {
			var pname = e.pname;
			var count = e.count;
			var allPrice = e.allPrice;
			option = {
				title : {
					text : '营业点业绩',
				},
				tooltip : {
					trigger : 'axis',
					axisPointer : {
						type : 'shadow'
					}
				},
				legend : {
					data : [ '售票数量', '售票金额' ]
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				xAxis : {
					type : 'value',
					boundaryGap : [ 0, 0.01 ]
				},
				yAxis : {
					type : 'category',
					data : pname
				},
				series : [ {
					name : '售票数量',
					type : 'bar',
					data : count
				}, {
					name : '售票金额',
					type : 'bar',
					data : allPrice
				} ]
			};

	myChart.setOption(option);
		}
	})
</script>
</html>