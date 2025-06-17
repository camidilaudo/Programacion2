package ejercicio3;

import ejercicio2.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creo el árbol con el Comparator por defecto (Integer Comparable)
        arbolBB<Integer> arbol = new arbolBB<>(new DefaultComparator<Integer>());

        // Inserto valores
        int[] valores = {10, 5, 2, 7, 15, 20};
        for (int v : valores) {
            arbol.insertar(v);
        }

        // Muestro el árbol inOrden usando toString (suponiendo que lo tenés implementado)
        System.out.println("Árbol inOrden (toString): " + arbol);

        // Creo el helper Metodos con la raiz y tamaño del árbol
        Metodos<Integer> metodos = new Metodos<>(arbol.getRaiz(), arbol.getSize());

        // Arreglos para guardar los elementos según los recorridos
        Integer[] preOrden = new Integer[arbol.getSize()];
        Integer[] inOrden = new Integer[arbol.getSize()];
        Integer[] postOrden = new Integer[arbol.getSize()];

        // Lleno los arreglos usando los métodos
        metodos.elementosPre(preOrden);
        metodos.elementosIn(inOrden);
        metodos.elementosPost(postOrden);

        // Imprimo los resultados
        System.out.println("PreOrden:");
        imprimirArray(preOrden);

        System.out.println("InOrden:");
        imprimirArray(inOrden);

        System.out.println("PostOrden:");
        imprimirArray(postOrden);
    }

    private static void imprimirArray(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}