package ejercicio6;

import ejercicio2.*;
import LinkedQueue.*;

public class Metodos<E extends Comparable<E>> {
	
	private NodoABB<E> raiz;
    private int size;

    public Metodos(NodoABB<E> raiz, int size) {
        this.raiz = raiz;
        this.size = size;
    }
    
    public int altura() {
        return alturaAux(raiz);
    }

    private int alturaAux(NodoABB<E> nodo) {
        if (nodo == null || nodo.getElemento() == null) {
            return 0;
        }
        int alturaIzq = alturaAux(nodo.getIzq());
        int alturaDer = alturaAux(nodo.getDer());
        return 1 + Math.max(alturaIzq, alturaDer);
    }


}
