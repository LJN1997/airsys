<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
String uphone = request.getParameter("uphone");
String password = request.getParameter("upwd");
%>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/airsys?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
<sql:update dataSource="${snapshot}" var="result">
insert into airsys_user(uphone,upwd) values("<%=uphone %>","<%=password %>");
</sql:update>
<c:redirect url="signIn.jsp"></c:redirect> 