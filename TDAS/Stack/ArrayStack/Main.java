package ArrayStack;

import LinkedStack.LinkedStack;
import LinkedStack.MyException;

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

        
        // metodo invertir
        
        // Volver a llenar la pila 
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // invertir la pila
        ArrayStack.invertir(stack);

        System.out.println("\nPila invertida:");
        // Mostrar los elementos en la pila después de invertir
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        
        
        // PILA INVERTIDA
        System.out.print("Ingrese una cadena para invertir: ");
		String cadena = System.console().readLine();
		char[] caracteres = cadena.toCharArray();
		LinkedStack<Character> pila1 = new LinkedStack<Character>();
		for(int i = 0; i<caracteres.length;i++)
			try {
				pila1.push(caracteres[i]);
			}
			catch(MyException E) {
				
			}
		System.out.print("La salida es: ");
		while(!pila1.isEmpty())
			System.out.print(pila1.pop());
	
   
}

}
