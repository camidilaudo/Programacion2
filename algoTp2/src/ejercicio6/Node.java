package ejercicio6;

public class Node {
	
	 protected Node next;
	 protected float temperatura;
	
	//constructor
	public Node(float temperatura){
		this.temperatura = temperatura; 
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public float getElement() {
		return temperatura;
	}
	public void setElement(float temperatura) {
		this.temperatura = temperatura;
	}	
}