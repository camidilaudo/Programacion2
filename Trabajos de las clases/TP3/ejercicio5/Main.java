package ejercicio5;

public class Main {
    public static void main(String[] args) {
        // Crear un arreglo de objetos Persona
        Persona[] personas = {
            new Persona("Juan", 75.5f, 12345678),
            new Persona("Maria", 62.3f, 87654321),
            new Persona("Pedro", 80.0f, 11223344),
            new Persona("Ana", 55.0f, 44332211),
        };

        // Imprimir el arreglo original
        System.out.println("Arreglo original:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre());
        }

        // Crear la pila y usar el método invertir
        ArrayStack<Persona> stack = new ArrayStack<>(personas.length);
        stack.invertir(personas);

        // Imprimir el arreglo invertido
        System.out.println("\nArreglo invertido:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre());
        }
    }
}
