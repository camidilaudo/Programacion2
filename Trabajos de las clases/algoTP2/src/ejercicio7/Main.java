package ejercicio7;

public class Main {

    public static void main(String[] args) {
        
    	LinkedList<Integer> lista = new LinkedList<>();
        
        lista.addFirst(10);
        lista.addFirst(20);
        lista.addLast(30);
        lista.addLast(40);
        lista.printList();

        
        System.out.println("Tamaño de la lista: " + lista.getSize());
        
        System.out.println("Primer elemento: " + lista.elementAt(0));
        
        System.out.println("Último elemento: " + lista.elementAt(lista.getSize() - 1));
        
        System.out.println("Elemento en la posición 2: " + lista.elementAt(2));
        
        try {
            lista.remove(30);
            System.out.println("Elemento 30 eliminado.");
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
        
        lista.printList();


        try {
            lista.removeAll(10);
            System.out.println("Elemento 10 eliminado de todos los nodos.");
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
        
        lista.printList();

        
        System.out.println("Tamaño de la lista después de eliminar: " + lista.getSize());
        
        try {
            lista.removeFirst();
            System.out.println("Primer elemento eliminado.");
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
        
        lista.printList();

        
        try {
            lista.removeLast();
            System.out.println("Último elemento eliminado.");
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
        
        lista.printList();

        
        System.out.println("Tamaño de la lista después de eliminar el primero y último: " + lista.getSize());
        
        lista.First();
        try {
            while (!lista.atEnd()) {
                System.out.println("Elemento actual: " + lista.getCurrent());
                lista.advance();
            }
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
        
        try {
            lista.removeAt(0);
            System.out.println("Elemento en la posición 0 eliminado.");
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
        
        lista.printList();


        System.out.println("Tamaño de la lista después de removeAt: " + lista.getSize());
        
        System.out.println("Lista final:");
        lista.printList();
        
        lista.First();
        try {
            while (!lista.atEnd()) {
                System.out.println("Elemento actual: " + lista.getCurrent());
                lista.advance();
            }
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
    }
}
