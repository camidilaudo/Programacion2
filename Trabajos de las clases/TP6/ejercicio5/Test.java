package ejercicio5;

import ejercicio2.DefaultComparator;
import ejercicio2.arbolBB;

public class Test {

	    public static void main(String[] args) {

	        arbolBB<Integer> arbol = new arbolBB<>(new DefaultComparator<Integer>());


	        // Insertar elementos
	        int[] valores = {10, 5, 15, 2, 7, 20};
	        for (int v : valores) {
	            arbol.insertar(v);
	        }

	        // Crear instancia de Metodos
	        Metodos<Integer> metodos = new Metodos<>(arbol.getRaiz(), arbol.getSize());

	        // Imprimir árbol por niveles
	        System.out.println("Árbol por niveles: ");
	        metodos.imprimirPorNiveles();
	    
	}

}
