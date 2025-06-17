package ejercicio3;

public class ArrayList<A> implements List<A> {
    
    private A array[];
    private int size;
    private int initialSize = 10;
    private int current;
    
    // Constructor: inicializa el array y los contadores
    public ArrayList() {
        array = (A[]) new Object[initialSize];
        size = 0;
        current = -1; // No hay elementos aún
    }
    
    // Duplica el tamaño del array cuando se llena
    private void resizeSize() {
        A[] array2 = (A[]) new Object[array.length * 2];
        for(int i = 0; i < size; i++) {
        	array2[i] = array[i];
        }
        array = array2;
    }

    // Agrega un elemento al inicio
    @Override
    public void addFirst(A newElement) {
        if (size == array.length) resizeSize();
        for (int i = size; i > 0; i--) array[i] = array[i - 1];
        array[0] = newElement;
        size++;
        if (current == -1) current = 0; // Se asegura de que el cursor esté en el primer elemento
    }

    // Agrega un elemento al final
    @Override
    public void addLast(A newElement) {
        if (size == array.length) resizeSize();
        
        array[size++] = newElement;
        if (current == -1) current = 0;
    }

    // Elimina el primer elemento
    @Override
    public void removeFirst() throws MyException {
        if (size == 0) throw new MyException("Error. El arreglo está vacío");
       
        for (int i = 1; i < size; i++) {
        	array[i - 1] = array[i];}
        
        array[--size] = null;
        if (size == 0) current = -1;
        else if (current > 0) current--;
    }

    // Elimina el último elemento
    @Override
    public void removeLast() throws MyException {
        if (size == 0) throw new MyException("Error. El arreglo está vacío");
        
        array[--size] = null;
        if (size == 0) current = -1;
        else if (current >= size) current = size - 1;
    }

    // Elimina la primera ocurrencia de un elemento
    @Override
    public void remove(A element) throws MyException {
        if (size == 0) throw new MyException("Error. El arreglo está vacío");
        int i = 0;
        boolean found = false;
        while (i < size && !found) {
            if (array[i] == element) found = true;
            else i++;
        }
        if (!found) throw new MyException("El elemento no está en la lista");
        for (int j = i; j < size - 1; j++) array[j] = array[j + 1];
        array[--size] = null;
        if (size == 0) current = -1;
        else if (current == i) current = (i == size) ? size - 1 : i;
        else if (current > i) current--;
    }

    // Posiciona el cursor (current) al primer elemento
    @Override
    public void First() {
        if (size == 0) current = -1;
        else current = 0;
    }

    // Avanza el cursor (current) y permite marcar fin de recorrido
    @Override
    public void advance() {
        if (current >= 0 && current < size - 1) {
            current++;
        } else {
            current = size; // Marca fin para atEnd()
        }
    }

    // Retorna el elemento actual o null si está fuera
    @Override
    public A getCurrent() {
        if (current >= 0 && current < size) return array[current];
        return null;
    }

    // Indica si el cursor está al final de la lista
    @Override
    public boolean atEnd() {
        return (current == size || current == -1);
    }

    // Retorna el tamaño de la lista
    @Override
    public int getSize() {
        return size;
    }
    
    /** Imprime los elementos de la lista en formato [e1, e2, ..., eN] */
    public void printList() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
