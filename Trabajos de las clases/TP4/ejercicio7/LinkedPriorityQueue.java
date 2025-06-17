package ejercicio7;

import ejercicio6.Entrada;
import ejercicio6.Entry;
import ejercicio6.PriorityQueue;
import ejercicio6.MyException;

public class LinkedPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    private Node<K, V> head;
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
        return head == null;
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            throw new MyException("La cola de prioridad está vacía.");
        }
        return head.entry;
    }

    @Override
    public void insert(K key, V value) {
    	
        if (key == null) {
            throw new MyException("La clave no puede ser null.");
        }

        
        Entrada<K, V> newEntry = new Entrada<>(key, value);
        Node<K, V> newNode = new Node<>(newEntry);

        
        // si no hay elementos o la clave es menor a 0 
        if (head == null || key.compareTo(head.entry.getKey()) < 0) {
            newNode.next = head;
            head = newNode;
        } 
        
        else {
            Node<K, V> current = head;
            
            // mientras exista un siguiente y que la key sea mayor a las claves de los nodos, se sigue avanzando 
            while (current.next != null && key.compareTo(current.next.entry.getKey()) >= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            throw new MyException("La cola de prioridad está vacía.");
        }

        Entry<K, V> removed = head.entry;
        head = head.next;
        size--;
        return removed;
    }
}
