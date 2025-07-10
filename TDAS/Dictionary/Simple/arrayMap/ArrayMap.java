package arrayMap;

import java.util.Arrays;

public class ArrayMap<K, V> implements Map<K, V> {
    
    private int size;
    private Entry<K, V>[] array;
    
    public ArrayMap(int capacidad) {
        array = (Entry<K, V>[]) new Entry[capacidad];
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
    public V get(K k) {
        if (k == null) return null; // Si la clave es null, devolvemos null
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {  // Usar equals para comparar claves
                return array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        if (k == null) throw new IllegalArgumentException("Clave no puede ser null");
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
                V oldValue = array[i].getValue();
                array[i].setValue(v);
                return oldValue;
            }
        }

        // Si el arreglo está lleno, duplicamos su tamaño
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2); // Redimensionar el arreglo
        }

        array[size++] = new Entrada<>(k, v);
        return null;
    }

    @Override
    public V remove(K k) {
        if (k == null) return null;
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
                V value = array[i].getValue();
                // Mover la última entrada a la posición eliminada
                array[i] = array[size - 1];
                array[size - 1] = null; // Limpieza
                size--;
                return value;
            }
        }
        return null;
    }

    @Override
    public K[] keys() {
        K[] aux = (K[]) new Object[size];
        for (int i = 0; i < size; i++) {
            aux[i] = array[i].getKey();
        }
        return aux;
    }

    @Override
    public V[] values() {
        V[] aux = (V[]) new Object[size];
        for (int i = 0; i < size; i++) {
            aux[i] = array[i].getValue();
        }
        return aux;
    }

    @Override
	public Entry<K,V>[] entries(){
		Entry<K,V>[] auxArray = (Entry<K,V>[])new Entrada[size];
		for(int i=0;i<size;i++)
			auxArray[i]=new Entrada(map[i].getKey(),map[i].getValue());
		return auxArray;
	}
}
