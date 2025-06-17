package ejercicio7;

import ejercicio6.*;

public class Node<K extends Comparable<K>, V> {
    Entry<K, V> entry;
    Node<K, V> next;

    public Node(Entry<K, V> entry) {
        this.entry = entry;
    }
}
