package datos;

import dominio.Posicion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PosicionDao {

	private static final String SQL_SELECT_POSICION = "select * from tb_posicion";

	public List<Posicion> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Posicion> posicion = new ArrayList<Posicion>();

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_POSICION);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int cod_posicion = rs.getInt("cod_posicion");
				String nom_posicion = rs.getString("nom_posicion");
				posicion.add(new Posicion(cod_posicion, nom_posicion));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(rs);
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return posicion;

	}

}
