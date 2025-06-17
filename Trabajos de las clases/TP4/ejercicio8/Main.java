package ejercicio8;

import ejercicio6.ArrayPriorityQueue;
import ejercicio7.LinkedPriorityQueue;
import ejercicio6.PriorityQueue;
import ejercicio6.Entry;

public class Main {
    public static void main(String[] args) {
    	
    	
        // Implementación estática
        System.out.println("PRIORIDAD ESTÁTICA : ");
        
        PriorityQueue<Integer, Paciente> colaEstatica = new ArrayPriorityQueue<>(10);
        
        // limitada en cantidad de pacientes
        // requiere mucho reordenamiento

        colaEstatica.insert(3, new Paciente("camila"));
        colaEstatica.insert(1, new Paciente("thiago"));
        colaEstatica.insert(2, new Paciente("miranda"));

        while (!colaEstatica.isEmpty()) {
            Entry<Integer, Paciente> atendido = colaEstatica.removeMin();
            System.out.println("Atendiendo a: " + atendido.getValue() + " con prioridad " + atendido.getKey());
        }

        
        // Implementación dinámica
        System.out.println("\nPRIORIDAD DINÁMICA : ");
        
        PriorityQueue<Integer, Paciente> colaDinamica = new LinkedPriorityQueue<>();
        
        // no tiene tamanio fijo 
        // mas lento al insertar porque hay que recorrer para ubicar el nuevo nodo

        colaDinamica.insert(2, new Paciente("miranda"));
        colaDinamica.insert(1, new Paciente("thiago"));
        colaDinamica.insert(3, new Paciente("camila"));

        while (!colaDinamica.isEmpty()) {
            Entry<Integer, Paciente> atendido = colaDinamica.removeMin();
            System.out.println("Atendiendo a: " + atendido.getValue() + " con prioridad " + atendido.getKey());
        }
    }
}
