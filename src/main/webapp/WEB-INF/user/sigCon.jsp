<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
String uphone = request.getParameter("uphone").replace("[\"\'--]","");
String upwd = request.getParameter("upwd");
String role = request.getParameter("role");
%>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/airsys?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
<sql:query dataSource="${snapshot}" var="result">
select * from airsys_user where uphone = "<%=uphone %>" and upwd="<%=upwd %>";

</sql:query>


<c:forEach var="row" items="${result.rows}">

<c:out value="${row.id}"/>
<c:set var="id" value ="${row.id}">
</c:set> 
</c:forEach>
<c:if test="${result.rowCount>0}">
<%
session.setAttribute("login","yes");
session.setAttribute("username",uphone);
session.setAttribute("uid",pageContext.getAttribute("uid"));
session.setAttribute("role",role);
%>
<c:redirect url="index.jsp">
	</c:redirect>

</c:if>
 <c:if test="${result.rowCount==0}">
<c:redirect url="signIn.jsp">
	</c:redirect>
</c:if>