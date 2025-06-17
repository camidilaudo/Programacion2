package TP1;

public class Ejercicio310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// j. Determine si, dado un número N = dm,dm-1, ..., d1 y un dígito d, d=di para 1<=i<=m
		
		int N= 1234, d=4;
		boolean estaD = false;
		
		while (N>0) {
			int digito = N%10;
			if (digito == d) {
					estaD = true;
					break;
					}
			N/=10;
		}
		
		if (estaD) {
			System.out.print("El digito " + d + " esta en " + N);
		}
		else {
			System.out.print("El digito " + d + " no esta en " + N );
		}

}}
