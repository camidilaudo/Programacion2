package ejercicio1;

public class CajaDeAhorro {
	
	// atributos 
	private int numeroDeCaja;
	private int saldo;
	
	// constructor
	public CajaDeAhorro(int numeroDeCaja) {
		this.numeroDeCaja = numeroDeCaja;
		this.saldo = 0;
	}

	// getters
	public int getNumeroDeCaja() {
		return numeroDeCaja;
	}

	public int getSaldo() {
		return saldo;
	}	

	// METODOS
	
	
	// actualiza el saldo con lo que se deposita
	public void depositar(int cantidad) {saldo+=cantidad;}
	
	
	// compara el saldo actual con la cantidad que se quiere extraer
	public boolean puedeExtraer(int cantidad) {
		return saldo >= cantidad;
	}
	
	
	// si puede extraer, le resta al saldo la cantidad a estraer y devuelve el saldo actual
	// sino, devuelve -1
	public int extracciones (int cantidad) {
		if (puedeExtraer(cantidad)) {
			return saldo-=cantidad;
		}
		else {return -1;}
	}
	
		
	
}
