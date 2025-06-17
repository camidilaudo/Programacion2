package TP1;

public class Ejercicio311 {
    public static void main(String[] args) {
    	
        // k. Determine si un número dado es primo.
        int numero = 55;
        boolean esPrimo = true;

        if (numero <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    esPrimo = false; 
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println(numero + " es primo");
        } else {
            System.out.println(numero + " no es primo");
        }
    }
}
