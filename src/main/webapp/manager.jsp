<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 	
	var isAuthorized = session.getAttribute("authenticate");
	
	if (isAuthorized == null) {
		response.sendRedirect("application.do?action=login-page");
		return;
	}

	var flights = (List<FlightData>) request.getAttribute("flights");
	
	if (flights == null) {
		response.sendRedirect("application.do?action=admin-page");
		return;
	}
%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="includes/head_links.html"/>
<title>Página do Admin</title>
</head>
<body class="page-config">
	
	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="container-table">
	    <h1 class="titlle-table">Dados dos Voos</h1>
	
	    <a href="application.do?action=flight-register-page" class="add-button">
	        <span class="material-symbols-outlined text-white font-bold">add</span>
	    </a>
	
	    <table class="table-container">
	        <thead>
	            <tr>
	                <th class="table-header table-header-rounded-left">Número do Voo</th>
	                <th class="table-header">Nome da Companhia</th>
	                <th class="table-header">Data de Chegada</th>
	                <th class="table-header">Status</th>
	                <th class="table-header table-header-rounded-right">Atualização</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<% if (flights != null && !flights.isEmpty()) {%>
	        		<% for (var flight : flights) {%>
	            <tr class="table-row">
	                <td class="table-cell"><%= flight.getFlightNumber() %></td>
	                <td class="table-cell"><%= flight.getCompany() %></td>
	                <td class="table-cell"><%= flight.getTime() %></td>
	                <td class="table-cell table-cell-highlight"><%= flight.getState().getClass().getSimpleName() %></td>
	                <td class="table-cell">
		                <a href="application.do?action=update&flight_number=<%=flight.getFlightNumber()%>">
		                	<button class="button-primary">Atualizar</button>
		                </a>  
	                </td>
	            </tr>
	            	<% } %>
	            <% } %>
	        </tbody>
	    </table>
	</div>
	
</body>
</html>