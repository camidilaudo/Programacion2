package ejercicio4;

import ejercicio2.*;

public class Metodos<E extends Comparable<E>> {
	
	private NodoABB<E> raiz;
    private int size;

    public Metodos(NodoABB<E> raiz, int size) {
        this.raiz = raiz;
        this.size = size;
    }
	
	// Retorna la mínima clave del ABB
	public E min() {
	    if (raiz.getElemento() == null) {}// ARBOL VACIO
	        
	    return minAux(raiz);
	}

	// Función auxiliar recursiva
	private E minAux(NodoABB<E> nodo) {
	    if (nodo.getIzq().getElemento() == null) {
	        return nodo.getElemento(); // no hay más hijo izquierdo
	    } else {
	        return minAux(nodo.getIzq());
	    }
	}


}
