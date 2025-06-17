package ejercicio1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// creo una caja de ahorro con el nro de caja 5
		CajaDeAhorro c1 = new CajaDeAhorro(5);

		System.out.println(c1.getNumeroDeCaja()); // (5)
		System.out.println(c1.getSaldo());        // (0)

		c1.depositar(100);
		System.out.println(c1.getSaldo());        // 100

		if (c1.extracciones(100) > 0) {
		    System.out.println(c1.getSaldo());
		} else {
		    System.out.println("Saldo insuficiente");
		}


	}

}
