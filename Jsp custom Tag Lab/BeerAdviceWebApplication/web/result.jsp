<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beer Selection Advice</title>
</head>
<body>
	<h1 align="center">Beer Recommendations JSP</h1>
	
	<!-- Using JSP scripting.... -->
	<p>Using JSP scripting....</p>
	<p>
		<%
			 List styles = (List)request.getAttribute("manish");
			 Iterator it = styles.iterator();
			 while(it.hasNext()) {
			 	out.print("<br>try: " + it.next());
			 }
		%>
	</p>
	
	<!-- Using JSTL.... -->
	
	<p>Using JSTL....</p>
	<p>
		<c:forEach var="each" items="${manish}">
			<br />try: ${each}
		</c:forEach>
	</p>
	
</body>
</html>