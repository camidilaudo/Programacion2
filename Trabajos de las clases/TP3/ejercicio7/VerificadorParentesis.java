package ejercicio7;

import java.util.Scanner;
import ejercicio3.LinkedStack;

public class VerificadorParentesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena para verificar paréntesis: ");
        String cadena = scanner.nextLine();

        // crea la pila
        LinkedStack<Character> pila = new LinkedStack<>();
        
        boolean balanceado = true;
        
        // recorre el string ingresado, si es ( lo agrega a la pila, si es ) y hay un ( se lo saca de la pila, sino hay se devuelve false
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '(') {
                pila.push(c); // Apilar paréntesis abierto
            } else if (c == ')') {
                if (pila.isEmpty()) {
                    balanceado = false; // Cerró uno que no se abrió
                    break;
                } else {
                    pila.pop(); // Cierra uno abierto
                }
            }
        }

        // verifica si quedó algún paréntesis sin cerrar
        if (!pila.isEmpty()) {
            balanceado = false;
        }


        if (balanceado) {
            System.out.println("Todos los paréntesis están correctamente cerrados.");
        } else {
            System.out.println("Faltan paréntesis por cerrar o hay uno de más.");
        }

        scanner.close();
    }
}
