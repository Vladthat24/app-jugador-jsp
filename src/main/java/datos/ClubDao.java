package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dominio.Club;

public class ClubDao {
	
	private static final String SQL_SELECT_CLUB="select * from tb_club";
	
	public List<Club> listar(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Club> club=new ArrayList<Club>();
		
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SQL_SELECT_CLUB);
			rs=stmt.executeQuery();
			while(rs.next()) {
				int cod_club=rs.getInt("cod_club");
				String nombre_club=rs.getString("nombre_club");
				club.add(new Club(cod_club, nombre_club));
				
			}
		} catch (Exception e) {
	         e.printStackTrace(System.out);
	     }finally{
	         Conexion.Close(rs);
	         Conexion.Close(stmt);
	         Conexion.Close(conn);
	                 
	     }
		return club;
		
	}
}
