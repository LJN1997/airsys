<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="entity.UserSelect" %>
<html>
<body>
<c:forEach items="${usts}" var="list">
${list.fnumber}
${list.tprice}
${list.departureTime}
${list.arrivalTime}
</c:forEach>
</body>
</html>