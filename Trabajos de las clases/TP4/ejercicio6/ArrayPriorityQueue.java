package ejercicio6;

public class ArrayPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private Entrada<K, V>[] array;
    private int front;  // Indica el primer elemento (mínimo)
    private int rear;   // Apunta al siguiente espacio vacío
    private int size;   // Número de elementos en la cola

    public ArrayPriorityQueue(int initialSize) {
        this.array = (Entrada<K, V>[]) new Entrada[initialSize];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        if (size == array.length - 1) {
            throw new MyException("Cola llena");
        }

        Entrada<K, V> nueva = new Entrada<>(key, value);

        // Insertamos directamente si está vacía
        if (isEmpty()) {
            array[rear] = nueva;
        } else {
            int i = (rear - 1 + array.length) % array.length;
            int pos = rear;

            while (size > 0 && key.compareTo(array[i] != null ? array[i].getKey() : key) < 0 && i != front - 1) {
                array[pos] = array[i];
                pos = i;
                i = (i - 1 + array.length) % array.length;
            }

            array[pos] = nueva;
        }

        rear = (rear + 1) % array.length;
        size++;
    }


    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            throw new MyException("Cola vacía");
        }

        // El valor mínimo está en el índice front
        Entrada<K, V> salida = array[front];
        array[front] = null; // Limpiar la referencia

        // Mover el puntero front al siguiente
        front = (front + 1) % array.length;
        size--;
        return salida;
    }
}
