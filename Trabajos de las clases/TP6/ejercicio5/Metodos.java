package ejercicio5;

import ejercicio2.*;
import LinkedQueue.*;

public class Metodos<E extends Comparable<E>> {
	
	private NodoABB<E> raiz;
    private int size;

    public Metodos(NodoABB<E> raiz, int size) {
        this.raiz = raiz;
        this.size = size;
    }
    
    public void imprimirPorNiveles() {
        if (raiz.getElemento() == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        LinkedQueue<NodoABB<E>> cola = new LinkedQueue<>();
        cola.enqueue(raiz);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();  // Cantidad de nodos en este nivel

            for (int i = 0; i < nivelSize; i++) {
                NodoABB<E> actual = cola.dequeue();
                System.out.print(actual.getElemento() + " ");

                if (actual.getIzq().getElemento() != null) {
                    cola.enqueue(actual.getIzq());
                }
                if (actual.getDer().getElemento() != null) {
                    cola.enqueue(actual.getDer());
                }
            }
            System.out.println();  // Salto de línea para nuevo nivel
        }
    }



	



}
