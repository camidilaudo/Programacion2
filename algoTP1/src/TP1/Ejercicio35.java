package TP1;

public class Ejercicio35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* e. Reciba un número entre 0 y 10, y si el número está entre 0 y 4 muestre “desaprobado”,
		 * siestáentre 5 y 6 muestre “suspenso”, y si es mayor que 6 muestre “aprobado”. */
		
		int numero = 10;
		
		switch (numero) {
		case 0,1,2,3,4:
			System.out.println("Desaprobado. ");
			break;
		case 5,6: 
			System.out.println("Suspenso. ");
			break;
		case 7,8,9,10:
			System.out.println("Aprobado. ");
			break;
		default:
			System.out.println("Numero incorrecto. ");




		}
			
		
		
		
		
		
	}
}
