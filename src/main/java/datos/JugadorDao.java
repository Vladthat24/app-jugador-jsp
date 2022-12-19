package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import dominio.Jugador;

public class JugadorDao {

	private static final String SQL_SELECT_BY_ID = "select * from tb_jugador where cod_jugador=?";
	private static final String SQL_SELECT_JUGADOR="select * from tb_jugador";
	private static final String SQL_INSERT = "insert into tb_jugador (nombre_jugador,ape_jugador,dni_jugador,sueldo,cod_club,cod_posicion) values(?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE tb_jugador SET nombre_jugador=?,ape_jugador=?,dni_jugador=?,sueldo=?,cod_club=?,cod_posicion=? WHERE cod_jugador=?";
	private static final String SQL_DELETE = "DELETE FROM tb_jugador WHERE cod_jugador=?";

	public List<Object[]> listar() {
		List<Object[]> jugador = null;
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ").append("j.cod_jugador,").append("j.nombre_jugador,").append("j.ape_jugador,")
				.append("j.dni_jugador,").append("j.sueldo,").append("tc.nombre_club,").append("tp.nom_posicion")
				.append(" FROM tb_jugador j")
				.append(" inner join tb_club tc on j.cod_club =tc.cod_club inner join tb_posicion tp on j.cod_posicion = tp.cod_posicion");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		jugador = new ArrayList<>();

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object[] ju = new Object[7];

				ju[0] = rs.getInt(1);
				ju[1] = rs.getString(2);
				ju[2] = rs.getString(3);
				ju[3] = rs.getString(4);
				ju[4] = rs.getString(5);
				ju[5] = rs.getString(6);
				ju[6] = rs.getString(7);

				jugador.add(ju);
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(rs);
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}

		return jugador;
	}
	
	 public List<Jugador> listarDao(){
	     Connection conn=null;
	     PreparedStatement stmt=null;
	     ResultSet rs=null;
	     List<Jugador> jugador= new ArrayList<Jugador>();
	     
	     try {
	         conn=Conexion.getConnection();
	         stmt=conn.prepareStatement(SQL_SELECT_JUGADOR);
	         rs=stmt.executeQuery();
	         while (rs.next()) {             
	             int cod_jugador=rs.getInt("cod_jugador");
	             String nombre=rs.getString("nombre_jugador");
	             String apellido=rs.getString("ape_jugador");
	             String email=rs.getString("dni_jugador");
	             Double sueldo=rs.getDouble("sueldo");
	             int cod_club=rs.getInt("cod_club");
	             int cod_posicionr=rs.getInt("cod_posicion");
	             System.out.println(nombre+" "+apellido+" "+email);
	             
	             jugador.add(new Jugador(cod_jugador, nombre, email, cod_jugador, sueldo, cod_club, cod_posicionr));
	         }
	         
	     } catch (Exception e) {
	         e.printStackTrace(System.out);
	     }finally{
	         Conexion.Close(rs);
	         Conexion.Close(stmt);
	         Conexion.Close(conn);
	                 
	     }
	     
	     return jugador;
	 }

	public Jugador buscar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, jugador.getCod_jugador());
			rs = stmt.executeQuery();
			rs.next();
			int cod_jugador = rs.getInt("cod_jugador");
			String nombre_jugador = rs.getString("nombre_jugador");
			String ape_jugador = rs.getString("ape_jugador");
			int dni_jugador = rs.getInt("dni_jugador");
			Double sueldo = rs.getDouble("sueldo");
			int cod_club = rs.getInt("cod_club");
			int cod_posicion = rs.getInt("cod_posicion");

			jugador.setCod_club(cod_jugador);
			jugador.setNombre_jugador(nombre_jugador);
			jugador.setApe_juegador(ape_jugador);
			jugador.setDni_jugador(dni_jugador);
			jugador.setSueldo(sueldo);
			jugador.setCod_club(cod_club);
			jugador.setCod_posicion(cod_posicion);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(rs);
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}

		return jugador;

	}

	public int insertar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, jugador.getNombre_jugador());
			stmt.setString(2, jugador.getApe_juegador());
			stmt.setInt(3, jugador.getDni_jugador());
			stmt.setDouble(4, jugador.getSueldo());
			stmt.setInt(5, jugador.getCod_club());
			stmt.setInt(6, jugador.getCod_posicion());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return rows;
	}
	public int actualizar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setInt(1, jugador.getCod_club());
			stmt.setInt(2, jugador.getCod_posicion());
			stmt.setString(3, jugador.getNombre_jugador());
			stmt.setString(4, jugador.getApe_juegador());
			stmt.setInt(5, jugador.getDni_jugador());
			stmt.setDouble(6, jugador.getSueldo());
			stmt.setInt(7, jugador.getCod_jugador());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return rows;
	}

	public int eliminar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, jugador.getCod_jugador());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(stmt);
			Conexion.Close(conn);

		}
		return rows;
	}

	public static void main(String[] args) {
		JugadorDao jugador = new JugadorDao();
		jugador.listar();
	}

}
