
<%@ page trimDirectiveWhitespaces="true" %>
<%
if(!"yes".equals(session.getAttribute("login"))){
	/* response.sendRedirect("signIn.jsp");  */
 	out.println("ok"); 
}
%>