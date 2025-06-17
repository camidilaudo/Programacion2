package ejercicio6;

import java.util.Scanner;
import ejercicio2.DefaultComparator;
import linkedlist.*;

public class Test {
	
	public static void main(String[] args) {


		AVL<Integer> arbol = new AVL<>(new DefaultComparator<>());
        
		Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números enteros (finalice con un punto '.'):");
        while (true) {
            String entrada = scanner.next();

            if (entrada.equals(".")) break;

            try {
                int numero = Integer.parseInt(entrada);
                arbol.insert(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero o '.' para finalizar.");
            }
        }

        System.out.println("\nÁrbol AVL por niveles:");
        arbol.levelOrder();

        LinkedList<Integer> listaOrdenada = new LinkedList<>();
        arbol.inOrderToList(listaOrdenada);

        System.out.println("\nElementos ordenados:");
        listaOrdenada.First();
        while (!listaOrdenada.atEnd()) {
            System.out.print(listaOrdenada.getCurrent() + " ");
            listaOrdenada.advance();
        }
        System.out.println();
    }
}

	

