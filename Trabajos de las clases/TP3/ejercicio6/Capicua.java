package ejercicio6;

import java.util.Scanner;
import ejercicio3.LinkedStack;

public class Capicua {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	 
	        System.out.print("Ingrese una cadena para verificar si es capicúa: ");
	        String cadena = scanner.nextLine();

	        // crea la pila y apilar los caracteres de la cadena
	        LinkedStack<Character> pila = new LinkedStack<>();
	        
	        // recorre los elementos del string que se ingreso y obtiene los elementos y los va agregando a la pila
	        for (int i = 0; i < cadena.length(); i++) {
	            pila.push(cadena.charAt(i)); 
	        }

	        // compara los caracteres originales con los desapilados
	        boolean esCapicua = true;
	        for (int i = 0; i < cadena.length(); i++) {
	            if (cadena.charAt(i) != pila.pop()) {
	                esCapicua = false;
	                break;
	            }
	        }

	        // mostrar el resultado
	        if (esCapicua) {
	            System.out.println("La cadena es capicúa.");
	        } else {
	            System.out.println("La cadena no es capicúa.");
	        }

	        scanner.close();
	    }

}
