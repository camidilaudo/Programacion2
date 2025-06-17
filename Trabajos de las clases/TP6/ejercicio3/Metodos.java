package ejercicio3;

import ejercicio2.*;

public class Metodos<E extends Comparable<E>> {
    
	private NodoABB<E> raiz;
    private int size;

    public Metodos(NodoABB<E> raiz, int size) {
        this.raiz = raiz;
        this.size = size;
    }
    
    public void elementosPre(E[] destino) {
        llenarPre(raiz, destino, new int[]{0});
    }

    public void elementosIn(E[] destino) {
        llenarIn(raiz, destino, new int[]{0});
    }

    public void elementosPost(E[] destino) {
        llenarPost(raiz, destino, new int[]{0});
    }
    
    private void llenarPre(NodoABB<E> nodo, E[] arr, int[] i) {
        if (nodo == null) return;
        if (nodo.getElemento() != null) {
            arr[i[0]++] = nodo.getElemento();
        }
        llenarPre(nodo.getIzq(), arr, i);
        llenarPre(nodo.getDer(), arr, i);
    }

    private void llenarIn(NodoABB<E> nodo, E[] arr, int[] i) {
        if (nodo == null) return;
        llenarIn(nodo.getIzq(), arr, i);
        if (nodo.getElemento() != null) {
            arr[i[0]++] = nodo.getElemento();
        }
        llenarIn(nodo.getDer(), arr, i);
    }

    private void llenarPost(NodoABB<E> nodo, E[] arr, int[] i) {
        if (nodo == null) return;
        llenarPost(nodo.getIzq(), arr, i);
        llenarPost(nodo.getDer(), arr, i);
        if (nodo.getElemento() != null) {
            arr[i[0]++] = nodo.getElemento();
        }
    }

}
