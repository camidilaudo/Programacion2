package ejercicio2;

public class Main {
    public static void main(String[] args) {
        
        ArrayQueue<Integer> cola = new ArrayQueue<>(5);

        // la cola está vacía
        System.out.println("¿Está vacía?: " + cola.isEmpty()); // true
        
        // agregar elementos a la cola
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        
        // tamaño de la cola
        System.out.println("Tamaño de la cola: " + cola.size()); // 3
        
        // elemento en el frente de la cola
        System.out.println("Elemento en el frente: " + cola.front()); // 10
        
        // eliminar elementos de la cola
        System.out.println("Dequeue: " + cola.dequeue()); // 10
        System.out.println("Dequeue: " + cola.dequeue()); // 20
        
        // mostrar el tamaño de la cola después de eliminar elementos
        System.out.println("Tamaño de la cola después de dequeues: " + cola.size()); // 1
        
        // elemento en el frente de la cola
        System.out.println("Elemento en el frente ahora: " + cola.front()); // 30
        
        
        //  si la cola está vacía después de más operaciones
      
        cola.dequeue(); // Elimina el último elemento (30)
        System.out.println("¿Está vacía después de eliminar todo?: " + cola.isEmpty()); // true
        
        // Intentar hacer dequeue en una cola vacía (esto debería lanzar una excepción)
        try {
            cola.dequeue();
        } catch (MyException e) {
            System.out.println("Excepción al hacer dequeue: " + e.getMessage());
        }
        
        // Intentar hacer front en una cola vacía (esto debería lanzar una excepción)
        try {
            cola.front();
        } catch (MyException e) {
            System.out.println("Excepción al hacer front: " + e.getMessage());
        }
    }
}
