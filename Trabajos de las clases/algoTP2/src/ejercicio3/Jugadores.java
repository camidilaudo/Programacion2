package ejercicio3;

public class Jugadores {
	
	// ATRIBUTOS
	
	private String nombreJugador;
	private int anioNacimiento;
	private int nroCamiseta;
	private int nroPosicion;
	private int partidosJugados;
	private int golesConvertidos;
	
	
	// CONSTRUCTORES
	
	public Jugadores(String nombreJugador, int anioNacimiento, int nroCamiseta, int nroPosicion, int partidosJugados, int golesConvertidos) {
		this.nombreJugador = nombreJugador;
		this.anioNacimiento = anioNacimiento;
		this.nroCamiseta = nroCamiseta;
		this.nroPosicion = nroPosicion;
		this.partidosJugados = partidosJugados;
		this.golesConvertidos = golesConvertidos;
	}
	
	// METODOS
	public static String jugadorConMasGoles(Jugadores jugador1, Jugadores jugador2) {
		int golesJ1 = jugador1.golesConvertidos;
		int golesJ2 = jugador2.golesConvertidos;
		
		if (golesJ1 > golesJ2)
			return jugador1.getNombreJugador();
		else 
			if (jugador1.golesConvertidos < jugador2.golesConvertidos)
			return jugador2.getNombreJugador();
			else 
				return "Ambos jugadores tienen igual cantidad de goles";
	}
	
	
	// metodos para obtener atributos
	
	public double promedioGoles() {return golesConvertidos / partidosJugados;}
	
	public int getGolesConvertidos() {return golesConvertidos;}
	
	public String getNombreJugador() {return nombreJugador;}
	
	// metodos para editar atributos
	
	public void setGolesConvertidos(int golesConvertidos) {this.golesConvertidos = golesConvertidos;}
	
	

}
