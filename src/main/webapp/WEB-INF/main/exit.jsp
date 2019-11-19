<%@ page trimDirectiveWhitespaces="true" %>
<%
/*  session.removeAttribute("JSESSIONID");
 response.sendRedirect("signIn.jsp");   */
/* out.print("ok"); */
session.invalidate();
out.println("ok"); 
%>