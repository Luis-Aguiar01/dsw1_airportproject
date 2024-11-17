<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	var isLogged = session.getAttribute("username"); 

	if (isLogged == null) {
		response.sendRedirect("index.jsp");
	}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="includes/head_links.html"/>
<title>Página do Admin</title>
</head>
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">
	
	<jsp:include page="includes/navbar.jsp"/>
	
</body>
</html>