package ejercicio7;

import java.util.Iterator;


public class LinkedList<A> implements List<A>, Iterable<A> {
	
	private Node<A> head;
	private int size;
	private Node<A> current;
	private Node<A> tail;
	
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

	public void addFirst(A newElement){
		Node<A> n=new Node<A>(newElement);
		if (size==0)tail=n;
		else {n.setNext(head);}
		head=n;
		size++;
	}
	
	public void addLast(A newElement){
		Node<A> n=new Node<A>(newElement);
		if (head == null) {
		    head = n;
		    tail = n;
		} else {
		    tail.setNext(n);
		    tail = n;
		}
		size++;
	}

	public void removeFirst()throws MyException{
		if(head==null)
			throw new MyException("La lista está vacia, no se puede eliminar primero");
		Node<A> aux=head.getNext();
		head.setNext(null);
		head=aux;
		size--;
	}
	
	public void removeLast()throws MyException{
		if(head==null)
			throw new MyException("La lista está vacia, no se puede eliminar ultimo");
		if(size==1)
			head=null;
		else{
			Node<A> aux=head;
			Node<A> aux2=aux.getNext();
			while(aux2.getNext()!=null){aux=aux2;aux2=aux2.getNext();}
			tail = aux;
			tail.setNext(null);

		}
		size--;
	}
	
	public void remove(A element) throws MyException {
	    if (head == null) 
	        throw new MyException("La lista está vacía, no se puede eliminar");
	    
	    // Si el elemento es el primero
	    if (element.equals(head.getElement())) {
	        removeFirst();
	        return;  // Salimos del método si ya se eliminó el primer nodo
	    }

	    // Si el elemento es el último
	    if (element.equals(tail.getElement())) {
	        removeLast();
	        return;  // Salimos del método si ya se eliminó el último nodo
	    }

	    // Si el elemento está en el medio de la lista
	    Node<A> aux = head;
	    while (aux != null && !aux.getNext().getElement().equals(element)) {
	        aux = aux.getNext();
	    }

	    if (aux == null) {
	        throw new MyException("El elemento no pertenece a la lista, no se puede eliminar");
	    }

	    // El nodo a eliminar es aux.getNext()
	    Node<A> aEliminar = aux.getNext();
	    aux.setNext(aEliminar.getNext()); // Enlazar el nodo anterior al siguiente
	    aEliminar.setNext(null);

	    // Si el nodo a eliminar es el tail, actualizar tail
	    if (aEliminar == tail) {
	        tail = aux;
	    }

	    size--;
	}

	
	public void removeAll(A element)throws MyException{
		if(head==null)
			throw new MyException("La lista está vacia, no se puede eliminar");
		Node<A> aux=head;
		while(aux!=null) 
		{
			if(aux.getElement().equals(element))
				remove(element);
			aux=aux.getNext();
		}
		
	}
	
	public void First(){current=head;}
	
	public void advance()throws MyException{
		if(current==null)
			throw new MyException("Fuera de lista");
		else
			current=current.getNext();
	}
	
	public A getCurrent()throws MyException{
		if(current==null)
			throw new MyException("No se puede devolver el nodo actual porque es nulo");
		return current.getElement();
	}
	
	public boolean atEnd(){return current==null;}
	
	public int getSize() {
		return size;
	}
	
	public A elementAt(int pos) {
		if(pos>size) {
			throw new MyException("El índice está fuera del rango de la lista");
		}
		Node<A> aux=head;
		int contador=0;
		while(contador<pos) {
			aux=aux.getNext();
			contador++;
		}
		return aux.getElement();
	}
	
	public void removeAt(int pos) {
	    if (pos >= size) {
	        throw new MyException("El índice está fuera del rango de la lista");
	    }

	    if (size == 1) {
	        head = null;
	        size--;
	        return;
	    }

	    if (pos == 0) {
	        removeFirst(); 
	        return;
	    }

	    Node<A> aux = head;
	    int contador = 0;
	    while (contador < pos - 1) {
	        aux = aux.getNext();
	        contador++;
	    }

	    Node<A> aEliminar = aux.getNext();
	    aux.setNext(aEliminar.getNext());
	    aEliminar.setNext(null);
	    size--;
	}

	
	public void printList() {
	    if (head == null) {
	        System.out.println("La lista está vacía.");
	        return;
	    }

	    Node<A> current = head;
	    while (current != null) {
	        System.out.print(current.getElement() + " ");
	        current = current.getNext();
	    }
	    System.out.println(); 
	}
	
	@Override
	public Iterator<A> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<A> {
		
		private Node<A> current = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public A next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new MyException("No existe elemento siguiente");
			}
			A elem = current.getElement();
			current = current.getNext();
			return elem;
		}
		
	}

}
