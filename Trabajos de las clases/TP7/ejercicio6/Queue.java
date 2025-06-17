package ejercicio6;

public interface Queue<E> {
//	enqueue(e): Inserta el elemento e en el final (rear/tail) de la cola
//	dequeue(): Elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía se produce un error.
//	front(): Retorna el elemento del frente de la cola. Si la cola está vacía se produce un error.
//	isEmpty(): Retorna verdadero si la cola no tiene elementos y falso en caso contrario
//	size(): Retorna la cantidad de elementos de la cola
//	¿Se animan a armar la interfaz Queue con tipos de datos genéricos/parametrizables?
	
	public void enqueue(E elemento);
	public E dequeue();
	public E front();
	public boolean isEmpty();
	public int size();

}
