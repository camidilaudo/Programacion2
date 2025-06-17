package TP1;

public class Ejercicio34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// d. Reciba tres números y retorne el mayor de los tres.
		
		int num1 = 3, num2 = -3, num3= 33;
		
		if (num1 > num2 & num1 > num3) {
			System.out.println("El numero mayor es: " + num1);}
		else if(num2 > num3){
			System.out.println("El numero mayor es: " + num2);}
		else if (num1 == num2 & num2 == num3) {
			System.out.println("Los numeros son iguales. ");}
		else 
			System.out.println("El numero mayor es: " + num3);


	
	}
}
