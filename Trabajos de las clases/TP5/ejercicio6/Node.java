package ejercicio6;

public class Node<E> {
	
	private E element;
	private Node<E> next;
	private Node<E> previous;

	//constructores
	public Node(E newElement, Node<E> n, Node<E> p){
		element=newElement; 
		next=n;
		previous=p;

	}
	public Node(E newElement){
		element=newElement; 
		next=null;
		previous=null;
	}
	public Node(){
		element=null; 
		next=null;
		previous=null;
	}
	//metodos
	public E getElement(){
		return element;
	}
	public Node<E> getNext(){
		return next;
	}
	public void setElement(E newElement){
		element=newElement;
	}
	public void setNext(Node<E> n){
		next=n;
	}
	public Node<E> getPrevious() {
		return previous;
	}
	public void setPrevious(Node<E> previus) {
		this.previous = previus;
	}

}
