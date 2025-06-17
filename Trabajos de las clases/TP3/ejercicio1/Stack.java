package ejercicio1;

public interface Stack <T>{
	
	// MODELO LIFO (LAST IN, FIRST OUT)
	
	// AGREGA UN ELEMENTO A LA PILA
	public void push(T item); 
	// ELIMINA EL ULTIMO ELEMENTO DE LA PILA
	public T pop();
	// MUESTRA EL ULTIMO ELEMENTO DE LA PILA
	public T top();
	// TRUE SI ESTA VACIO
	public boolean isEmpty();
	// TAMANIO DE LA PILA
	public int size(); 


}
