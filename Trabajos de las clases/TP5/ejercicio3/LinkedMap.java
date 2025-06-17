package ejercicio3;

import ejercicio1.*;

public class LinkedMap<K, V> implements Map<K, V> {

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
        Node<Entrada<K, V>> current = head;
        
        // mientras siga habiendo nodos
        while (current != null) {
        	
        	// si el elemento es k, devuelvo el valor de k 
            if (current.getElement().getKey().equals(k)) {
                return current.getElement().getValue();
            }
            // sino, avanzo un nodo
            current = current.getNext();
        }
        // sino encuentro k, deuvelvo null
        return null;
    }

    @Override
    public V put(K k, V v) {
    	if (size==0) {
    		Entrada<K,V> entrada = new Entrada<K,V>(k,v);
            Node<Entrada<K, V>> nuevoNodo = new Node<Entrada<K,V>>(entrada,null,null);
            head = nuevoNodo;
            tail = nuevoNodo;
            size++;
            return null;
    	}
    	
    	// si k es el head, le cambio el valor y devuelvo el anterior valor
    	if(head.getElement().getKey() == k) {
    		V valor = head.getElement().getValue();
    		head.getElement().setValue(v);
    		return valor;
    	}
    	
        Node<Entrada<K, V>> current = head;

        // recorro todos los nodos hasta encontrar k
        while (current != null && current.getElement().getKey() != k) {
        	current = current.getNext();}
        // si encuentro k, le cambio el valor y devuelvo el anterior valor
        if (current != null) {
        	V valor = current.getElement().getValue();
        	current.getElement().setValue(v);
        	return valor;
        }
        // sino esta k, lo agrego al final 
        else {
    		Entrada<K,V> entrada = new Entrada<K,V>(k,v);
            Node<Entrada<K, V>> nuevoNodo = new Node<Entrada<K,V>>(entrada,null,null);
            tail.setNext(nuevoNodo);
            tail = nuevoNodo;
            size++;
            return null;
        }
            
    }

    @Override
    public V remove(K k) {
    	if (size == 0 ) {return null;}
    	
    	// si k es el primer elemento
    	if (head.getElement().getKey() == k ) {
    		V valor = head.getElement().getValue();
    		// elimino la flecha del segundo al head 
    		head.getNext().setPrevious(null);
    		// asigno al segundo como head 
    		head = head.getNext();
    		size--;
    		return valor;
    	}
    	
        Node<Entrada<K, V>> current = head;

        // recorro los nodos
        while (current != null && current.getElement().getKey() != k) {
        	current = current.getNext();
        }
        
        // si encuentro k, uno el anterior con el siguiente nodo
        if (current != null) {
        	V valor = current.getElement().getValue();
        	current.getPrevious().setNext(current.getNext());
        	
        	// si hay siguiente, uno el siguiente con el anterior
        	if(current.getNext() != null) {
        		current.getNext().setPrevious(current.getPrevious());
        	}
        	else {
        		tail = current.getPrevious();
        	}
        	size --;
        	return valor;
        }
        // si k no existe, devuelvo null
        else {return null;}
            
    }

    @Override
    public K[] keys() {
    	
    	// creo un arreglo de k
        K[] claves = (K[]) new Object[size];
        Node<Entrada<K, V>> current = head;
        int i = 0;

        // recorro todos los nodos y voy agregando las claves de cada uno
        while (current != null) {
            claves[i] = current.getElement().getKey();
            current = current.getNext();
            i++;
        }

        return claves;
    }

    @Override
    public V[] values() {
    	
    	// creo un arreglo de valores
        V[] valores = (V[]) new Object[size];
        Node<Entrada<K, V>> current = head;
        int i = 0;

        // recorro todos los nodos y voy agregando los valores de cada uno
        while (current != null) {
            valores[i] = current.getElement().getValue();
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
            entradas[i] = current.getElement();
            current = current.getNext();
            i++;
        }

        return entradas;
    }
}
