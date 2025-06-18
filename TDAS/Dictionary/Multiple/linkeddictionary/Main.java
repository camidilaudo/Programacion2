package linkeddictionary;

public class Main {

    public static void main(String[] args) {
        // Crear un LinkedDictionary con claves de tipo Integer y valores de tipo Integer
        LinkedDictionary<Integer, Integer> dictionary = new LinkedDictionary<>();

        // Agregar elementos al diccionario
        dictionary.put(1, 10);
        dictionary.put(1, 20);
        dictionary.put(2, 30);
        dictionary.put(2, 40);

        // Imprimir las claves del diccionario
        System.out.println("Claves:");
        for (Integer key : dictionary.keys()) {
            System.out.println(key);
        }

        // Obtener los valores asociados con la clave 1
        System.out.println("\nValores para la clave '1':");
        for (Integer value : dictionary.get(1)) {
            System.out.println(value);
        }

        // Eliminar un valor específico de la clave 2
        System.out.println("\nEliminar '40' de la clave '2':");
        dictionary.remove(2, 40);

        // Imprimir los valores restantes para la clave 2
        System.out.println("Valores para la clave '2' después de la eliminación:");
        for (Integer value : dictionary.get(2)) {
            System.out.println(value);
        }

        // Eliminar completamente la clave 1
        System.out.println("\nEliminar la clave '1' y sus valores:");
        dictionary.remove(1);

        // Verificar si la clave 1 sigue existiendo
        System.out.println("\nValores para la clave '1' después de la eliminación:");
        Iterable<Integer> key1Values = dictionary.get(1);
        if (key1Values == null) {
            System.out.println("La clave '1' ya no existe en el diccionario.");
        }

        // Imprimir todas las entradas (clave y valores)
        System.out.println("\nEntradas del diccionario:");
        for (Entrada<Integer, Iterable<Integer>> entry : dictionary.entries()) {
            System.out.print(entry.getKey() + ": ");
            for (Integer value : entry.getValue()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
