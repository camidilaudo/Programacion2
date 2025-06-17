package TP1;

public class ejercicio1 {
	public static void main(String[] args) {
		
		int a,b,c;
		
		System.out.println("Indique cuales son los valores de las variables alfanuméricas siguientes segmentos de código JAVA, "
				+ "asumiendo que todas han sido declaradas como enteras :"); 
		
		System.out.println();
		
		a=2;a++;
		System.out.println("a) a=2; a++ --> a = " + a);
		
		a=2; b=a++;
		System.out.println("b) a=2; b=a++; --> a = " + a + " / b = " + b);
		
		a=2; b=++a;
		System.out.println("c) a=2; b=++a; --> a = " + a + " / b = " + b);
		
		a=2; b=1; b+=a;
		System.out.println("d) a=2; b=1; b+=a; --> a = " + a + " / b = " + b);
		
		b=1; b*=5; 
		System.out.println("e) b=1; b*=5; --> a = " + a + " / b = " + b);
		 
		b=1; b*=5; 
		System.out.println("f) a=2; b+=--a+5; --> a = " + a + " / b = " + b);
		 
		a=2;b=3;c=5;a++;b+=a;c*=b;b-=3;a%=2;c/=5; 
		System.out.println("h) a=2; b=3; c=5; a++; b+=a; c*=b; b-=3; a%=2; c/=5;  --> a = " + a + " / b = " + b + " / c = " + c);
		
		a=1;b=2;b++ ;b=++a ;a*=2 ;b+=a; a=++b+2;
		System.out.println("i) ba=1; b=2; b++; b=++a; a*=2; b+=a; a=++b+2; --> a = " + a + " / b = " + b);

		a=1;b=4; a++; b+=a; a*=4; b-=a; ++b; a=++b; b=--a+b; 
		System.out.println("j) a=1;b=4; a++; b+=a; a*=4; b-=a; ++b; a=++b; b=--a+b; --> a = " + a + " / b = " + b);

		
	}
}
