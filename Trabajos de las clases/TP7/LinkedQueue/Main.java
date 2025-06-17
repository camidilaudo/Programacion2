package LinkedQueue;

public class Main {
    public static void main(String[] args) {

        LinkedQueue<Integer> cola = new LinkedQueue<>();

        //  si la cola está vacía
        System.out.println("¿Está vacía?: " + cola.isEmpty()); // true

        // agregar
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        // tamaño de la cola
        System.out.println("Tamaño de la cola: " + cola.size()); // 3

        // elemento en el frente de la cola
        System.out.println("Elemento en el frente: " + cola.front()); // 10

        // eliminar elementos 
        try {
            System.out.println("Dequeue: " + cola.dequeue()); // 10
            System.out.println("Dequeue: " + cola.dequeue()); // 20
        } catch (MyException e) {
            System.out.println("Error al hacer dequeue: " + e.getMessage());
        }

        // tamaño de la cola después de eliminar elementos
        System.out.println("Tamaño de la cola después de dequeues: " + cola.size()); // 1

        // verificar el elemento en el frente de la cola
        try {
            System.out.println("Elemento en el frente ahora: " + cola.front()); // 30
        } catch (MyException e) {
            System.out.println("Error al acceder al frente: " + e.getMessage());
        }

        // verificar si la cola está vacía después de más operaciones
        try {
            cola.dequeue(); // Elimina el último elemento (30)
            System.out.println("¿Está vacía después de eliminar todo?: " + cola.isEmpty()); // true
        } catch (MyException e) {
            System.out.println("Error al hacer dequeue: " + e.getMessage());
        }

        // Intentar hacer dequeue en una cola vacía
        try {
            System.out.println("Dequeue: " + cola.dequeue());
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }

        // Intentar hacer front en una cola vacía
        try {
            System.out.println("Elemento en el frente: " + cola.front());
        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
    }
}
