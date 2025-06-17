package ejercicio0;

public class Main {
    public static void main(String[] args) {

    	ArrayList<String> lista = new ArrayList<>(5);

        // agregar elementos al final
        lista.addLast("Uno");
        lista.addLast("Dos");

        // agregar al principio
        lista.addFirst("Cero");

        lista.printList();

        // eliminar primero
        lista.removeFirst();

        System.out.println("\nDespués de eliminar el primero:");
        lista.printList();

        // eliminar último
        lista.removeLast();

        System.out.println("\nDespués de eliminar el último:");
        lista.printList();

        //  getCurrent
        lista.First();
        System.out.println("\nElemento actual:");
        System.out.println(lista.getCurrent());

        // Intentar eliminar elemento específico
        lista.addLast("Tres");
        lista.addLast("Cuatro");
        lista.remove("Tres");

        System.out.println("\nDespués de eliminar 'Tres':");
        lista.printList();
    }
}
