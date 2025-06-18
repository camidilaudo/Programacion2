package PriorityArray;

// Cola de prioridad basada en un arreglo circular ordenado
public class ArrayPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

	private Entrada<K, V>[] array;  
	private int front;               
	private int rear;              
	private int size;             

 	public ArrayPriorityQueue() {
		array = (Entrada<K, V>[]) new Entrada[10];
		front = 0;
		rear = 0;
		size = 0;
	}

	// Constructor con capacidad inicial personalizada
	public ArrayPriorityQueue(int initialSize) {
		array = (Entrada<K, V>[]) new Entrada[initialSize];
		front = 0;
		rear = 0;
		size = 0;
	}
	
	private void resize() {
	    Entrada<K, V>[] nuevo = (Entrada<K, V>[]) new Entrada[array.length * 2];
	    for (int i = 0; i < size; i++) {
	        nuevo[i] = array[(front + i) % array.length];
	    }
	    array = nuevo;
	    front = 0;
	    rear = size;
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// Está vacía si front y rear apuntan al mismo índice
		return front == rear;
	}

	@Override
	public Entry<K, V> min() {
		// Devuelve el elemento con menor clave (que está al frente)
		if (isEmpty()) {
			throw new MyException("Cola vacía");
		}
		return array[front];
	}

	@Override
	public void insert(K key, V value) {
		if (size == array.length) {
		    resize();
		}
		Entrada<K, V> nuevoValor = new Entrada<K, V>(key, value);

		// Si está vacía, simplemente insertamos en rear
		if (size == 0) {
			array[rear] = nuevoValor;
		} else {
			int i = rear - 1;

			// Caso donde rear está por delante de front (no hay ciclo)
			if (rear > front) {
				// Desplazamos elementos con claves mayores hacia la derecha
				while (i >= front && nuevoValor.getKey().compareTo(array[i].getKey()) < 0) {
					array[(i + 1) % array.length] = array[i];
					i--;
				}
			} else {
				// rear < front: el buffer está en modo circular
				// desplazamos desde el final del arreglo hacia el frente
				while (i >= 0 && nuevoValor.getKey().compareTo(array[i].getKey()) < 0) {
					array[(i + 1) % array.length] = array[i];
					i--;
				}
				if (i < 0) {
					i = array.length - 1;
					while (i >= front && nuevoValor.getKey().compareTo(array[i].getKey()) < 0) {
						array[(i + 1) % array.length] = array[i];
						i--;
					}
				}
			}
			// Insertamos el nuevo valor en su posición correcta
			array[i + 1] = nuevoValor;
		}
		// Avanzamos rear en modo circular
		rear = (rear + 1) % array.length;
		size++;
	}

	@Override
	public Entry<K, V> removeMin() {
		// Elimina y retorna el elemento con menor clave (en front)
		if (isEmpty()) {
			throw new MyException("Cola vacía");
		}
		Entrada<K, V> salida = array[front];
		array[front] = null;
		front = (front + 1) % array.length;
		size--;
		return salida;
	}
}
