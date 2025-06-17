package ejercicio7;

import java.util.Iterator;

public class DicABB<K, V extends Comparable<V>> implements TDADicABB<K, V> {

    private Node<Entrada<K, arbolBB<V>>> head;
    private Node<Entrada<K, arbolBB<V>>> tail;
    private int size;
    
    
    public DicABB() {
        this.head = null;
        this.tail = null;
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
    public arbolBB<V> get(K key) {
        if (size == 0) {
            return null;
        }
        Node<Entrada<K, arbolBB<V>>> actual = head;
        while (actual != null) {
            if (actual.getElement().getKey().equals(key)) {
                return actual.getElement().getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        arbolBB<V> arbol = get(key);
        if (arbol == null) {
    		arbolBB<V> t = new arbolBB<V>( new DefaultComparator<V>() );
            arbol.insertar(value);
            Entrada<K, arbolBB<V>> nuevaEntrada = new Entrada<>(key, arbol);
            Node<Entrada<K, arbolBB<V>>> nuevoNodo = new Node<>(nuevaEntrada);
            if (head == null) {
                head = tail = nuevoNodo;
            } else {
                tail.setNext(nuevoNodo);
                tail = nuevoNodo;
            }
            size++;
        } else {
            arbol.insertar(value);
        }
    }

    @Override
    public arbolBB<V> remove(K key) {
        if (isEmpty()) return null;

        Node<Entrada<K, arbolBB<V>>> actual = head;
        Node<Entrada<K, arbolBB<V>>> anterior = null;

        while (actual != null) {
            if (actual.getElement().getKey().equals(key)) {
                arbolBB<V> arbol = actual.getElement().getValue();

                if (anterior == null) {
                    head = actual.getNext();
                    if (head == null) tail = null;
                } else {
                    anterior.setNext(actual.getNext());
                    if (actual == tail) {
                        tail = anterior;
                    }
                }

                size--;
                return arbol;
            }

            anterior = actual;
            actual = actual.getNext();
        }

        return null;
    }

    @Override
    public V remove(K key, V value) {
        if (isEmpty()) {
            return null;
        }

        Node<Entrada<K, arbolBB<V>>> actual = head;

        while (actual != null) {
            Entrada<K, arbolBB<V>> entrada = actual.getElement();

            if (entrada.getKey().equals(key)) {
                arbolBB<V> arbol = entrada.getValue();

                // si el arbol contiene el valor
                if (arbol.pertenece(value)) {
                    V eliminado = arbol.eliminar(value);

                    // Si después de eliminar el valor el árbol está vacío, eliminamos la clave del diccionario
                    if (arbol.getSize() == 0) {
                        remove(key); 
                    }

                    return eliminado; 
                } else {
                    return null; // El valor no esta en el árbol
                }
            }
            actual = actual.getNext();
        }

        return null; // No se encontró la clave
    }

    @Override
    public Iterable<K> keys() {
        LinkedList<K> claves = new LinkedList<>();
        Node<Entrada<K, arbolBB<V>>> actual = head;
        while (actual != null) {
            claves.addLast(actual.getElement().getKey());
            actual = actual.getNext();
        }
        return claves;
    }

    @Override
    public Iterable<Entrada<K, arbolBB<V>>> entries() {
        LinkedList<Entrada<K, arbolBB<V>>> lista = new LinkedList<>();
        Node<Entrada<K, arbolBB<V>>> actual = head;
        while (actual != null) {
            lista.addLast(actual.getElement());
            actual = actual.getNext();
        }
        return lista;
    }


}
