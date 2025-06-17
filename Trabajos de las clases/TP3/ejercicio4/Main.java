package ejercicio4;

public class Main {
    public static void main(String[] args) {

    	ArrayStack<Integer> pila = new ArrayStack<>(5);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        System.out.println("Pila original:");
        // pila antes de invertir
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }

        // Volver a llenar la pila 
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        // invertir la pila
        ArrayStack.invertir(pila);

        System.out.println("\nPila invertida:");
        // Mostrar los elementos en la pila después de invertir
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}
