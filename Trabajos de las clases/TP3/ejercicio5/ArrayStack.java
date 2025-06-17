package ejercicio5;

import ejercicio1.Stack;

public class ArrayStack<T> implements Stack<T>{
	
	private T[] pila;
	private int indice;
	
	public ArrayStack(int size) {
		pila = (T[]) new Object[size];
		indice = 0;
	}

	public void resizeArray() {
		T[] newArray= (T[]) new Object[2*pila.length];
		for(int i=0; i<pila.length; i++) {
			newArray[i]=pila[i];
		}
		pila=newArray;
	}
	
	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		if (indice==pila.length) {
			resizeArray();
		}
		else {
			pila[indice] = item;
			indice++;
		}
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (indice==0) {
			throw new MyException("La pila esta vacia");
		}
		else {
			T aux= pila[--indice];
			pila[indice]=null;
			return aux;
		}
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (indice==0) {
			throw new MyException("No hay elementos en la pila.");
		}
		else {
			return pila[indice-1];
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return indice==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return indice;
	}
	
	public <T> void invertir(ArrayStack<T> A) {
	    ArrayStack<T> aux = new ArrayStack<>(A.size());
	    ArrayStack<T> inversa = new ArrayStack<>(A.size());

	    while (!A.isEmpty()) {
	        aux.push(A.pop());
	    }

	    while (!aux.isEmpty()) {
	        inversa.push(aux.pop());
	    }

	    while (!inversa.isEmpty()) {
	        A.push(inversa.pop());
	    }
	}

	
	public void invertir(Persona[] A) {
	    ArrayStack<Persona> pila = new ArrayStack<>(A.length);

	    // poner todas las personas en la pila (esto invierte el orden)
	    for (int i = 0; i < A.length; i++) {
	        pila.push(A[i]);
	    }

	    // extraer las personas de la pila y devolverlas al arreglo (esto las pone en orden invertido)
	    for (int i = 0; i < A.length; i++) {
	        A[i] = pila.pop();
	    }
	}


}
