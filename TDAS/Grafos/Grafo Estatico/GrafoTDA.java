package Grafo;

public interface GrafoTDA<E> {
	
	public void agregarVertice(E v);
	public void eliminarVertice(E v);
	public E[] vertices();
	public void agregarArista(E v1, E v2, int peso); 
	public void eliminarArista(E v1, E v2);
	public boolean existeArista(E v1, E v2); 
	public int pesoArista(E v1, E v2); 
}
