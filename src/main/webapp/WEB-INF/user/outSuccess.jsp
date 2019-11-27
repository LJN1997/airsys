<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<style>
	.buy{
		width:150px;
		height:100px;
		font-size:30px;
		margin:auto;
	}
	.return{
		width:150px;
		height:100px;
		margin:auto;
	}
</style>
<body>
<div class="buy">
退票成功！
</div>
<div class="return">
<form action="/airsys/user/sigcon" method="get">
				<input type="hidden" value="1" name="status">
				<button type="submit">返回主界面</button>
			</form>
</div>
</body>
</html>