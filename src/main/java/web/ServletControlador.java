/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;



import java.io.IOException;
import java.util.List;

import datos.ClubDao;
import datos.JugadorDao;
import datos.PosicionDao;
import dominio.Club;
import dominio.Jugador;
import dominio.Posicion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ServletControlador", urlPatterns = { "/ServletControlador" })
public class ServletControlador extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "editar":
				this.editarJugador(request, response);
				break;
			case "eliminar":
				this.eliminarJugador(request, response);
				break;

			default:
				this.accionDefault(request, response);
			}

		} else {
			this.accionDefault(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.insertarJugador(request, response);
				break;

			case "modificar":
				this.modificarJugador(request, response);
				break;
			case "eliminar":
				this.eliminarJugador(request, response);
				break;

			case "select":
				this.accionDefault(request, response);
				break;

			default:
				this.accionDefault(request, response);
			}

		} else {
			this.accionDefault(request, response);
		}
	}

	protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Object[]> jugador = null;
		List<Jugador> jugadorSueldo = new JugadorDao().listarDao();
		HttpSession sesion = request.getSession();
		
			jugador = new JugadorDao().listar();
			System.out.println("jugador = " + jugador);
			sesion.setAttribute("jugador", jugador);


		List<Club>  club = new ClubDao().listar();
		System.out.println("club = " + club);

		List<Posicion> posicion = new PosicionDao().listar();
		System.out.println("posicion = " + posicion);


		sesion.setAttribute("club", club);
		sesion.setAttribute("posicion", posicion);
		sesion.setAttribute("sueldoDelanteros", this.calcularSueldoJugador(jugadorSueldo));
		sesion.setAttribute("cantDelanterios", this.cantidadJugadoresDelanterios(jugadorSueldo));

		response.sendRedirect("clientes.jsp");
	}
	
    private double calcularSueldoJugador(List<Jugador> jugadores){
    double sueldoTotalDelantero=0;
        for (Jugador jugador : jugadores) {
        	if(jugador.getCod_posicion()==1) {
        		
        		sueldoTotalDelantero+=jugador.getSueldo();
        	}
        }
    
    return sueldoTotalDelantero;
    }
    
    private int cantidadJugadoresDelanterios(List<Jugador> jugadores){
    int cantidadJugadoresDelanteros=0;
        for (Jugador jugador : jugadores) {
        	if(jugador.getCod_posicion()==1) {
        		
        		cantidadJugadoresDelanteros+=1;
        	}
        }
    
    return cantidadJugadoresDelanteros;
    }

	protected void editarJugador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cod_jugador = Integer.parseInt(request.getParameter("cod_jugador"));

		Jugador jugador = new JugadorDao().buscar(new Jugador(cod_jugador));

		request.setAttribute("jugador", jugador);

		List<Club> club = new ClubDao().listar();
		System.out.println("club = " + club);

		List<Posicion> posicion = new PosicionDao().listar();
		System.out.println("posicion = " + posicion);


		request.setAttribute("club",club);
		request.setAttribute("posicion", posicion);
		
		String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);
	}

	protected void modificarJugador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cod_jugador = Integer.parseInt(request.getParameter("cod_jugador"));
		int cod_club = Integer.parseInt(request.getParameter("cod_club"));
		int cod_posicion = Integer.parseInt(request.getParameter("cod_posicion"));
		String nombre_jugador = request.getParameter("nombre_jugador");
		String ape_jugador = request.getParameter("ape_juegador");
		int dni_jugador = Integer.parseInt(request.getParameter("dni_jugador"));
		Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
		Jugador jugador = new Jugador(cod_jugador, nombre_jugador, ape_jugador, dni_jugador, sueldo, cod_club, cod_posicion);
		int resgistrosModificados = new JugadorDao().actualizar(jugador);
		this.accionDefault(request, response);

	}

	protected void eliminarJugador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cod_jugador = Integer.parseInt(request.getParameter("cod_jugador"));
		Jugador jugador = new Jugador(cod_jugador);
		int registrosModificados = new JugadorDao().eliminar(jugador);
		this.accionDefault(request, response);
	}

	protected void insertarJugador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int idCliente=Integer.parseInt(request.getParameter("idCliente"));

		int cod_club = Integer.parseInt(request.getParameter("cod_club"));
		int cod_posicion = Integer.parseInt(request.getParameter("cod_posicion"));
		String nombre_jugador = request.getParameter("nombre_jugador");
		String ape_jugador = request.getParameter("ape_jugador");
		int dni_jugador = Integer.parseInt(request.getParameter("dni_jugador"));
		Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
		Jugador jugador = new Jugador(nombre_jugador, ape_jugador, dni_jugador, sueldo, cod_club, cod_posicion);
		int resgistrosModificados = new JugadorDao().insertar(jugador);
		this.accionDefault(request, response);

	}
}
