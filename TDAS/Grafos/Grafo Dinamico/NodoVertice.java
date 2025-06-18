package Grafo;

public class NodoVertice<E> {
	
	private E vertice;
	private NodoVertice<E> sigVertice;
	private NodoArista<E> aristas;
	
	public NodoVertice() {}

	public NodoVertice<E> getSigVertice() {
		return sigVertice;
	}
	public void setSigVertice(NodoVertice<E> sigVertice) {
		this.sigVertice = sigVertice;
	}
	public NodoArista<E> getAristas() {
		return aristas;
	}
	public void setAristas(NodoArista<E> aristas) {
		this.aristas = aristas;
	}

	public E getVertice() {
		return vertice;
	}

	public void setVertice(E vertice) {
		this.vertice = vertice;
	}

}
