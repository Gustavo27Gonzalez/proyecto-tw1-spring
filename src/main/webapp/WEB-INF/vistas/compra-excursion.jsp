<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
<title>CODERMIX | Comprar</title>
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

	<div>
		<a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
	</div>
	<div>
		<h1 class="font-weight-bold">CODERMIX</h1>
	</div>

	<!-- ----------------------------------------------------------------------------------- -->
	<div class="d-flex justify-content-center">

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-default">Ingrese
					Número de Tarjeta</span>
			</div>
			<input type="text" class="form-control" aria-label="Default"
				aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-info"
				href="comprar-excursion" role="button">Comprar</a>
		</div>

	</div>

	<!-- ----------------------------------------------------------------------------------- -->

	<div class="d-flex justify-content-center flex-wrap"
		style="margin-top: 5rem;"></div>

</body>
</html>