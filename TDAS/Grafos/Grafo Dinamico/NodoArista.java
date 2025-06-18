package Grafo;

public class NodoArista<E> {
	
	private int peso;
	private NodoArista<E> sigArista;
	private NodoVertice<E> verticeDestino;
	
	public NodoArista() {}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public NodoArista<E> getSigArista() {
		return sigArista;
	}
	public void setSigArista(NodoArista<E> sigArista) {
		this.sigArista = sigArista;
	}
	public NodoVertice<E> getVerticeDestino() {
		return verticeDestino;
	}
	public void setVerticeDestino(NodoVertice<E> verticeDestino) {
		this.verticeDestino = verticeDestino;
	}

}
