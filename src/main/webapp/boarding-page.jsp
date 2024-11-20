<%@page import="br.edu.ifsp.dsw1.model.observer.TotemData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	var totens = (List<TotemData>) request.getAttribute("boarding-totens");

	if (totens == null) {
		response.sendRedirect("application.do?action=boarding-page");
		return;
	}
%>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="includes/head_links.html" />
</head>
<body class="page-config">

	<jsp:include page="includes/navbar.jsp" />
	
	<div class="container-table">
	    <h1 class="titlle-table">Dados dos Voos</h1>
	
	    <table class="table-container">
	        <jsp:include page="includes/table-header.html"/>
	        <tbody>
	        	<% if (totens != null && !totens.isEmpty()) { %>
	        		<% for (var totem : totens) { %>
	            <tr class="table-row">
	                <td class="table-cell"><%= totem.getFlightNumber() %></td>
	                <td class="table-cell"><%= totem.getCompany() %></td>
	                <td class="table-cell"><%= totem.getTime() %></td>
	                <td class="table-cell table-cell-highlight">Boarding</td>
	            </tr>
	            	<% } %>
	            <% } %>
	        </tbody>
	    </table>
	</div>
	
</body>
</html>