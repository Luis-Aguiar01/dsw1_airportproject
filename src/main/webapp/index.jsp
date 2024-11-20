<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bem-vindo!</title>
<jsp:include page="includes/head_links.html" />
</head>
<body class="page-config">
  
  <jsp:include page="includes/navbar.jsp" />
  
  <div class="container-index animate-fadeIn">
	  <h1 class="font-bold text-4xl text-center mb-5 text-white">
	    Bem-vindo! <span class="text-5xl">&#128075;</span>
	  </h1>
	
	  <p class="p-text-index">
	  	Nesse site, você pode acompanhar informações sobre os voos.
	  </p>
	  
	  <p class="p-text-index">
	  	Na página <span class="font-bold text-[#007BFF]">"Embarque"</span>, você encontrará os voos que estão no estado para embarque.
	  </p>
	  
	  <p class="p-text-index">
	  	Em <span class="font-bold text-[#007BFF]">"Desembarque"</span>, estão os aviões que estão chegando para o desembarque.
	  </p>
	  
	  <p class="p-text-index">
	  	Já em <span class="font-bold text-[#007BFF]">Hall 1</span>, estão os voos que estão se preparando para decolar.
	  </p>
	  
	  <p class="p-text-index">
	  	Por fim, em <span class="font-bold text-[#007BFF]">Hall 2</span>, estão os voos que já decolaram.
	  </p>
	</div>
</body>
</html>
