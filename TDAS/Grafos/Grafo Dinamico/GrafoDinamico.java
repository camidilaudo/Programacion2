package Grafo;

import arrayList.*;

public class GrafoDinamico<E extends Comparable<E>> implements GrafoTDA<E> {
	
	private int vertices;
	private NodoVertice<E> origen;
	
	public GrafoDinamico() {origen = null;}

	@Override
	public void agregarVertice(E v) {
		NodoVertice<E> nuevo = new NodoVertice<>();
		nuevo.setVertice(v);
		nuevo.setAristas(null);
		nuevo.setSigVertice(origen);
		origen = nuevo;
		vertices++;
	}

	@Override
	public void eliminarVertice(E v) {
		if(origen.getVertice().equals(v)) {
			origen = origen.getSigVertice();
		}
		NodoVertice<E> aux = origen;
		while (aux != null) {
			this.eliminarAristaNodo(aux, v);
			if(aux.getSigVertice() != null && aux.getSigVertice().getVertice().equals(v)) {
				aux.setSigVertice(aux.getSigVertice().getSigVertice());
				vertices --;
			}
			aux = aux.getSigVertice();
		}
	}

	private void eliminarAristaNodo(NodoVertice<E> nodo, E v) {
		NodoArista<E> aux = nodo.getAristas();
		
		if(aux != null) { 
			// es la primera
			if(aux.getVerticeDestino().getVertice().equals(v)) {
				nodo.setAristas(aux.getSigArista());
			}
			// buscamos 
			else {
				while(aux.getSigArista() != null && !aux.getSigArista().getVerticeDestino().getVertice().equals(v)) {
					aux = aux.getSigArista();
				}
				if(aux.getSigArista() != null) {
					aux.setSigArista(aux.getSigArista().getSigArista());
				}
			}
		} 
	}
	
	@Override
	public E[] vertices() {
		@SuppressWarnings("unchecked")
		E[] salida = (E[])new Object[vertices];
		NodoVertice<E> aux = origen;
		int i = 0;
		while (aux != null) {
			salida[i]=aux.getVertice();
			i++;
			aux = aux.getSigVertice();
		}
		return salida;
	}

	@Override
	public void agregarArista(E v1, E v2, int peso) {
		NodoVertice<E> n1 = buscarNodo(v1); //Buscamos el nodo origen...
		NodoVertice<E> n2 = buscarNodo(v2); //... y el nodo destino
		NodoArista<E> aux = new NodoArista<E>(); //La arista va al inicio de la lista...
		aux.setPeso(peso); //... de aristas salientes de v1
		aux.setVerticeDestino(n2);
		aux.setSigArista(n1.getAristas());
		n1.setAristas(aux);		
	}

	private NodoVertice<E> buscarNodo(E v){
		NodoVertice<E> aux = origen;
		while (aux != null && !aux.getVertice().equals(v)) {
			aux = aux.getSigVertice();
		}
		return aux;
	}

	@Override
	public void eliminarArista(E v1, E v2) {
		NodoVertice<E> n1 = buscarNodo(v1);
		eliminarAristaNodo(n1, v2);		
	}

	@Override
	public boolean existeArista(E v1, E v2) {
		NodoVertice<E> n1 = buscarNodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (aux != null && !aux.getVerticeDestino().getVertice().equals(v2)) {
			aux = aux.getSigArista();
		}
		//Solo si se encontro la arista buscada, aux no es null
		return aux != null;
	}

	@Override
	public int pesoArista(E v1, E v2) {
		NodoVertice<E> n1 = buscarNodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (!aux.getVerticeDestino().getVertice().equals(v2))
			aux = aux.getSigArista(); //Buscamos la arista
		return aux.getPeso();
	}
	
	public List<E> verticesAislados() {
	    List<E> aislados = new ArrayList<>();

	    NodoVertice<E> actual = origen;

	    // se recorren los vertices
	    while (actual != null) {
	        boolean tieneEntrantes = false;

	        // Si tiene alguna arista saliente, entonces no está aislado
	        boolean tieneSalientes = (actual.getAristas() != null);

	        // Para saber si tiene aristas entrantes, recorremos todos los vértices
	        NodoVertice<E> aux = origen;
	        while (aux != null && !tieneEntrantes) {
	            NodoArista<E> arista = aux.getAristas();

	            // Recorremos todas las aristas salientes del vértice aux
	            while (arista != null) {
	                // Si alguna apunta al vértice 'actual', entonces tiene una arista entrante
	                if (arista.getVerticeDestino().getVertice().equals(actual.getVertice())) {
	                    tieneEntrantes = true;
	                    break; // no necesitamos seguir buscando
	                }
	                arista = arista.getSigArista();
	            }
	            aux = aux.getSigVertice(); // pasamos al siguiente vértice
	        }

	        // Si no tiene aristas entrantes ni salientes, lo agregamos a la lista de aislados
	        if (!tieneEntrantes && !tieneSalientes) {
	            aislados.addLast(actual.getVertice());
	        }

	        // Avanzamos al siguiente vértice del grafo
	        actual = actual.getSigVertice();
	    }

	    return aislados;
	}
	
	public List<E> verticesPuente(E v1, E v2) {
	    List<E> puentes = new ArrayList<>();
	    NodoVertice<E> nodoV1 = buscarNodo(v1);
	    NodoVertice<E> nodoV2 = buscarNodo(v2);

	    if (nodoV1 == null || nodoV2 == null) return puentes;

	    NodoArista<E> aristaDesdeV1 = nodoV1.getAristas();
	    while (aristaDesdeV1 != null) {
	        NodoVertice<E> posiblePuente = aristaDesdeV1.getVerticeDestino();

	        // Verificamos si el posible puente tiene una arista a v2
	        NodoArista<E> aristaDesdePuente = posiblePuente.getAristas();
	        while (aristaDesdePuente != null) {
	            if (aristaDesdePuente.getVerticeDestino().getVertice().equals(v2)) {
	                puentes.addLast(posiblePuente.getVertice());
	                break; // ya lo agregamos, pasamos al siguiente
	            }
	            aristaDesdePuente = aristaDesdePuente.getSigArista();
	        }

	        aristaDesdeV1 = aristaDesdeV1.getSigArista();
	    }

	    return puentes;
	}


}
