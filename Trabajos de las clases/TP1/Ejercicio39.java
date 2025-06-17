package TP1;

public class Ejercicio39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// i. Reciba un número N, y retorne la suma de sus dígitos
		
		int N=1234, suma=0, digito = 0;
		
		while (N>0) {
			digito = N%10;
			suma+=digito;
			N/=10;
			
		
		}
        System.out.println("La suma de los dígitos es: " + suma);


	}
}
