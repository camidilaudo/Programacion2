package ejercicio3;


public class Equipos {
	
	// ATRIBUTOS : 
	
	private String nombreEquipo;
	private String capitan;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int golesFavor;
	private int golesContra;
	
	
	// CONSTRUCTORES
	
	public Equipos(String nombreEquipo, String capitan, int partidosGanados, int partidosEmpatados, int partidosPerdidos, int golesFavor, int golesContra) {
		this.nombreEquipo = nombreEquipo;
		this.capitan = capitan;
		this.partidosGanados = partidosGanados;
		this.partidosEmpatados = partidosEmpatados;
		this.partidosPerdidos = partidosPerdidos;
		this.golesFavor = golesFavor;
		this.golesContra = golesContra;
	}
	
	// METODOS

	
	// devuelve todos los partidos que se jugaron
	public int getPartidosJugados() {
		return partidosGanados + partidosEmpatados + partidosPerdidos;
	}
	
	
	// devuelve los puntos que se obtuvieron 
	public int puntosObtenidos() {
		return (partidosGanados * 3) + partidosEmpatados;
	}
	
	
	// devuelve el nombre del equipo con mas goles, sino uno random
	public String equipoConMasPtos(Equipos equipo1, Equipos equipo2) {
		
		// creo atributos de ptos y goles de cada equipo
		int ptoE1 = equipo1.puntosObtenidos();
		int ptoE2 = equipo2.puntosObtenidos();
		int golesF1 = equipo1.getGolesFavor();
		int golesF2 = equipo2.getGolesFavor();
		int golesC1 = equipo1.getGolesContra();
		int golesC2 = equipo2.getGolesContra();

		if (ptoE1 > ptoE2)
			return equipo1.getNombreEquipo();
		else if (ptoE1 < ptoE2)
			return equipo2.getNombreEquipo();
			else if(golesF1 > golesF2)
				return equipo1.getNombreEquipo();
				else if(golesF1 < golesF2)
					return equipo2.getNombreEquipo();
					else if (golesC1 < golesC2)
						return equipo1.getNombreEquipo();
						else 
							return equipo2.getNombreEquipo();
	}
	
	// metodos para obtener atributos
	
	public String getNombreEquipo() {return nombreEquipo;}
	
	public String getCapitan() {return capitan;}
	
	public int getPartidosGanados() {return partidosGanados;}
	
	public int getPartidosEmpatados() {return partidosEmpatados;}
	
	public int getPartidosPerdidos() {return partidosPerdidos;}
	
	public int getGolesFavor() {return golesFavor;}
	
	public int getGolesContra() {return golesContra;}
	
	// metodos para modificar atributos
	
    public void setNombreE(String nombreEquipo) { this.nombreEquipo = nombreEquipo; }
    public void setCapitan(String capitan) { this.capitan = capitan; }
    


}
