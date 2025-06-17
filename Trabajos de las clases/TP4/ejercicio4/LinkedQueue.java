package ejercicio4;

public class LinkedQueue<A> implements Queue<A>{
	
	private Node<A> front;
	private Node<A> tail;
	private int size;
	
	public LinkedQueue() {
		front = null;
		size=0;
	}
	

	@Override
	public void enqueue(A element) {
		// TODO Auto-generated method stub
		Node<A> newNode = new Node<A>(element, front);
		if(size==0) front = newNode;
		else {tail.setNext(newNode);}
		tail = newNode;
		size++;
		
	}

	@Override
	public A dequeue() {
		// TODO Auto-generated method stub
		A aux = front.getElement();
		front = front.getNext();
		size--;
		
		return aux;
	}

	@Override
	public A fornt() {
		// TODO Auto-generated method stub
		return front.getElement();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

}
