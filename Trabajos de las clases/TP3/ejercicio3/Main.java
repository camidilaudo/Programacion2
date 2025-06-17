package ejercicio3;

public class Main {
    public static void main(String[] args) {
        
    	LinkedStack<String> pila = new LinkedStack<>();

        // Verificar si está vacía
        System.out.println("¿Pila vacía? " + pila.isEmpty());

        // Agregar elementos
        pila.push("A");
        pila.push("B");
        pila.push("C");

        // Imprimir pila
        pila.printStack(); // Debería mostrar: C, B, A

        // Mostrar tope
        System.out.println("Tope actual: " + pila.top()); // C

        // Sacar un elemento
        System.out.println("Elemento sacado: " + pila.pop()); // C

        // Imprimir pila otra vez
        pila.printStack(); // Debería mostrar: B, A

        // Mostrar tamaño
        System.out.println("Tamaño de la pila: " + pila.size());

        // Vaciar completamente
        pila.pop(); // B
        pila.pop(); // A

        // Intentar hacer pop con pila vacía
        try {
            pila.pop();
        } catch (MyException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
