package ejercicio7;

import ejercicio6.MyException;


public class Main {
    public static void main(String[] args) {
        LinkedPriorityQueue<Integer, String> pq = new LinkedPriorityQueue<>();

        try {
            pq.insert(3, "3");
            pq.insert(1, "1");
            pq.insert(5, "5");
            pq.insert(2, "2");

            System.out.println("Tamaño de la cola: " + pq.size()); // 4
            System.out.println("¿Está vacía?: " + pq.isEmpty()); // false

            System.out.println("Elemento de menor prioridad: " + pq.min().getValue()); // "Pagar cuentas"

            System.out.println("Remover mínimo: " + pq.removeMin().getValue()); // "Pagar cuentas"
            System.out.println("Nuevo mínimo: " + pq.min().getValue()); // "Ir al médico"

            // Remover todo
            System.out.println("Remover: " + pq.removeMin().getValue()); // "Ir al médico"
            System.out.println("Remover: " + pq.removeMin().getValue()); // "Estudiar"
            System.out.println("Remover: " + pq.removeMin().getValue()); // "Lavar ropa"

            System.out.println("¿Está vacía al final?: " + pq.isEmpty()); // true

            // Esto debería lanzar excepción
            pq.removeMin();

        } catch (MyException e) {
            System.out.println("Excepción : " + e.getMessage());
        }
    }
}
