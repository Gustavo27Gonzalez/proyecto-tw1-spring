<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>CODERMIX |  Listado de Excursiones</title>
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

	</div>

	<!-- ----------------------------------------------------------------------------------- -->

	<div class="d-flex justify-content-center flex-wrap"
		style="margin-top: 5rem;">
		<c:forEach var="EXCURSION" items="${excursiones}">
				<div class="col-sm-4 mb-4 align-self-stretch ">
					<div class="card shadow-lg  bg-black">
						<div class="card-body border border-dark">
							<h3 class="card-title text-dark" style="color: #FFFFFF; text-align: center;">${EXCURSION.nombre}</h3>
							<p class="card-text text-dark" style="color: #FFFFFF">ID: ${EXCURSION.id}</p>
							<p class="card-text text-dark" style="color: #FFFFFF">Descripcion: ${EXCURSION.descripcion}</p>
							<p class="card-text text-dark" style="color: #FFFFFF">Precio: $${EXCURSION.precio}</p>
							<p class="card-text text-dark" style="color: #FFFFFF">Cupo: $${EXCURSION.cupo}</p>
							<p class="card-text text-dark" style="color: #FFFFFF">Fecha: $${EXCURSION.fecha}</p>
							<div class="d-flex justify-content-end">
								<a class="btn btn-outline-info"
								   href="seleccionar-excursion?id=${EXCURSION.id}" role="button">Comprar</a>
							</div>
						</div>
					</div>
				</div>
		</c:forEach>
	</div>

</body>
</html>