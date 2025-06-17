package ejercicio3;

import ejercicio1.Stack;

public class LinkedStack<T> implements Stack<T>{
	
	private Node<T> top;
	private int  size;
	
	public LinkedStack() {
		top = null;
		size=0;
	}

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		Node<T> newNode = new Node<T>(item);
		newNode.setNext(top);
		top = newNode;
		size++;
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(top==null)
			throw new MyException("La lista está vacia");
	    T value = top.getElement();    // Guardo el valor del nodo que es top
	    top = top.getNext();           // Cambia top al siguiente nodo
	    size--;                       
	    return value; 

	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (top==null) {
			throw new MyException("La lista esta vacia");
		}
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void printStack() {
	    Node<T> current = top;
	    while (current != null) {
	        System.out.println(current.getElement());
	        current = current.getNext();
	    }
	}

	

}
