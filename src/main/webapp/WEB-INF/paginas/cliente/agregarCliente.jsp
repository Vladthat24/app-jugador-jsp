<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="modal fade" id="agregarClienteModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Jugador</h5>
				<button clase="clse" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>

			<form
				action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
				method="POST" class="was-validated">
				<div class="modal-body">

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
						<label for="nombre_jugador">Nombre de Jugador</label> <input type="text"
							class="form-control" name="nombre_jugador" required>
					</div>
					<div class="form-group">
						<label for="ape_jugador">Apellido de Jugador</label> <input type="text"
							class="form-control" name="ape_jugador" required>
					</div>
					<!-- comment -->
					<div class="form-group">
						<label for="dni_jugador">N° de Documento de Identidad</label> <input type="text"
							class="form-control" name="dni_jugador" required>
					</div>
					<div class="form-group">
						<label for="sueldo">Sueldo</label> <input type="text"
							class="form-control" name="sueldo" required>
					</div>

				</div>
				<div class="modal-footer">
					<button class="btn-primary" type="submit">Guardar Equipo</button>

				</div>

			</form>

		</div>
	</div>

</div>