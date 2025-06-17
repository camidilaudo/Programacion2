package ejercicio3;

import ejercicio1.Queue;

public class LinkedQueue<A> implements Queue<A> {
    
    private Node<A> front;
    private Node<A> tail;
    private int size;
    
    public LinkedQueue() {
        front = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(A elemento) {
        Node<A> nuevoNodo = new Node<A>();
        nuevoNodo.setElement(elemento);
        if (size == 0) {
            front = nuevoNodo;
        } else {
            tail.setNext(nuevoNodo);
        }
        tail = nuevoNodo;
        size++;
    }

    @Override
    public A dequeue() {
        if (size == 0) {
            throw new MyException("La cola esta vacia");
        } else {
            A aux = front.getElement();
            front = front.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
            return aux;
        }
    }

    @Override
    public A front() {
        if (size == 0) {
            throw new MyException("La cola esta vacia");
        } else {
            return front.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
