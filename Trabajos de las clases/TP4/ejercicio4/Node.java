package ejercicio4;

public class Node<A> {
	 
	private Node<A> next;
	private A element;
	
	public Node(A element, Node<A> next) {
		this.element = element;
		this.next = next;
	}

	public Node<A> getNext() {
		return next;
	}

	public void setNext(Node<A> next) {
		this.next = next;
	}

	public A getElement() {
		return element;
	}

	public void setElement(A element) {
		this.element = element;
	}

}
