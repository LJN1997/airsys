<%@ page language="java" contentType="text/html; charset=utf-8" 
	import="util.*,java.util.*"
pageEncoding="utf-8"%>
			<c:forEach items = "${data}" var = "act">
				<div>
					<p>${act.sid}</p>111
					<p>${act.sname}</p>
				</div>
			</c:forEach>	
<p>${pageNum}</p>
<p>${sales}</p>
	