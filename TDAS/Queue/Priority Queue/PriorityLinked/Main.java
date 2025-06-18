package PriorityLinked;

public class Main {
    public static void main(String[] args) {
        LinkedPriorityQueue<Integer, String> pq = new LinkedPriorityQueue<Integer, String>();

        try {
            pq.insert(4, "Tarea normal");
            pq.insert(2, "Tarea importante");
            pq.insert(5, "Tarea menos importante");
            pq.insert(1, "Tarea urgente");

            System.out.println("Tamaño actual: " + pq.size()); // 4
            System.out.println("¿Está vacía?: " + pq.isEmpty()); // false

            System.out.println("Elemento con menor prioridad: " + pq.min().getValue()); // "Tarea urgente"

            System.out.println("Removido: " + pq.removeMin().getValue()); // "Tarea urgente"
            System.out.println("Nuevo mínimo: " + pq.min().getValue()); // "Tarea importante"

            // Remover todo
            System.out.println("Removido: " + pq.removeMin().getValue()); // "Tarea importante"
            System.out.println("Removido: " + pq.removeMin().getValue()); // "Tarea normal"
            System.out.println("Removido: " + pq.removeMin().getValue()); // "Tarea menos importante"

            System.out.println("¿Está vacía al final?: " + pq.isEmpty()); // true

            // Probar excepción al remover de cola vacía
            pq.removeMin(); // Esto lanzará una excepción

        } catch (MyException e) {
            System.out.println("Excepción : " + e.getMessage());
        }
        
        
		//test de priority queue
		LinkedPriorityQueue<Integer, String> ColaConPrioridad = new LinkedPriorityQueue<Integer, String>();
		ColaConPrioridad.insert(2, "mundo");
		ColaConPrioridad.insert(1, "Hola");
		ColaConPrioridad.insert(3, "Java");
		
		while(ColaConPrioridad.size()!=0) {
			Entry<Integer,String> salida = ColaConPrioridad.removeMin();
			System.out.println(salida.getKey()+" - "+salida.getValue());
		}
    }
}
