package ejercicio3;

public class GrafoDin<E> implements GrafoTDA<E> {
	private NodoVertice<E> origen;
	private int vertices;
	
	public GrafoDin() {
		origen = null;
	}
	
	public void agregarVertice(E v) { //El vértice se inserta al inicio de la lista de nodos
		NodoVertice<E> aux = new NodoVertice<E>();
		aux.setVertice(v);
		aux.setAristas(null);
		aux.setSigVertice(origen);
		origen = aux;
		vertices++;
	}
	
	
	
	public void eliminarVertice(E v) {
		if (origen.getVertice().equals(v)) //Es el origen
			origen = origen.getSigVertice(); //Se elimina el origen
		NodoVertice<E> aux = origen; //No es el origen; hay que buscarlo
		while (aux != null) { //Eliminamos aristas hacia v
			this.eliminarAristaNodo(aux, v);
			if (aux.getSigVertice() != null && aux.getSigVertice().getVertice().equals(v)) {
				aux.setSigVertice(aux.getSigVertice().getSigVertice()); //Si es el nodo, lo elimina
				vertices--;
			}
			aux = aux.getSigVertice(); //Sigue eliminando aristas
		}
		
	}
	
	private void eliminarAristaNodo(NodoVertice<E> nodo, E v) {
		NodoArista<E> aux = nodo.getAristas(); //Elimina de nodo las aristas hacia v
		if (aux != null) {
			if (aux.getVerticeDestino().getVertice().equals(v)) { //Hay que eliminar la primera arista
				nodo.setAristas(aux.getSigArista());
			} 
			else { //No es la primera; la buscamos
				while (aux.getSigArista() != null && !aux.getSigArista().getVerticeDestino().getVertice().equals(v))
					aux = aux.getSigArista();
				if (aux.getSigArista() != null) { //Eliminamos la arista
					aux.setSigArista(aux.getSigArista().getSigArista());
				}
			}
		}
	}
	
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
	
	public void agregarArista(E v1, E v2, int peso ) {
		NodoVertice<E> n1 = vert2Nodo(v1); //Buscamos el nodo origen...
		NodoVertice<E> n2 = vert2Nodo(v2); //... y el nodo destino
		NodoArista<E> aux = new NodoArista<E>(); //La arista va al inicio de la lista...
		aux.setPeso(peso); //... de aristas salientes de v1
		aux.setVerticeDestino(n2);
		aux.setSigArista(n1.getAristas());
		n1.setAristas(aux);
	}
	
	private NodoVertice<E> vert2Nodo(E v) { //Dado un valor, busca el nodo correspondiente
		NodoVertice<E> aux = origen;
		while (aux != null && !aux.getVertice().equals(v))
			aux = aux.getSigVertice();
		return aux;
	}
	
	public void eliminarArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		eliminarAristaNodo(n1, v2);
	}
	
	public boolean existeArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (aux != null && !aux.getVerticeDestino().getVertice().equals(v2)) {
			aux = aux.getSigArista();
		}
		//Solo si se encontro la arista buscada, aux no es null
		return aux != null;
	}
	
	public int pesoArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (!aux.getVerticeDestino().getVertice().equals(v2))
			aux = aux.getSigArista(); //Buscamos la arista
		return aux.getPeso();
	}
	
	public List<E> verticesAislados() {
	    List<E> aislados = new ArrayList<>();
	    NodoVertice<E> actual = origen;

	    while (actual != null) {
	        boolean tieneEntrantes = false;
	        boolean tieneSalientes = (actual.getAristas() != null);

	        NodoVertice<E> otro = origen;
	        while (otro != null && !tieneEntrantes) {
	            NodoArista<E> arista = otro.getAristas();
	            while (arista != null) {
	                if (arista.getVerticeDestino().getVertice().equals(actual.getVertice())) {
	                    tieneEntrantes = true;
	                    break;
	                }
	                arista = arista.getSigArista();
	            }
	            otro = otro.getSigVertice();
	        }

	        if (!tieneEntrantes && !tieneSalientes) {
	            aislados.addLast(actual.getVertice());
	        }

	        actual = actual.getSigVertice();
	    }

	    return aislados;
	}

	public List<E> verticesPuente(E v1, E v2) {
	    List<E> puentes = new ArrayList<>();
	    NodoVertice<E> nodoV1 = vert2Nodo(v1);
	    NodoVertice<E> nodoV2 = vert2Nodo(v2);

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
