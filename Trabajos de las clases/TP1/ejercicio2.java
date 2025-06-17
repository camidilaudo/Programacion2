package TP1;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b;
		boolean v;
		
		
		System.out.println("Reescribe las porciones de código utilizando solamente la asignación Standard y los operadores aritméticos +, -, *, / y %. \n"
				+ "Indique cuales son los valores de las variables al finalizar cada uno de los siguientes segmentos de código JAVA, asumiendo que a y b se declararon como enteras y v de tipo boolean. \n"
				+ ""); 
		
		System.out.println();
		
		
		a=1; b=2; v=(a++<b);
		System.out.println("a) a=1; b=2; v=(a++<b); -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(++a<b); 
		System.out.println("b) a=1; b=2; v=(++a<b);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(++a>=b);
		System.out.println("c) a=1; b=2; v=(++a>=b);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; v= (a%2 == 0);
		System.out.println("d) a=1; v= (a%2 == 0);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1;v=(a!=1);
		System.out.println("e) a=1;v=(a!=1);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(b++<10 && a==1);
		System.out.println("f) a=1; b=2; v=(b++<10 && a==1);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(b==1 && a>=1); 
		System.out.println("g) a=1; b=2; v=(b==1 && a>=1);   -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(b<10 || a++==2);
		System.out.println("d) a=1; b=2; v=(b<10 || a++==2);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(--b<=1 || a<=10);
		System.out.println("i) a=1; b=2; v=(--b<=1 || a<=10);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=(a--==2 || b==1); 
		System.out.println("j) a=1; b=2; v=(a--==2 || b==1);   -->  v = " + v + " / a = " + a + " / b = " + b);
		
		a=1; b=2; v=!(a==1 && ++b==1);
		System.out.println("k) a=1; b=2; v=!(a==1 && ++b==1);  -->  v = " + v + " / a = " + a + " / b = " + b);
		
		
		
		
		

	}
}
