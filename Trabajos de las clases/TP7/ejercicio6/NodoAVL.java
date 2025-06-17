package ejercicio6;

public class NodoAVL<E> {
    public E data;
    public NodoAVL<E> left, right;
    public int height;

    public NodoAVL(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
