<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="includes/head_links.html"/>
<title>Cadastro de Voos</title>
</head>
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="flex flex-col px-10 py-8 w-1/2 bg-white self-center mt-5">
		<h1 class="self-center font-bold text-3xl mb-10">Cadastro de Voo</h1>
		<form action="application.do?action=flight-register" method="POST" class="flex flex-col">
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