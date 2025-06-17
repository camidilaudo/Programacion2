package linkedlist;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia de la lista enlazada de tipo Integer
        LinkedList<Integer> lista = new LinkedList<>();

        // Agregar elementos al principio y al final
        System.out.println("Agregando elementos al principio y al final:");
        lista.addFirst(10);  // Agregar al principio
        lista.addLast(20);   // Agregar al final
        lista.addLast(30);   // Agregar al final
        lista.addFirst(5);   // Agregar al principio

        // Imprimir la lista
        lista.printList();  // Salida esperada: 5 10 20 30

        // Eliminar el primer y último elemento
        try {
            lista.removeFirst(); // Eliminar el primer elemento (5)
            lista.removeLast();  // Eliminar el último elemento (30)
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Imprimir la lista después de eliminar
        lista.printList();  // Salida esperada: 10 20

        // Eliminar un elemento específico (20)
        try {
            lista.remove(20);  // Eliminar el elemento 20
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Imprimir la lista después de eliminar 20
        lista.printList();  // Salida esperada: 10

        // Agregar más elementos
        lista.addLast(50);
        lista.addFirst(40);
        lista.addLast(60);

        // Imprimir la lista después de agregar más elementos
        lista.printList();  // Salida esperada: 40 10 50 60

        // Acceder a un elemento en una posición específica
        try {
            System.out.println("Elemento en posición 2: " + lista.elementAt(2));  // Salida esperada: 50
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Remover el elemento en una posición específica
        try {
            lista.removeAt(1);  // Eliminar el elemento en posición 1 (10)
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Imprimir la lista después de eliminar el elemento en la posición 1
        lista.printList();  // Salida esperada: 40 50 60

        // Usar el cursor para recorrer la lista
        lista.First();  // Poner el cursor en el primer elemento
        System.out.println("Primer elemento: " + lista.getCurrent());  // Salida esperada: 40

        try {
            lista.advance();  // Avanzar el cursor
            System.out.println("Después de avanzar, el elemento actual es: " + lista.getCurrent());  // Salida esperada: 50
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Verificar si el cursor está al final de la lista
        if (lista.atEnd()) {
            System.out.println("El cursor ha llegado al final de la lista.");
        } else {
            System.out.println("El cursor no está al final de la lista.");
        }
    }
}
