package dominio;

public class Club {
	
	private int cod_club;
	private String nombre_club;
	
	
	public Club() {
		super();
	}


	public Club(int cod_club, String nombre_club) {
		super();
		this.cod_club = cod_club;
		this.nombre_club = nombre_club;
	}


	public int getCod_club() {
		return cod_club;
	}


	public void setCod_club(int cod_club) {
		this.cod_club = cod_club;
	}


	public String getNombre_club() {
		return nombre_club;
	}


	public void setNombre_club(String nombre_club) {
		this.nombre_club = nombre_club;
	}
	
	
}
