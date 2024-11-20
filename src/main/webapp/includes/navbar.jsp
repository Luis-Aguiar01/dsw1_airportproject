<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%  
	var isLogged = (Boolean) session.getAttribute("authenticate");
%>
    
<header class="flex p-6 items-center">
	<div class="flex items-center text-white justify-around w-full">
		
		<a href="index.jsp" class="link-header-style">
			<span class="material-icons text-2xl">home</span>
			<span>Home</span>
		</a>
		
		<% if (isLogged != null) { %>
		
		<a href="manager.jsp" class="link-header-style">
			<span class="material-symbols-outlined">lock_open</span>
			<span>Administração</span>
		</a>
		
		<% } %>
		
		<a href="boarding-page.jsp" class="link-header-style">
			<span class="material-icons text-2xl">flight_takeoff</span>
			<span>Embarque</span>
		</a>
		
		<a href="arriving-page.jsp" class="link-header-style">
			<span class="material-icons text-2xl">flight_land</span>
			<span>Desembarque</span>
		</a>
		
		<a href="taking-off-page.jsp" class="link-header-style">
			<span class="material-icons text-2xl">airplanemode_active</span>
			<span>Hall 1</span>
		</a>
		
		<a href="took-off-page.jsp" class="link-header-style">
			<span class="material-icons text-2xl">check_circle</span>
			<span>Hall 2</span>
		</a>
		
		<% if (isLogged != null) { %>
		
		<a href="application.do?action=logout" class="bg-red-700 py-4 px-4 hover:bg-red-500 font-bold rounded-lg">
			<button>Logout</button>
		</a>
		
		<% } else { %>
		
		<a href="application.do?action=login-page" class="bg-[#0070FF] py-3 px-5 hover:bg-[#589EFA] font-bold rounded-lg">
			<button>Login</button>
		</a>
		
		<% } %>
	</div>
</header>