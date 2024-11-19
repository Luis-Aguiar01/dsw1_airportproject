<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="includes/head_links.html"/>
<title>Página do Admin</title>
</head>
<body class="page-config">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="flex flex-col items-center rounded-lg w-5/6 bg-white self-center p-10 mt-5 shadow-lg">
	    <h1 class="font-bold text-4xl text-center mb-10 text-black">Dados dos Voos</h1>
	
	    <a href="application.do?action=flight-register-page" class="flex items-center p-3 bg-[#02111D] self-end rounded-lg p-1 mb-5 text-center hover:bg-[#061F34] cursor-pointer">
	        <span class="material-symbols-outlined text-white font-bold">add</span>
	    </a>
	
	    <table class="w-full text-sm text-left border-collapse">
	        <thead>
	            <tr>
	                <th class="table-header table-header-rounded-left">Número do Voo</th>
	                <th class="table-header">Nome da Companhia</th>
	                <th class="table-header">Data de Saída</th>
	                <th class="table-header">Status</th>
	                <th class="table-header table-header-rounded-right">Atualização</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr class="table-row">
	                <td class="table-cell">LH 191</td>
	                <td class="table-cell">Lufthansa</td>
	                <td class="table-cell">17/11/2024 18:00:00</td>
	                <td class="table-cell table-cell-highlight">Decolando</td>
	                <td class="table-cell">
		                <a href="#">
		                	<button class="button-primary">Atualizar</button>
		                </a>  
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</div>
</body>
</html>