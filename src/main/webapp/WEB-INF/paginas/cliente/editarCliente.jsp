<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/3556f97ea7.js"
	crossorigin="anonymous"></script>


<title>EDITAR EQUIPOS</title>
</head>
<body>
	<jsp:include page="../comunes/cabecero.jsp" />

	<form
		action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&cod_jugador=${jugador.cod_jugador}"
		method="POST" class="was-validated">
		<jsp:include page="../comunes/botonesNavegacionEdicion.jsp" />
		<section id="details">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Editar Jugador</h4>
							</div>
							<div class="card-body">
					<div class="form-group">
						<label for="Pais">Club</label> 
						<select class="form-select"
							name="cod_club" aria-label="Default select example">
							<c:forEach var="clubs" items="${club}" varStatus="status">
>								<option value="${clubs.cod_club}">${clubs.nombre_club}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="Pais">Posicion</label>
						<select class="form-select"
							name="cod_posicion" aria-label="Default select example">
							<c:forEach var="posicions" items="${posicion}" varStatus="status">
>								<option value="${posicions.cod_posicion}">${posicions.nom_posicion}</option>
							</c:forEach>
						</select>
					</div>
								<div class="form-group">
									<label for="nombre_jugador">Nombre Jugador</label> <input type="text"
										class="form-control" name="nombre_jugador" required
										value="${jugador.nombre_jugador}">
								</div>
								<div class="form-group">
									<label for="ape_jugador">Apellido Jugador</label> <input type="text"
										class="form-control" name="ape_jugador" required
										value="${jugador.ape_juegador}">
								</div>
								<!-- comment -->
								<div class="form-group">
									<label for="dni_jugador">N° de Documento de Identidad</label> <input type="text"
										class="form-control" name="dni_jugador" required
										value="${jugador.dni_jugador}">
								</div>
								<div class="form-group">
									<label for="sueldo">Sueldo</label> <input type="text"
										class="form-control" name="sueldo" required
										value="${jugador.sueldo}">
								</div>
							</div>
							<!-- comment -->
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>

</body>
</html>
