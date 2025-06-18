package PriorityLinked;

public class LinkedPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private Node<Entrada<K,V>> head;
    private int size;

    public LinkedPriorityQueue() {
        head = null;
        size = 0;
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
            throw new MyException("La cola de prioridad está vacía.");
        }
        return head.getElement();
    }

    @Override
    public void insert(K key, V value) {
        Entrada<K,V> elementoNodo = new Entrada<K,V>(key, value);
        Node<Entrada<K,V>> nuevoNodo = new Node<>(elementoNodo, null);

        // Caso 1: Insertar al principio si la lista está vacía o la clave es la menor
        if (size == 0 || head.getElement().getKey().compareTo(key) > 0) {
            nuevoNodo.setNext(head);
            head = nuevoNodo;
        } else {
            // Caso 2: Buscar la posición correcta en la lista
            Node<Entrada<K,V>> actual = head;
            while (actual.getNext() != null && actual.getNext().getElement().getKey().compareTo(key) < 0) {
                actual = actual.getNext();
            }
            // Insertamos el nuevo nodo después del nodo actual
            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
        }
        size++;
    }

    @Override
    public Entry<K, V> removeMin() {
        if (size == 0) {
            throw new MyException("La cola de prioridad está vacía.");
        }

        Entrada<K, V> removed = head.getElement();
        head = head.getNext();
        size--;
        return removed;
    }
}
