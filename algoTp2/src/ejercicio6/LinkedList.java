package ejercicio6;

public class LinkedList {
	
	// ATRIBUTOS
	private Node head;
	private Node current;
	private int size;
	
	
	// CONSTRUCTOR
	public LinkedList() {
		head=null;
		size=0;
	}
	
	// METODOS
	
	// agrego un nuevo nodo  
	public void agregarTemp(Node nuevaTemp) {
		
		// sino hay ningun elemento, le asigno head al nuevo elemento
		if(head==null) {
			head=nuevaTemp;}
		
		else {
			// recorro hasta el final y agrego el nuevo elemento
			current = head;
			while(current.getNext()!=null)
				current=current.getNext();
			current.setNext(nuevaTemp);
		}
		size++;
	}

	
	// agrego el elemento de temeprtura
	public void agregarTemp(float nuevaTemp) {
		Node nuevoNodo = new Node(nuevaTemp);
		agregarTemp(nuevoNodo);
	}
	
	
	// recorre todos los nodos y devuelve el mayor elemento
	public float getMayorTemp() {
		if (size==0) throw new MyException("Arreglo vacio");

		float mayor = head.temperatura;
		current = head.next;
		while (current!=null) {
			if (current.temperatura > mayor) {
				mayor = current.temperatura;
			}
			current = current.next;		
		}
		return mayor;
	}
	
	
	// devuelve un promedio de todos los elementos
	public float promTemp() {
		if (size==0) throw new MyException("Arreglo vacio");
		
		float suma = head.temperatura;
		Node actual = head.next;
		while(actual.next != null) {
			suma += actual.temperatura;
			actual = actual.next;
		}
		return suma / size;
	}
	
	
	// recorre todos los nodos y devurlve la cantidad de elementos menor a 0
	public int cantHeladas() {
		
		Node actual = head;
		int heladas = 0;
		while (actual != null) {
			if (actual.temperatura < 0) { heladas++; }
			actual = actual.next;
		}
		return heladas;
	}
	
	// devuelve true si hay un elemento menor a 0
	public boolean huboHeladas() {
		Node actual = head;

		while (actual!=null) {
			if (actual.temperatura<0) {return true;}
			actual = actual.next;
			}
		return false;
	}
	
	// compara los dos nodos y devuelve el mayor elemento
	public float mayorTemp(float tempDada) {
		
		Node actual = head;
		while (actual!= null) {
			if(actual.temperatura>tempDada) {return actual.temperatura;}
			actual = actual.next;
		}
		return tempDada;
	}
	
	
	// devuelve true si los elementos de los nodos estan de menor a mayor
	public boolean ordenCreciente() {
		
		current = head;
		float menor = current.temperatura;
		while(current!=null) {
			if (current.temperatura > current.next.temperatura) {return false;}
			current = current.next;
		}
		return true;
	}
	
	// recorre todos los nodos y devuelve la menor temperatura
	public float getMenorTemp() {
		if (size==0) throw new MyException("Arreglo vacio");

		float menor = head.temperatura;
		current = head.next;
		while (current!=null) {
			if (current.temperatura < menor) {
				menor = current.temperatura;
			}
			current = current.next;		
		}
		return menor;
	}
	
	
	// devuelve la posicion de la menor temperatura
	public int posMenorTemp() {
		if (size==0) throw new MyException("Arreglo vacio");

		float menor = head.temperatura;
		int posMenor = 0;
		int index=0;
		current = head;		
		while(current != null) {
			if(current.temperatura<menor) {
				menor=current.temperatura;
				posMenor = index;
			}
			current = current.next;
			index++;
		}
		return posMenor;
	}
		
	
	// devuelve true si todos los elementos son posistivos
	public boolean todosPos() {
		if(size==0)throw new MyException("Lista Vacia");
		
		Node actual = head;
		while (actual!= null) {
			if(actual.temperatura<0)return false;
			actual = actual.next;
		}
		return true;
	}
	
	
	// compara las dos listas enzaladas y devuelve la cantidad de coincidencias
	public int contarCoincidencias(LinkedList otra) {
        int coincidencias = 0;
        Node a = this.head;
        Node b = otra.head;

        while (a != null && b != null) {
            if (a.temperatura == b.temperatura) {
                coincidencias++;
            }
            a = a.next;
            b = b.next;
        }
        return coincidencias;
    }
	
	// invierte la lista
	public LinkedList invertir() {
	    LinkedList invertida = new LinkedList();
	    Node actual = head;
	    
	    while (actual != null) {
	        Node nuevo = new Node(actual.temperatura); 
	        nuevo.next = invertida.head; 
	        invertida.head = nuevo; 
	        invertida.size++;
	        actual = actual.next;
	    }
	    
	    return invertida;
	}

	
	
	// reemeplaza el elemento 1 por el valor 2
	public void reemplazar(float val1, float val2) {
        Node actual = head;
        while (actual != null) {
            if (actual.temperatura == val1) {
                actual.temperatura = val2;
            }
            actual = actual.next;
        }
    }
	
	
	// intercambia los elementos de la posicion 1 con la 2
	public String intercambiar(int pos1, int pos2) {
        if (pos1 >= size || pos2 >= size) {
            throw new MyException("No existen las posiciones");
        }

        if (pos1 == pos2) return "";

        Node nodo1 = head;
        Node nodo2 = head;

        for (int i = 0; i < pos1; i++) nodo1 = nodo1.next;
        for (int i = 0; i < pos2; i++) nodo2 = nodo2.next;

        float aux = nodo1.temperatura;
        nodo1.temperatura = nodo2.temperatura;
        nodo2.temperatura = aux;

        return "";
    }
	
	
	// imprime la lista 
	public static void imprimirLista(LinkedList lista) {
        Node actual = lista.head;
        while (actual != null) {
            System.out.print(actual.temperatura + " ");
            actual = actual.next;
        }
        System.out.println();
    }

	

}
