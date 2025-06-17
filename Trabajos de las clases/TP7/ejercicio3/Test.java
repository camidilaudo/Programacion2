package ejercicio3;

import java.util.Comparator;

import ejercicio2.DefaultComparator;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Comparator<Integer> comp = new DefaultComparator<Integer>();

        AVL<Integer> avl = new AVL<>(comp);

        // Insertamos valores
        avl.insert(10);
        avl.insert(20);
        avl.insert(5);
        avl.insert(3);
        avl.insert(8);

        // Mostrar árbol inorden
        System.out.print("Árbol inorden: ");
        avl.inOrderTraversal();

        // Probar min()
        Integer minValue = avl.min();
        System.out.println("Valor mínimo: " + minValue);  // Debería imprimir 3

        // Probar existencia
        System.out.println("Existe 5? " + avl.exists(5));   // true
        System.out.println("Existe 15? " + avl.exists(15)); // false

        // Probar eliminación
        avl.delete(3);
        System.out.print("Árbol después de eliminar 3: ");
        avl.inOrderTraversal();

        // Verificar min después de eliminar el mínimo anterior
        System.out.println("Nuevo valor mínimo: " + avl.min()); // Debería ser 5
    }


}
