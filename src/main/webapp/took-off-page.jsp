<%@page import="br.edu.ifsp.dsw1.model.observer.TotemData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	var totens = (List<TotemData>) request.getAttribute("took-off-totens");

	if (totens == null) {
		response.sendRedirect("application.do?action=took-off-page");	
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="includes/head_links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">
	
	<jsp:include page="includes/navbar.jsp" />
	
	<div class="flex flex-col items-center rounded-lg w-5/6 bg-white self-center p-10 mt-5 shadow-lg">
	    <h1 class="font-bold text-4xl text-center mb-10 text-black">Dados dos Voos</h1>
	
	    <table class="w-full text-sm text-left border-collapse">
	        <thead>
	            <tr>
	                <th class="table-header table-header-rounded-left">Número do Voo</th>
	                <th class="table-header">Nome da Companhia</th>
	                <th class="table-header">Data de Chegada</th>
	                <th class="table-header table-header-rounded-right">Status</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<% if (totens != null && !totens.isEmpty()) { %>
	        		<% for (var totem : totens) { %>
	            <tr class="table-row">
	                <td class="table-cell"><%= totem.getFlightNumber() %></td>
	                <td class="table-cell"><%= totem.getCompany() %></td>
	                <td class="table-cell"><%= totem.getTime() %></td>
	                <td class="table-cell table-cell-highlight">Took Off</td>
	            </tr>
	            	<% } %>
	            <% } %>
	        </tbody>
	    </table>
	</div>
	
</body>
</html>