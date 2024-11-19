<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	var isAuthorized = session.getAttribute("authenticate");

	if (isAuthorized == null) {
		response.sendRedirect("application.do?action=login-page");
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
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="flex flex-col px-10 py-8 w-1/2 bg-white self-center mt-3">
		<h1 class="self-center font-bold text-3xl mb-5">Cadastro de Voo</h1>
		
		<% if (numberUnavailable != null) { %>
			<div class="self-center justify-self-start mb-3 text-red-700 text-xl">
				Register failed. Flight number already registered.
			</div>
		<% } else if (invalidDate != null) { %>
			<div class="self-center justify-self-start mb-3 text-red-700 text-xl">
				Register failed. Please type a valid date.
			</div>
		<% } else if (sucess != null) { %>
			<div class="self-center justify-self-star mb-3 text-green-500 text-xl">
				Flight registered successfully.
			</div>	
		<% } %>
		
		<form action="application.do?action=flight-register-data" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="number" name="flight_number" placeholder="Número do Voo" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="company_name" placeholder="Nome da Companhia Aérea" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="datetime-local" name="arriving_time" placeholder="Horário de Chegada" required/>
			</div>
			
			<input class="text-lg mt-2 bg-black py-3 self-center w-1/3 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold" type="submit" value="Enviar">
		</form>
	</div>
	
</body>
</html>