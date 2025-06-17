package ejercicio7;

import ejercicio2.*;

public interface TDADicABB<K, V extends Comparable<V>> {
    public int size();
    public boolean isEmpty();
    public arbolBB<V> get(K key);             
    public void put(K key, V value);
    public arbolBB<V> remove(K key);
    public V remove(K key, V value);
    public Iterable<K> keys();
    public Iterable<Entrada<K, arbolBB<V>>> entries();
	

}

