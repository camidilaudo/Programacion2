package arrayDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDictionary<K, V> implements Dictionary<K, V> {

    private Entry<K, List<V>>[] array;
    private int size;

    public ArrayDictionary() {
        array = (Entry<K, List<V>>[]) new Entrada[100];
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
    public Iterable<V> get(K k) {
        int i = 0;
        boolean encontreClave = false;
        while (!encontreClave && i < size) {
            if (array[i].getKey().equals(k)) // Usar equals para comparar claves
                encontreClave = true;
            else
                i++;
        }
        if (!encontreClave)
            return null;
        else {
            return new ArrayList<>(array[i].getValue()); // Usar ArrayList para valores
        }
    }

    @Override
    public void put(K k, V v) {
        int i = 0;
        boolean encontreClave = false;
        while (!encontreClave && i < size) {
            if (array[i].getKey().equals(k)) // Usar equals para comparar claves
                encontreClave = true;
            else
                i++;
        }
        if (!encontreClave) {
            if (size < array.length) {
                List<V> valores = new ArrayList<>();
                valores.add(v);
                array[size] = new Entrada<>(k, valores);
                size++;
            } else
                throw new MyException("El arreglo de claves está lleno");
        } else {
            array[i].getValue().add(v);
        }
    }

    @Override
    public Iterable<V> remove(K k) {
        int i = 0;
        boolean encontreClave = false;
        while (!encontreClave && i < size) {
            if (array[i].getKey().equals(k)) // Usar equals para comparar claves
                encontreClave = true;
            else
                i++;
        }
        if (!encontreClave)
            return null;
        else {
            List<V> valores = array[i].getValue();
            array[i] = array[size - 1]; // Eliminar la entrada
            array[size - 1] = null;
            size--;
            return new ArrayList<>(valores); // Devolver los valores como una nueva lista
        }
    }

    @Override
    public V remove(K k, V v) {
        int i = 0;
        boolean encontreClave = false;
        while (!encontreClave && i < size) {
            if (array[i].getKey().equals(k)) // Usar equals para comparar claves
                encontreClave = true;
            else
                i++;
        }
        if (!encontreClave)
            return null;
        else {
            List<V> valores = array[i].getValue();
            if (valores.remove(v)) {
                if (valores.isEmpty()) {
                    array[i] = array[size - 1]; // Eliminar la entrada
                    array[size - 1] = null;
                    size--;
                }
                return v;
            }
            return null;
        }
    }

    @Override
    public Iterable<K> keys() {
        List<K> aux = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            aux.add(array[i].getKey());
        }
        return aux;
    }

    @Override
    public Iterable<Entrada<K, Iterable<V>>> entries() {
        List<Entrada<K, Iterable<V>>> entradas = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            entradas.add(new Entrada<>(array[i].getKey(), array[i].getValue()));
        }
        return entradas;
    }
}
