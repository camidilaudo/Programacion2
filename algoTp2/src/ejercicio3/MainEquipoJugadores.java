package ejercicio3;

public class MainEquipoJugadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creacion de equipos
		
		Equipos velez = new Equipos("Velez Sarsfield", "Bouzat", 1, 3, 10, 1, 5);
		Equipos boca = new Equipos ("Boca Juniors", "Merentiel", 2, 3, 5, 2, 2);
		
		// creacion de jugadores
		Jugadores valenGomez = new Jugadores("Valentin Gomez", 2005, 31, 3, 50, 10);
		Jugadores elBrian = new Jugadores("Brian Romero", 2000, 9, 9, 50, 125);
		
		// 
		System.out.println("Partidos jugados de "+velez.getNombreEquipo()+": "+velez.getPartidosJugados());
		
		System.out.println("Puntos obtenidos de "+boca.getNombreEquipo()+": "+boca.puntosObtenidos());

		System.out.println("Equipo con mas puntos: "+ velez.equipoConMasPtos(boca, velez));
		
		System.out.println("Jugador con mas goles: "+ elBrian.jugadorConMasGoles(valenGomez, elBrian));
		
		System.out.println("Promedio de goles de "+elBrian.getNombreJugador()+": "+elBrian.promedioGoles()+ " por partido");


	}

}
