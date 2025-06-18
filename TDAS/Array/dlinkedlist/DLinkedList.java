package dlinkedlist;


public class DLinkedList<E> implements List<E> {
	private Node<E> head;
	private Node<E> tail;
	private Node<E> current;
	private int size;

	public DLinkedList() {
		head = null;
		tail = null;
		current = null;
		size = 0;
	}

	public void addFirst(E newElement) {
		Node<E> n = new Node<>(newElement);
		if (size == 0) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head.setPrevious(n);
			head = n;
		}
		size++;
	}

	public void addLast(E newElement) {
		Node<E> n = new Node<>(newElement);
		if (size == 0) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			n.setPrevious(tail);
			tail = n;
		}
		size++;
	}

	public void removeFirst() {
		if (head == null)
			throw new MyException("La lista está vacía");

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.getNext();
			head.setPrevious(null);
		}
		size--;
	}

	public void removeLast() {
		if (tail == null)
			throw new MyException("La lista está vacía");

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		size--;
	}

	public void remove(E element) {
		if (head == null)
			throw new MyException("La lista está vacía");

		if (element.equals(head.getElement())) {
			removeFirst();
			return;
		}
		if (element.equals(tail.getElement())) {
			removeLast();
			return;
		}

		Node<E> aux = head.getNext();
		while (aux != null) {
			if (element.equals(aux.getElement())) {
				Node<E> prev = aux.getPrevious();
				Node<E> next = aux.getNext();
				prev.setNext(next);
				if (next != null) {
					next.setPrevious(prev);
				} else {
					tail = prev;
				}
				aux.setNext(null);
				aux.setPrevious(null);
				size--;
				return;
			}
			aux = aux.getNext();
		}

		throw new MyException("El elemento no está en la lista");
	}

	public void removeAll(E element) {
		if (head == null)
			throw new MyException("La lista está vacía");

		Node<E> aux = head;
		while (aux != null) {
			Node<E> next = aux.getNext();
			if (element.equals(aux.getElement())) {
				remove(aux.getElement());
			}
			aux = next;
		}
	}

	public void First() {
		current = head;
	}

	public void Last() {
		current = tail;
	}

	public void advanceR() {
		if (current == null)
			throw new MyException("Fuera de lista");
		current = current.getNext();
	}

	public void advanceL() {
		if (current == null)
			throw new MyException("Fuera de lista");
		current = current.getPrevious();
	}

	public E getCurrent() {
		if (current == null)
			throw new MyException("El nodo actual es nulo");
		return current.getElement();
	}

	public boolean atEnd() {
		return current == null;
	}

	public int getSize() {
		return size;
	}

	public E elementAt(int pos) {
		if (pos < 0 || pos >= size)
			throw new MyException("Índice fuera de rango");

		Node<E> aux = head;
		for (int i = 0; i < pos; i++) {
			aux = aux.getNext();
		}
		return aux.getElement();
	}

	public void removeAt(int pos) {
		if (pos < 0 || pos >= size)
			throw new MyException("Índice fuera de rango");

		if (pos == 0) {
			removeFirst();
			return;
		}
		if (pos == size - 1) {
			removeLast();
			return;
		}

		Node<E> aux = head;
		for (int i = 0; i < pos; i++) {
			aux = aux.getNext();
		}
		Node<E> prev = aux.getPrevious();
		Node<E> next = aux.getNext();
		prev.setNext(next);
		next.setPrevious(prev);
		aux.setNext(null);
		aux.setPrevious(null);
		size--;
	}	
	
	public void printList() {
	    if (head == null) {
	        System.out.println("La lista está vacía.");
	        return;
	    }

	    Node<E> currentNode = head;
	    while (currentNode != null) {
	        System.out.print(currentNode.getElement() + " ");
	        currentNode = currentNode.getNext();
	    }
	    System.out.println();  
	}
	
}
