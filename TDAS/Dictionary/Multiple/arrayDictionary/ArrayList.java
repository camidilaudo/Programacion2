package arrayDictionary;

public class ArrayList<A> implements List<A> {

    // ATRIBUTOS
    private A[] array;
    private int size;
    private int current;

    // CONSTRUCTOR
    public ArrayList(int capacidad) {
        array = (A[]) new Object[capacidad];
        size = 0;
        current = 0;
    }

    // METODOS

    @Override
    public void addFirst(A newElement) {
        if (size == array.length) {
            throw new MyException("Lista llena");
        }

        // Mueve todos los elementos a la derecha
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = newElement;
        size++;
    }

    @Override
    public void addLast(A newElement) {
        if (size == array.length) {
            throw new MyException("Lista llena");
        }

        array[size] = newElement;
        size++;
    }

    @Override
    public void removeFirst() throws MyException {
        if (size == 0) {
            throw new MyException("Lista vacía");
        }

        // Mueve todos los elementos a la izquierda
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public void removeLast() throws MyException {
        if (size == 0) {
            throw new MyException("Lista vacía");
        }

        array[size - 1] = null;
        size--;
    }

    @Override
    public void remove(A element) throws MyException {
        if (size == 0) {
            throw new MyException("Lista vacía");
        }

        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                // Mueve los elementos a la izquierda
                for (int i2 = i; i2 < size - 1; i2++) {
                    array[i2] = array[i2 + 1];
                }
                array[size - 1] = null;
                size--;
                break;  // Sale después de haber removido el elemento
            }
        }
    }

    @Override
    public void First() {
        current = 0;
    }

    @Override
    public void advance() {
        if (current >= size - 1) {
            throw new MyException("Fuera de la lista");
        }
        current++;
    }

    @Override
    public A getCurrent() {
        if (current >= size) {
            throw new MyException("Fuera de la lista");
        }
        return array[current];
    }

    @Override
    public boolean atEnd() {
        return current == size - 1; // Verifica si se llegó al final de la lista
    }

    @Override
    public int getSize() {
        return size;
    }

    // Método para imprimir la lista
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}
