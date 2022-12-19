package dominio;

public class Posicion {
	private int cod_posicion;
	private String nom_posicion;
	
	public Posicion() {
		super();
	}

	public Posicion(int cod_posicion, String nom_posicion) {
		super();
		this.cod_posicion = cod_posicion;
		this.nom_posicion = nom_posicion;
	}

	public int getCod_posicion() {
		return cod_posicion;
	}

	public void setCod_posicion(int cod_posicion) {
		this.cod_posicion = cod_posicion;
	}

	public String getNom_posicion() {
		return nom_posicion;
	}

	public void setNom_posicion(String nom_posicion) {
		this.nom_posicion = nom_posicion;
	}
	
	

}
