package Grafo;

import arrayList.*;

public class GrafoEstatico<E extends Comparable<E>> implements GrafoTDA<E>{
	
	private int [][] mAdy;
	private E[] vector;
	private int cantNodos;
	
	@SuppressWarnings("unchecked")
	public GrafoEstatico() {
		mAdy = new int[100][100];
		vector = (E[])new Object[100];
		cantNodos = 0;
	}
	
	@Override
	public void agregarVertice(E v) {
		vector[cantNodos] = v;
		for( int i = 0; i <= cantNodos; i++ ) {
			mAdy[cantNodos][i] = 0; // nueva fila
			mAdy[i][cantNodos] = 0; // nueva columna
		}
		cantNodos++;
	}

	@Override
	public void eliminarVertice(E v) {
		int indice = indiceDelVertice(v);
		for(int i = 0 ; i < cantNodos; i++){ mAdy[i][indice] = mAdy[i][cantNodos-1];}
		
		for(int k = 0; k < cantNodos; k ++) {mAdy[indice][k] = mAdy[k][cantNodos-1];}
		
		vector[indice] = vector[cantNodos-1];
		cantNodos--;	
	}
	
	// de vertice a indice
	private int indiceDelVertice(E v) {
	    for (int i = 0; i < cantNodos; i++) {
	        if (vector[i].equals(v)) {
	            return i;
	        }
	    }
	    return -1; 
	}

	@Override
	public E[] vertices() {
		@SuppressWarnings("unchecked")
		E[] salida = (E[])new Object[100];
		for(int i = 0; i < cantNodos; i ++) { salida[i] = vector[i]; }
		return salida;
	}

	@Override
	public void agregarArista(E v1, E v2, int peso) {
		int a = indiceDelVertice(v1);
		int b = indiceDelVertice(v2);
		mAdy[a][b] = peso;
	}
	
	@Override
	public void eliminarArista(E v1, E v2) {
		int a = indiceDelVertice(v1);
		int b = indiceDelVertice(v2);
		mAdy[a][b] = 0;	
	}

	@Override
	public boolean existeArista(E v1, E v2) {
		int a = indiceDelVertice(v1);
		int b = indiceDelVertice(v2);
		return mAdy[a][b] != 0;	
	}

	@Override
	public int pesoArista(E v1, E v2) {
		int a = indiceDelVertice(v1);
		int b = indiceDelVertice(v2);
		return mAdy[a][b];	
	}
	
	public int mayorCostoAristaSaliente(E v) {
		int in = indiceDelVertice(v);
	    if (in == -1) throw new MyException("Vértice no encontrado");
	    
	    int max = 0;
	    for(int i = 0 ; i < cantNodos; i++) {
	    	if(mAdy[in][i] > max) {max = mAdy[in][i];}
	    }
	    return max;

	}
	
	public List<E> predecesores(E v ){
		int in = indiceDelVertice(v);
	    if (in == -1) throw new MyException("Vértice no encontrado");
	    
	    List<E> p = new ArrayList<>();
	    for(int i = 0 ; i < cantNodos; i++) {
	    	if(mAdy[i][in] != 0) {p.addLast(vector[i]);}
	    }
	    return p;
	 }
	

}
