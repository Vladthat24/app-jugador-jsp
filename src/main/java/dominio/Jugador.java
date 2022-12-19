package dominio;

public class Jugador {
	
	private int cod_jugador;
	private String nombre_jugador;
	private String ape_juegador;
	private int dni_jugador;
	private Double sueldo;
	private int cod_club;
	private int cod_posicion;
	
	public Jugador() {
		super();
	}

	public Jugador(int cod_jugador, String nombre_jugador, String ape_juegador, int dni_jugador, Double sueldo,
			int cod_club, int cod_posicion) {
		super();
		this.cod_jugador = cod_jugador;
		this.nombre_jugador = nombre_jugador;
		this.ape_juegador = ape_juegador;
		this.dni_jugador = dni_jugador;
		this.sueldo = sueldo;
		this.cod_club = cod_club;
		this.cod_posicion = cod_posicion;
	}
	

	public Jugador(int cod_jugador) {
		super();
		this.cod_jugador = cod_jugador;
	}

	public Jugador(String nombre_jugador, String ape_juegador, int dni_jugador, Double sueldo, int cod_club,
			int cod_posicion) {
		super();
		this.nombre_jugador = nombre_jugador;
		this.ape_juegador = ape_juegador;
		this.dni_jugador = dni_jugador;
		this.sueldo = sueldo;
		this.cod_club = cod_club;
		this.cod_posicion = cod_posicion;
	}

	public int getCod_jugador() {
		return cod_jugador;
	}

	public void setCod_jugador(int cod_jugador) {
		this.cod_jugador = cod_jugador;
	}

	public String getNombre_jugador() {
		return nombre_jugador;
	}

	public void setNombre_jugador(String nombre_jugador) {
		this.nombre_jugador = nombre_jugador;
	}

	public String getApe_juegador() {
		return ape_juegador;
	}

	public void setApe_juegador(String ape_juegador) {
		this.ape_juegador = ape_juegador;
	}

	public int getDni_jugador() {
		return dni_jugador;
	}

	public void setDni_jugador(int dni_jugador) {
		this.dni_jugador = dni_jugador;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public int getCod_club() {
		return cod_club;
	}

	public void setCod_club(int cod_club) {
		this.cod_club = cod_club;
	}

	public int getCod_posicion() {
		return cod_posicion;
	}

	public void setCod_posicion(int cod_posicion) {
		this.cod_posicion = cod_posicion;
	}

	
	@Override
	public String toString() {
		return "Jugador [cod_jugador=" + cod_jugador + ", nombre_jugador=" + nombre_jugador + ", ape_juegador="
				+ ape_juegador + ", dni_jugador=" + dni_jugador + ", sueldo=" + sueldo + ", cod_club=" + cod_club
				+ ", cod_posicion=" + cod_posicion + "]";
	}

}
