package TP1;

public class Ejercicio312 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// l. Determine si un número dado es perfecto; un número es perfecto si la suma de los divisores del número
		// (incluyendo al 1 y excluyendo al número) es igual al número. Ej.:sumadedivisoresde6=>1+2+3=6=>esperfecto.

		int numero = 6, suma = 0;
		
		for (int i = 1; numero > i; i++) {
			if (numero % i  == 0) 
				suma += i;
			
		}
		
		if (suma == numero) {
			System.out.println(numero +" es perfecto. ");
		}
		else
			System.out.println(numero +" no es perfecto. ");

		
		
		
		
		
	}

}
