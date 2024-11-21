<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 	
	var error = request.getAttribute("error");
%>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<jsp:include page="includes/head_links.html"/>
</head>
<body class="page-config">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="container-form mt-10 px-10 py-6">
		<h1 class="form-title">Login</h1>
		
		<% if (error != null) { %>
			<div class="error-message-form">
				Login failed. Your credentials are incorrect.
			</div>
		<% } %>
			
		<form action="application.do?action=login" method="POST" class="flex flex-col">
			<div class="input-container">
				<span class="material-icons text-gray-500">person</span>
				<input class="input-style py-5" type="text" name="username" placeholder="Username" required/>
			</div>
			
			<div class="input-container">
				<span class="material-icons text-gray-500">lock</span>
				<input class="input-style py-5" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<input class="button-form" type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>