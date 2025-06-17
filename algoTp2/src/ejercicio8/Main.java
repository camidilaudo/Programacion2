package ejercicio8;

public class Main {
    public static void main(String[] args) {
    	
    	DLinkedList<Integer> l1 = new DLinkedList<>();
    	
    	l1.addFirst(10);
    	l1.addLast(20);
    	l1.addFirst(50);
    	l1.addLast(70);
    	
    	l1.printList();
    	
    	l1.removeFirst();
    	l1.printList();
    	
    	System.out.println("Size: " + l1.getSize());
    	l1.remove(20);
    	System.out.println("Eliminar 20: " );
    	l1.printList();
    	
    	l1.First();  // Coloca `current` al principio de la lista
        System.out.println("Elemento al principio de la lista: " + l1.getCurrent());  
        
        l1.advanceR();  // Avanza una posición en la lista
        System.out.println("Elemento después de avanzar: " + l1.getCurrent()); 
        
        l1.Last();  // Coloca `current` al final de la lista
        System.out.println("Elemento al final de la lista: " + l1.getCurrent()); 
        
        l1.advanceL();  // Retrocede una posición
        System.out.println("Elemento después de retroceder: " + l1.getCurrent()); 

    }

}
