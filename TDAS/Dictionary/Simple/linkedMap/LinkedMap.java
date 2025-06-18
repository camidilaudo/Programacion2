package linkedMap;

import java.util.Arrays;

public class LinkedMap<K extends Comparable<K>, V> implements Map<K, V> {

    private int size;
    private Node<Entrada<K, V>> head;
    private Node<Entrada<K, V>> tail;

    public LinkedMap() {
        size = 0;
        head = null;
        tail = null;
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
    public V get(K k) {
        if (k == null || size == 0) {
            return null;
        }
        Node<Entrada<K, V>> current = findNode(k);
        return (current != null) ? current.getElement().getValue() : null;
    }

    @Override
    public V put(K k, V v) {
        if (k == null) throw new IllegalArgumentException("Clave no puede ser null");

        Node<Entrada<K, V>> current = findNode(k);

        if (current != null) {
            V oldValue = current.getElement().getValue();
            current.getElement().setValue(v);
            return oldValue;
        }

        // Si el nodo no existe, agregamos uno nuevo al final
        Entrada<K, V> entrada = new Entrada<>(k, v);
        Node<Entrada<K, V>> nuevoNodo = new Node<>(entrada, null, tail);
        if (tail != null) {
            tail.setNext(nuevoNodo);
        }
        tail = nuevoNodo;

        if (head == null) {
            head = nuevoNodo;
        }
        size++;
        return null;
    }

    @Override
    public V remove(K k) {
        if (k == null || size == 0) return null;

        Node<Entrada<K, V>> current = findNode(k);

        if (current != null) {
            V value = current.getElement().getValue();
            // Conectar los nodos vecinos
            if (current.getPrevious() != null) {
                current.getPrevious().setNext(current.getNext());
            } else {
                head = current.getNext();
            }
            if (current.getNext() != null) {
                current.getNext().setPrevious(current.getPrevious());
            } else {
                tail = current.getPrevious();
            }
            size--;
            return value;
        } else {
            return null;
        }
    }

    private Node<Entrada<K, V>> findNode(K k) {
        Node<Entrada<K, V>> current = head;
        while (current != null && !current.getElement().getKey().equals(k)) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public K[] keys() {
        K[] claves = (K[]) new Object[size];
        Node<Entrada<K, V>> current = head;
        int i = 0;
        while (current != null) {
            claves[i++] = current.getElement().getKey();
            current = current.getNext();
        }
        return claves;
    }

    @Override
    public V[] values() {
        V[] valores = (V[]) new Object[size];
        Node<Entrada<K, V>> current = head;
        int i = 0;
        while (current != null) {
            valores[i++] = current.getElement().getValue();
            current = current.getNext();
        }
        return valores;
    }

    @Override
    public Entry<K, V>[] entries() {
        Entry<K, V>[] entradas = (Entry<K, V>[]) new Entrada[size];
        Node<Entrada<K, V>> current = head;
        int i = 0;
        while (current != null) {
            entradas[i++] = current.getElement();
            current = current.getNext();
        }
        return entradas;
    }

    public K[] sorted() {
        K[] claves = keys();
        Arrays.sort(claves); // Usa el método sort de Arrays para ordenar
        return claves;
    }
}
