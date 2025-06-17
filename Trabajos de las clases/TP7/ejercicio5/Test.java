package ejercicio5;

import java.util.Comparator;
import ejercicio2.DefaultComparator;

public class Test {
	
	public static void main(String[] args) {


        Comparator<Integer> comp = new DefaultComparator<Integer>();

        AVL<Integer> avl = new AVL<>(comp);

        // Insertamos valores
        avl.insert(10);
        avl.insert(20);
        avl.insert(5);
        avl.insert(3);
        avl.insert(8);

			
        System.out.println("Altura del árbol AVL: " + avl.height());

		

}
	
}
