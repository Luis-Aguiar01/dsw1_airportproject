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
<style> 
	.bg-blackk {
	    background-color: #010B13;
	}
	.bg-item-list {
		background-color: #b3dbdb;
	}
	.bg-button {
		background-color: #3B00DB;
	}
</style>
</head>
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800 border-box">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="flex flex-col items-center rounded-lg w-5/6 bg-white self-center p-10 mt-5">
		<h1 class="font-bold text-4xl text-center mb-10 text-black ">Dados dos Voos</h1>
	
		<table class="w-full">
			<thead>
				<tr>
					<th class="p-5 bg-blackk text-white border-2 border-white text-lg text-center font-bold">Número do Voo</th>
					<th class="p-5 bg-blackk text-white border-2 border-white text-lg text-center font-bold">Nome da Companhia</th>
					<th class="p-5 bg-blackk text-white border-2 border-white text-lg text-center font-bold">Data de Saída</th>
					<th class="p-5 bg-blackk text-white border-2 border-white text-lg text-center font-bold">Status</th>
					<th class="p-5 bg-blackk text-white border-2 border-white text-lg text-center font-bold">Atualização</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="p-5 text-black text-lg bg-item-list border-2 border-white text-center">LH 191</td>
					<td class="p-5 text-black text-lg bg-item-list border-2 border-white text-center">Lufthansa</td>
					<td class="p-5 text-black text-lg bg-item-list border-2 border-white text-center">17/11/2024 18:00:00</td>
					<td class="p-5 text-black text-lg bg-item-list border-2 border-white text-center">Decolando</td>
					<td class="p-5 text-white text-lg bg-item-list border-2 border-white text-center">
						<a href="history.do" class="bg-button py-2 px-2 text-center rounded-lg hover:bg-blue-600 cursor-pointer font-bold">
							<button>Atualizar</button>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
</html>