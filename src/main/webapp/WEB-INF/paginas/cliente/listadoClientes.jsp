<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX" />

<section id="clientes">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h4>Listado de Jugadores</h4>
					</div>


					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>Nombre Jugador</th>
								<th>Apellido Jugador</th>
								<th>N° Documento de Identidad</th>
								<th>Sueldo</th>
								<th>Nombre del Club</th>
								<th>Posicion</th>
								<th></th>
							</tr>

						</thead>
						<tbody>
							<c:forEach var="jugadores" items="${jugador}" varStatus="status">
								<tr>
									<td>${jugadores[0]}</td>
									<td>${jugadores[1]}</td>
									<td>${jugadores[2]}</td>
									<td>${jugadores[3]}</td>
									<td>${jugadores[4]}</td>
									<td>${jugadores[5]}</td>
									<td>${jugadores[6]}</td>
									<td><a
										href="${pageContext.request.contextPath}/ServletControlador?accion=editar&cod_jugador=${jugadores[0]}"
										class="btn btn-secondary"> <i
											class="fas fa-angle-double-right"></i> Editar

									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>


			</div>
			<!-- Totales -->
			<div class="col-md-3">
				<div class="card text-center bg-danger text-white mb-3">
					<div class="card-body">
						<h3>Total de Sueldo de los Delanteros:</h3>
						<h4 class="display-4">
							<fmt:formatNumber value="${sueldoDelanteros}" type="currency" />
						</h4>
					</div>
				</div>

				<div class="card text-center bg-success text-white mb-3">
					<div class="card-body">
						<h3>Total de Jugadores en la posicion de Delanterio</h3>
						<h4 class="display-4">
							<i class="fas fa-user"></i> ${cantDelanterios}
						</h4>
					</div>
				</div>
			</div>


		</div>
	</div>
	</div>


</section>
<jsp:include page="agregarCliente.jsp" />