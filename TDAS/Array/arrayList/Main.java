package arrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();

        // Imprimir lista vacía
        array.printList();

        // Agregar elementos
        array.addFirst("a");
        array.addLast("b");
        array.addLast("c");
        array.printList();  // [a, b, c]

        // Operaciones de eliminación en un único bloque try-catch
        try {
            array.removeFirst();  // elimina 'a'
            array.removeLast();   // elimina 'c'
            array.remove("b");  // elimina 'b'
        } catch (MyException e) {
            System.out.println("Excepción : " + e.getMessage());
        }

        // Estado final de la lista
        array.printList();

        // Agregar elementos
        array.addFirst("a");
        array.addLast("b");
        array.addLast("c");
        array.printList();  // [a, b, c]
        
        // Print usando current
        array.First();
        while (!array.atEnd()) {
            System.out.print(array.getCurrent() + " ");
            array.advance();
        }
        System.out.println();
    }
}
