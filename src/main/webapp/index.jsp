<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	session.invalidate();
	var error = request.getAttribute("error"); 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="includes/head_links.html"/>
<title>Login Page</title>
</head>
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">

	<jsp:include page="includes/navbar.jsp"/>
	
	<div class="flex flex-col px-10 py-8 w-1/2 bg-white self-center mt-10">
		<h1 class="self-center font-bold text-3xl mb-10">Login</h1>
		
		<% if (error != null) { %>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
				Login failed. Your credentials are incorrect.
			</div>
		<% } %>
			
		<form action="login.do" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="username" placeholder="Username" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">lock</span>
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<input class="text-lg mt-2 bg-black py-3 self-center w-1/3 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold" type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>