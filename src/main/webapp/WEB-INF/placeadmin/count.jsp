<%@ page language="java" contentType="text/html; charset=utf-8"
	import="util.*,entity.*,java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>业绩统计</title>
<!-- 引入 lib/echarts.custom.min.js -->
<script src="/airsys/assets/js/echarts.min.js"></script>
<script src="/airsys/assets/js/china.js"></script>
<script src="/airsys/assets/js/jquery-2.2.4.min.js"></script>


</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	
	
	<input type="hidden" value="${panumber}">
	<div id="main"
		style="width: 600px; height: 400px; margin: auto; margin-top: 100px; border: 1px solid gray;"></div>
	<script type="text/javascript">
		

		var pnumber=$("input").val();
		
		$.ajax({
			url : "http://localhost:8080/airsys/placeadmin/csums/"+pnumber,
			dataType : "json",
			type:"GET",
			success : function(e) {
				
				// 基于准备好的dom，初始化echarts实例
				var myChart = echarts.init(document.getElementById('main'));

				var builderJson = {
					"all" : e.sum,
				
					  "charts" :JSON.parse(e.charts),
						
						
				};

				var downloadJson =JSON.parse(e.downloadJson);

				var themeJson =JSON.parse(e.themeJson);

				var waterMarkText = '';
				var canvas = document.createElement('canvas');
				var ctx = canvas.getContext('2d');
				canvas.width = canvas.height = 100;
				ctx.textAlign = 'center';
				ctx.textBaseline = 'middle';
				ctx.globalAlpha = 0.08;
				ctx.font = '20px Microsoft Yahei';
				ctx.translate(50, 50);
				ctx.rotate(-Math.PI / 4);
				ctx.fillText(waterMarkText, 0, 0);

				option = {
					backgroundColor : {
						type : 'pattern',
						image : canvas,
						repeat : 'repeat'
					},
					tooltip : {},
					title : [ {
						text : '营业员业绩',
						subtext : '总计 ' + builderJson.all,
						x : '25%',
						textAlign : 'center'
					}, {
						text : '舱位',

						x : '75%',
						textAlign : 'center'
					}, {
						text : '乘客类型',

						x : '75%',
						y : '50%',
						textAlign : 'center'
					} ],
					grid : [ {
						top : 50,
						width : '50%',
						bottom : '10%',
						left : 10,
						containLabel : true
					}, {
						top : '0',
						width : '0',
						bottom : 0,
						left : 0,
						containLabel : false
					} ],
					xAxis : [ {
						type : 'value',
						splitLine : {
							show : false
						}
					}, {
						type : 'value',
						gridIndex : 1,
						splitLine : {
							show : false
						}
					} ],
					yAxis : [ {
						type : 'category',
						data : Object.keys(builderJson.charts),
						axisLabel : {
							interval : 0,
							rotate : 30
						},
						splitLine : {
							show : false
						}
					}, {
						gridIndex : 1,
						type : 'category',
						axisLabel : {
							interval : 0,
							rotate : 30
						},
						splitLine : {
							show : false
						}
					} ],
					series : [ {
						type : 'bar',
						stack : 'chart',
						z : 3,
						label : {
							normal : {
								position : 'right',
								show : true
							}
						},
						data : Object.keys(builderJson.charts).map(function(key) {
							return builderJson.charts[key];
						})
					}, {
						type : 'bar',
						stack : 'chart',
						silent : true,
						itemStyle : {
							normal : {
								color : '#eee'
							}
						},
						data : Object.keys(builderJson.charts).map(function(key) {
							return builderJson.all - builderJson.charts[key];
						})
					}, {
						type : 'pie',
						radius : [ 0, '30%' ],
						center : [ '75%', '25%' ],
						data : Object.keys(downloadJson).map(function(key) {
							return {
								name : key.replace('.js', ''),
								value : downloadJson[key]
							}
						})
					}, {
						type : 'pie',
						radius : [ 0, '30%' ],
						center : [ '75%', '75%' ],
						data : Object.keys(themeJson).map(function(key) {
							return {
								name : key.replace('.js', ''),
								value : themeJson[key]
							}
						})
					} ]
				}

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			}
		})
		

		
	</script>
</html>