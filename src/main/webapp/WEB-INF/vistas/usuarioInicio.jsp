<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Codemix | Inicio</title>
<!-- Bootstrap theme -->
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<!-------------------------------------------------------------------------->
	<div class="d-flex justify-content-end navegador">
		<nav class="navbar ">
			<form class="form-inline">
				<a class="btn btn-danger" href="login" role="button">Salir</a>
			</form>
		</nav>
	</div>
	<!-------------------------------------------------------------------------->
	
	<div class="container">
		<h1 class="font-weight-bold">CODEMIX</h1>
		<h3 class="font-weight-light">Inserte Nombre de la App</h3>
	</div>

	<!-------------------------------------------------------------------------->
	
	<div class="d-flex justify-content-center align-items-center" style="margin-top: 5rem;">

		<div class="col-sm-4 mb-4 align-self-stretch">
			<a href="listado-excursiones" role="button">
				<div class="card-counter primary">
					<i class="fa fa-users"></i>
					<span class="count-numbers">Listar Excursiones</span>
					<span class="count-name">Ver Excursiones Activas</span>
				</div>
			</a>
		</div>	
		
		
	</div>
	<!-------------------------------------------------------------------------->


</body>
</html>