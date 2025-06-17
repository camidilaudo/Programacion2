package ejercicio5;

public class Main {
    public static void main(String[] args) {
        ArrayPriorityQueue<Integer, String> cola = new ArrayPriorityQueue<>(10);

        try {
            cola.insert(5, "Tarea 1");
            cola.insert(3, "Tarea 2");
            cola.insert(8, "Tarea 3");
            cola.insert(1, "Tarea urgente");

            System.out.println("Tamaño actual: " + cola.size()); // 4

            System.out.println("Elemento con menor prioridad: " + cola.min().getValue()); // "Tarea urgente"

            // Eliminamos el mínimo
            System.out.println("Removido: " + cola.removeMin().getValue()); // "Tarea urgente"

            // Mostramos el siguiente mínimo
            System.out.println("Nuevo mínimo: " + cola.min().getValue()); // "Tarea 2"

            // Eliminamos todos
            System.out.println("Removido: " + cola.removeMin().getValue()); // "Tarea 2"
            System.out.println("Removido: " + cola.removeMin().getValue()); // "Tarea 1"
            System.out.println("Removido: " + cola.removeMin().getValue()); // "Tarea 3"

            // Intentamos eliminar de una cola vacía
            System.out.println("Removido: " + cola.removeMin().getValue()); // debería lanzar excepción

        } catch (MyException e) {
            System.out.println("Exepcion: " + e.getMessage());
        }
    }
}
