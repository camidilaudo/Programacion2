package ejercicio2;

import ejercicio1.Stack;

public class ArrayStack<T> implements Stack<T>{
	
// PILA : LIFO (ultimo en entrar, primero en salir)
	
	// ATRIBUTOS 
	private T[] pila;
	private int indice;
	
	
	// CONSTRUCTOR
	public ArrayStack(int size) {
		pila = (T[]) new Object[size];
		indice = 0;
	}
	
	// METODOS
	
	// crea un nuevo arreglo con el doble de largo de la lista actual y le asigna todos los elemnentos
	public void resizeArray() {
		
		T[] newArray= (T[]) new Object[2*pila.length];
		
		for(int i=0; i<pila.length; i++) {
			newArray[i]=pila[i];
		}
		pila=newArray;
	}
	
	
	// agregar un elemento
	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
	    if (indice == pila.length) {
	        resizeArray();
	    }
	    pila[indice] = item;
	    indice++;
	
	}

	
	// eliminar el ultimo elemento y lo devuelve
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

	
	// muestra el ultimo elemento
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



}
