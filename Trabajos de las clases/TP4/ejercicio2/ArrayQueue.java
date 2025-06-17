package ejercicio2;

import ejercicio1.Queue;

public class ArrayQueue<A> implements Queue<A>{
	
// COLA = LIFO (primero que entra, primero que sale)
	
	
	// ATRIBUTOS
	private A[] array;
	private int front;
	private int tail;
	private int size;
	
	
	// CONSTRUCTOR
	public ArrayQueue(int capacidad) {
		array = (A[]) new Object [capacidad];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	// METODOS 
	
	// agrega un elemento
	@Override
	public void enqueue(A elemento) {
		// TODO Auto-generated method stub
		if (size==array.length) {
			throw new MyException("La cola esta llena jdjsd");
		}
		else {
			array[tail]=elemento;
			size++;
			tail=(tail+1)%array.length;
		}
	}

	@Override
	public A dequeue() {
		// TODO Auto-generated method stub
		if (size==0) {
			throw new MyException("La cola esta vacia");

		}
		else {
			A aux = array[front];
			array[front] = null;
			size--;
			front = (front+1) % array.length;
			return aux;
			
		}
	}

	@Override
	public A front() {
		// TODO Auto-generated method stub
		if (size==0) {
			throw new MyException("La cola esta vacia");

		}
		else {
			return array[front];
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size==0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	

}
