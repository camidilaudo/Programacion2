package ejercicio2;

public class Main {
    public static void main(String[] args) {

    	ArrayStack<Integer> stack = new ArrayStack<>(3);

        System.out.println("¿Está vacía?: " + stack.isEmpty()); // true

        // agregar elementos
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Tamaño de la pila: " + stack.size()); // 3
        System.out.println("Elemento en el tope: " + stack.top()); // 30

        // Esto debería forzar un resize
        stack.push(40);
        System.out.println("Tamaño luego de agregar más elementos: " + stack.size()); // 4
        System.out.println("Elemento en el tope: " + stack.top()); // 40

        // Eliminamos elementos
        System.out.println("Pop: " + stack.pop()); // 40
        System.out.println("Pop: " + stack.pop()); // 30

        System.out.println("Elemento en el tope ahora: " + stack.top()); // 20
        System.out.println("Tamaño actual: " + stack.size()); // 2

        // Vaciamos la pila
        stack.pop(); // 20
        stack.pop(); // 10

        System.out.println("¿Está vacía?: " + stack.isEmpty()); // true


        // Intentar hacer pop o top en pila vacía
        try {
            stack.pop(); 
        } catch (MyException e) {
            System.out.println("Excepción al hacer pop: " + e.getMessage());
        }


        try {
            stack.top();
        } catch (MyException e) {
            System.out.println("Excepción al hacer top: " + e.getMessage());
        }
    }
}
