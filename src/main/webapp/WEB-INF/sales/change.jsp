<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% response.setContentType("text/html;charset=utf-8"); %>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>退票</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<link rel="stylesheet" href="/airsys/assets/css/sales.css">
<style type="text/css">
body {
	margin: 0;
	padding: 0
}

.del {
	width: 400px;
	height: 250px;
	border: 2px solid rgb(144, 144, 144, 0.8);
	margin-left: 50px;
	margin-top: 30px;
}

.select {
	font-size: 25px;
	margin-left: 20px;
	margin-top: 10px;
	margin-bottom: 30px;
}

.del-con {
	width: 1000px;
	height: 180px;
	margin-top: 10px;
	margin-left: 50px;
	margin-top: 10px;
}
.oid{
 display: none;
}
input{
width:250px;height:30px;

}
</style>
</head>

<body>
        <div class="oid"></div>
		<div class="del">
			<div class="select">改签信息查询</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-block">
					<input type="text" class="oname" name="oname" required
						lay-verify="required" placeholder="请输入用户姓名" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证号</label>
				<div class="layui-input-block">
					<input type="text" class="idcard" name="idcard" required
						lay-verify="required" placeholder="请输入用户身份证号" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn selectOid" lay-submit lay-filter="formDemo">查询</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</div>
		
		<div class="del-con">
			<h2>查询信息</h2>			
			
				<table class="layui-table table" id="mytable">
					<tr>
						<th>机票ID</th>
						<th>航班号</th>
						<th>姓名</th>
						<th>电话</th>
						<th>身份证</th>
						<th>乘客类型</th>
						<th>座位等级</th>
						<th>机票价格</th>
						<th>出票日期</th>
						<th>机票状态</th>
						<th>操作</th>   
					</tr>
					<tbody class="tbody">
					</tbody>
				
				</table>


		</div>
	
	

	<script src="/airsys/assets/layui/layui.js"></script>
	<script>
		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function() {
			var element = layui.element;

			//…
		});

		//Demo
		layui.use('form', function() {
			var form = layui.form;

		});
	</script>
</body>
<script type="text/javascript" src="/airsys/assets/js/jquery-1.11.1.js"></script>
<script>
	window.onload=function(){
		
		$(".selectOid").click(function(){
			var oname=$(".oname").val();
			var idcard=$(".idcard").val();
			$(".tbody").empty();
			$.ajax({
				url:"selectOid",
				type:"post",
				dataType:"json",
				data:{
					oname:oname,
					idcard:idcard
				},
				success:function(e){
			 		 for(var i=0;i<e.length;i++){
			 			var a="";
			 			if(e[i].status==2){
							a="<td><button  >已改</button></td>";
			 			}else{
			 				a="<td><button class='changebtn' >改签</button></td>";
			 			}
			 			
			 			var tr="<tr>";
						var td = "";
						td+="<td class='tid'>"+e[i].tid+"</td>"
						td+="<td class='fnumber'>"+e[i].fnumber+"</td>"
						td+="<td class='oname'>"+e[i].oname+"</td>"
						td+="<td class='ophone'>"+e[i].ophone+"</td>"
						td+="<td class='idcard'>"+e[i].idcard+"</td>"
						td+="<td class='passengerType'>"+e[i].passengerType+"</td>"
						td+="<td class='tclass'>"+e[i].tclass+"</td>"
						td+="<td class='tprice'>"+e[i].tprice+"</td>"
						td+="<td class='tdate'>"+e[i].tdate+"</td>"
						td+="<td class='status'>"+e[i].status+"</td>"
						td+=a;
						tr+=td+"</tr>"
				        $(".tbody").append(tr)
					}  
				}
			})
		})
		
       //改签业务
		$("table").on("click",".changebtn",function(){	
			var fnumber = $(".fnumber").text();
			var tclass = $(".tclass").text();
			var tid=$(this).parent().parent().children()[0].innerText;
	        $.ajax({
				url:"changeTicket",
				type:"post",
				dataType:"text",
				data:{
					tid:tid,
					fnumber:fnumber,
					tclass:tclass
				},
				success:function(e){
					if("ok" == e){
						alert("是否确定改签?")
					}
						window.location.replace("http://localhost:8080/airsys/sales/query");
				}  
				
			})  
		})

	
	}
	
	
	
	
	</script>




</html>