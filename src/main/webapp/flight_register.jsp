<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	var isAuthorized = session.getAttribute("authenticate");

	if (isAuthorized == null) {
		response.sendRedirect("application.do?action=login-page");
		return;
	}

	var numberUnavailable = request.getAttribute("unavailable-number");
	var invalidDate = request.getAttribute("invalid-date");
	var sucess = request.getAttribute("sucessful");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="includes/head_links.html"/>
<title>Cadastro de Voos</title>
</head>
<body class="page-config">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="container-form mt-2">
		<h1 class="form-title">Cadastro de Voo</h1>
		
		<% if (numberUnavailable != null) { %>
			<div class="error-message-form">
				Register failed. Flight number already registered.
			</div>
		<% } else if (invalidDate != null) { %>
			<div class="error-message-form">
				Register failed. Please type a valid date.
			</div>
		<% } else if (sucess != null) { %>
			<div class="error-message-form">
				Flight registered successfully.
			</div>	
		<% } %>
		
		<form action="application.do?action=flight-register-data" method="POST" class="flex flex-col">
			<div class="input-container">
				<input class="input-style" type="number" name="flight_number" placeholder="Número do Voo" required/>
			</div>
			
			<div class="input-container">
				<input class="input-style" type="text" name="company_name" placeholder="Nome da Companhia Aérea" required/>
			</div>
			
			<div class="input-container">
				<input class="input-style" type="datetime-local" name="arriving_time" placeholder="Horário de Chegada" required/>
			</div>
			
			<input class="button-form" type="submit" value="Enviar">
		</form>
	</div>
	
</body>
</html>