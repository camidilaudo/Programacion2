package ejercicio5;

import ejercicio4.*;

public class ArrayDictionary<K, V> implements Dictionary<K, V> {

    private  int maxEntry = 100;
    private  int maxValues = 20;

    private Entry<K, V[]>[] entries;
    private int size;

    public ArrayDictionary() {
        entries = (Entry<K, V[]>[]) new Entry[maxEntry];
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

    // Devuelve todos los valores asociados a una clave
    @Override
    public List<V> get(K k) {
        ArrayList<V> result = new ArrayList<>(maxValues);
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(k)) {
                V[] values = entries[i].getValue();
                for (int j = 0; j < values.length && values[j] != null; j++) {
                    result.addLast(values[j]);
                }
                break;
            }
        }
        return result;
    }

    // Agrega un valor a una clave
    @Override
    public void put(K k, V v) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(k)) {
                V[] values = entries[i].getValue();
                for (int j = 0; j < maxValues; j++) {
                    if (values[j] == null) {
                        values[j] = v;
                        return;
                    }
                }
                throw new MyException("Límite de valores por clave alcanzado");
            }
        }

        if (size == maxEntry) {
            throw new MyException("Diccionario lleno");
        }

        @SuppressWarnings("unchecked")
        V[] newValues = (V[]) new Object[maxValues];
        newValues[0] = v;
        entries[size++] = new Entrada<>(k, newValues);
    }

    // Elimina una clave completa (todos sus valores)
    @Override
    public List<V> remove(K k) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(k)) {
                V[] removedValues = entries[i].getValue();
                ArrayList<V> result = new ArrayList<>(maxValues);
                for (V val : removedValues) {
                    if (val != null) result.addLast(val);
                }
                entries[i] = entries[size - 1];
                entries[size - 1] = null;
                size--;
                return result;
            }
        }
        return null;
    }

    // Elimina un valor específico asociado a una clave
    @Override
    public V remove(K k, V v) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(k)) {
                V[] values = entries[i].getValue();
                for (int j = 0; j < maxValues; j++) {
                    if (values[j] != null && values[j].equals(v)) {
                        V removed = values[j];
                        // reemplazo por último valor
                        int last = j;
                        while (last + 1 < maxValues && values[last + 1] != null) {
                            last++;
                        }
                        values[j] = values[last];
                        values[last] = null;
                        return removed;
                    }
                }
            }
        }
        return null;
    }

    // Devuelve una lista con las claves
    @Override
    public List<K> keys() {
        ArrayList<K> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.addLast(entries[i].getKey());
        }
        return result;
    }

    // Devuelve una lista con todas las entradas
    @Override
    public List<Entry<K, V>> entries() {
        ArrayList<Entry<K, V>> result = new ArrayList<>(size * maxValues);
        for (int i = 0; i < size; i++) {
            V[] values = entries[i].getValue();
            for (int j = 0; j < maxValues; j++) {
                if (values[j] != null) {
                    result.addLast(new Entrada<>(entries[i].getKey(), values[j]));
                }
            }
        }
        return result;
    }
}
