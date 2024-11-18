<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%  
	var isLogged = (Boolean) session.getAttribute("authenticate");
%>
    
<header class="flex p-6 items-center">
	<div class="flex items-center text-white justify-around w-full">
		
		<a href="index.jsp" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
			<span class="material-icons text-2xl">home</span>
			<span>Home</span>
		</a>
		
		<a href="#" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
			<span class="material-icons text-2xl">flight_takeoff</span>
			<span>Embarque</span>
		</a>
		
		<a href="#" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
			<span class="material-icons text-2xl">flight_land</span>
			<span>Desembarque</span>
		</a>
		
		<a href="#" class="flex  items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
			<span class="material-icons text-2xl">airline_seat_recline_normal</span>
			<span>Embarcando</span>
		</a>
		
		<a href="#" class="flex  items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
		    <span class="material-symbols-outlined text-2xl">travel</span>
		    <span >Voos Gerais</span>
		</a>
		
		<% if (isLogged != null) { %>
		
		<a href="application.do?action=logout" class="bg-red-700 py-4 px-4 text-center rounded-lg hover:bg-red-500 cursor-pointer font-bold">
			<button>Logout</button>
		</a>
		
		<% } else { %>
		
		<a href="application.do?action=login-page" class="bg-[#0070FF] py-3 px-5 text-center rounded-lg hover:bg-[#589EFA] cursor-pointer font-bold">
			<button>Login</button>
		</a>
		
		<% } %>
	</div>
</header>