<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body class="flex flex-col min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">

	<header class="flex p-6 items-center">
		<div class="flex items-center text-white justify-around w-full">
			
			<a href="#" class="flex ml-10 items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
				<span class="material-icons text-2xl">home</span>
				<span>Home</span>
			</a>
			
			<a href="#" class="flex ml-10 items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
				<span class="material-icons text-2xl">flight_takeoff</span>
				<span>Sala de Embarque</span>
			</a>
			
			<a href="#" class="flex ml-10 items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
				<span class="material-icons text-2xl">flight_land</span>
				<span>Sala de Desembarque</span>
			</a>
			
			<a href="#" class="flex ml-10 items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
				<span class="material-icons text-2xl">airline_seat_recline_normal</span>
				<span>Embarcando</span>
			</a>
			
			<a href="#" class="flex ml-10 items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl">
			    <span class="material-symbols-outlined text-2xl">travel</span>
			    <span >Voos Gerais</span>
			</a>
			
		</div>
	</header>
	
	<div class="flex flex-col px-10 py-8 w-1/2 bg-white self-center mt-10">
		<h1 class="self-center font-bold text-3xl mb-10">Login</h1>
			
		<form action="login.do" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="username" placeholder="Username" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">lock</span>
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<p class="self-center mb-4">Don't have an account? 
				<a href="register.jsp" class="text-blue-400 font-bold cursor-pointer hover:underline">
					Click here to create account.
				</a>
			</p>
			
			<input class="text-lg mt-2 bg-black py-3 self-center w-1/3 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold" type="submit" value="Enviar">
		</form>
	</div>
	
	
</body>
</html>