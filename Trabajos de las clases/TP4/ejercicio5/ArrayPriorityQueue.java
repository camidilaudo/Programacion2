package ejercicio5;

public class ArrayPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

	// con arreglo circular
	
    private Entrada<K, V>[] array;
    private int size;
    private int front;
    private int tail;

    public ArrayPriorityQueue(int capacity) {
        array = (Entrada<K, V>[]) new Entrada[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public Entry<K, V> min() {
		if (isEmpty()) {
			throw new MyException("Cola vacía");
		}
		return array[front];
	}

    @Override
    public void insert(K key, V value) {
        // Verifica si la cola está llena (dejando un espacio vacío para distinguir entre llena y vacía)
        if (size == array.length - 1) {
            throw new MyException("Cola llena");
        }

        // Crea una nueva entrada con la clave y el valor dados
        Entrada<K, V> nuevoValor = new Entrada<K, V>(key, value);

        // Si la cola está vacía, simplemente inserta el nuevo valor en la posición de tail
        if (size == 0) {
            array[tail] = nuevoValor;
        } else {
            // Comenzamos desde el nodo anterior a tail
            int i = tail - 1;

            if (tail > front) {
                // Si tail está después de front (sin envolver), se puede recorrer de forma lineal
                while (i >= front && nuevoValor.getKey().compareTo(array[i].getKey()) < 0) {
                    array[(i + 1) % array.length] = array[i];  // Desplaza los elementos hacia la derecha
                    i--;
                }
            } else {
                // Si tail ha envuelto, primero se recorren los elementos desde i hasta 0
                while (i >= 0 && nuevoValor.getKey().compareTo(array[i].getKey()) < 0) {
                    array[(i + 1) % array.length] = array[i];
                    i--;
                }
                // Si aún no se encontró la posición, continúa desde el final del arreglo hasta front
                if (i < 0) {
                    i = array.length - 1;
                    while (i >= front && nuevoValor.getKey().compareTo(array[i].getKey()) < 0) {
                        array[(i + 1) % array.length] = array[i];
                        i--;
                    }
                }
            }
            // Inserta el nuevo valor en la posición encontrada
            array[i + 1] = nuevoValor;
        }

        // Actualiza tail y el tamaño de la cola
        tail = (tail + 1) % array.length;
        size++;
    }


    @Override
    public Entry<K, V> removeMin() {
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
