package ejercicio3;

import ejercicio2.*;

import java.util.Comparator;
import ejercicio1.*;

public class AVL<E extends Comparable<E>> implements AVLTDA<E> {

	protected final Comparator<E> comp; // Comparador para definir el orden de los elementos
    protected NodoAVL<E> root;          // Raíz del árbol

    // Constructor que recibe un comparador
    public AVL(Comparator<E> comp) {
        this.comp = comp;
        this.root = null;
    }

    // Retorna la altura del nodo, o 0 si es null
    private int getHeight(NodoAVL<E> node) {
        return (node == null) ? 0 : node.height;
    }

    // Calcula el factor de balanceo de un nodo
    private int getBalance(NodoAVL<E> node) {
        return (node == null) ? 0 : getHeight(node.right) - getHeight(node.left);
    }

    // Rotación simple a la derecha
    private NodoAVL<E> rightRotate(NodoAVL<E> y) {
        NodoAVL<E> x = y.left;
        NodoAVL<E> t2 = x.right;

        // Rotación
        x.right = y;
        y.left = t2;

        // Actualización de alturas
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x; // Nueva raíz del subárbol
    }

    // Rotación simple a la izquierda
    private NodoAVL<E> leftRotate(NodoAVL<E> x) {
        NodoAVL<E> y = x.right;
        NodoAVL<E> t2 = y.left;

        // Rotación
        y.left = x;
        x.right = t2;

        // Actualización de alturas
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y; // Nueva raíz del subárbol
    }

    // Inserta un elemento en el árbol
    private NodoAVL<E> insert(NodoAVL<E> node, E data) {
        if (node == null) {
            return new NodoAVL<>(data);
        }

        int cmp = comp.compare(data, node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            return node; // Elemento duplicado, no se inserta
        }

        // Actualizar altura y reequilibrar
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return rebalance(node, data);
    }

    // Elimina un elemento del árbol
    private NodoAVL<E> delete(NodoAVL<E> node, E data) {
        if (node == null) {
            return null;
        }

        int cmp = comp.compare(data, node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {
            // Nodo con un hijo o ninguno
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Nodo con dos hijos: se reemplaza con el menor del subárbol derecho
            NodoAVL<E> min = minValueNode(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }

        // Actualizar altura y reequilibrar
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return rebalance(node, data);
    }

    // Reequilibra el árbol si hay desbalance
    private NodoAVL<E> rebalance(NodoAVL<E> node, E data) {
        int balance = getBalance(node);

        // Desbalance derecha
        if (balance > 1) {
            if (comp.compare(data, node.right.data) > 0) {
                return leftRotate(node); // Caso LL
            } else {
                node.right = rightRotate(node.right); // Caso RL
                return leftRotate(node);
            }
        }

        // Desbalance izquierda
        if (balance < -1) {
            if (comp.compare(data, node.left.data) < 0) {
                return rightRotate(node); // Caso RR
            } else {
                node.left = leftRotate(node.left); // Caso LR
                return rightRotate(node);
            }
        }

        return node; // No requiere reequilibrio
    }

    // Inserta un elemento (uso externo)
    public void insert(E data) {
        root = insert(root, data);
    }

    // Elimina un elemento (uso externo)
    public void delete(E data) {
        root = delete(root, data);
    }

    // Verifica si un valor existe en el árbol
    public boolean exists(E value) {
        return exists(root, value);
    }

    // Búsqueda recursiva
    private boolean exists(NodoAVL<E> node, E value) {
        if (node == null) return false;

        int cmp = comp.compare(value, node.data);
        if (cmp == 0) return true;
        return (cmp < 0) ? exists(node.left, value) : exists(node.right, value);
    }

    // Recorrido inorden para imprimir
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    // Recorrido inorden recursivo
    private void inOrderTraversal(NodoAVL<E> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    // Encuentra el nodo con el valor mínimo
    protected NodoAVL<E> minValueNode(NodoAVL<E> node) {
        NodoAVL<E> current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Representación en String del árbol
    public String toString() {
        String salida = inOrderTraversalString(root);
        return salida.isEmpty() ? "" : salida.substring(0, salida.length() - 2);
    }

    // Recorrido inorden con formato string (con paréntesis)
    private String inOrderTraversalString(NodoAVL<E> node) {
        if (node != null) {
            return "( " + inOrderTraversalString(node.left) + node.data + " " + inOrderTraversalString(node.right) + " )";
        } else {
            return "";
        }
    }
    
    public E min() {
        if (root == null) {
            return null; // o lanzar excepción
        }
        return minValueNode(root).data;
    }

}
