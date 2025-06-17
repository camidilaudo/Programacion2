package ejercicio4;

import ejercicio2.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        arbolBB<Integer> arbol = new arbolBB<>(new DefaultComparator<Integer>());

        // Insertar valores
        int[] valores = {10, 5, 15, 2, 7, 20};
        for (int v : valores) {
            arbol.insertar(v);
        }

        // Crear objeto Metodos con la raiz y tamaño
        Metodos<Integer> metodos = new Metodos<>(arbol.getRaiz(), arbol.getSize());

        // Obtener y mostrar el mínimo
        Integer minimo = metodos.min();
        System.out.println("Mínimo elemento del ABB: " + minimo);
    }
}