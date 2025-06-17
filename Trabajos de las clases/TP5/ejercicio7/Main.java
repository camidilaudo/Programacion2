package ejercicio7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear los dos ArrayMap para las notas de las materias
        ArrayMap<Integer, Integer> M1 = new ArrayMap<>(10); // Notas materia A
        ArrayMap<Integer, Integer> M2 = new ArrayMap<>(10); // Notas materia B
        Scanner sc = new Scanner(System.in);

        // Cargar los datos
        System.out.println("Carga de datos : ");
        boolean terminar = false;
        while (!terminar) {
            System.out.print("DNI o -1 para terminar : ");
            int dni = sc.nextInt();
            if (dni != -1) {
                System.out.print("Nota materia A (0 a 10): ");
                int notaA = sc.nextInt();

                System.out.print("Nota materia B (0 a 10): ");
                int notaB = sc.nextInt();

                M1.put(dni, notaA);
                M2.put(dni, notaB);
            } else {
                terminar = true;
            }
        }

        // Mostrar las notas de la materia A
        if (!M1.isEmpty()) {
            System.out.println("\nNotas materia A:");
            for (Entry<Integer, Integer> e : M1.entries()) {
                System.out.println("DNI: " + e.getKey() + ", Nota: " + e.getValue());
            }
        }

        // Mostrar las notas de la materia B
        if (!M2.isEmpty()) {
            System.out.println("\nNotas materia B:");
            for (Entry<Integer, Integer> e : M2.entries()) {
                System.out.println("DNI: " + e.getKey() + ", Nota: " + e.getValue());
            }
        }

        // Obtener las diferencias entre las notas de las dos materias
        ArrayMap<Integer, Integer[]> diferencias = unir(M1, M2);

        if(!diferencias.isEmpty()) {
	        // Mostrar los DNIs con notas diferentes
	        System.out.println("\nDNIs con notas diferentes:");
	        for (Entry<Integer, Integer[]> diferencia : diferencias.entries()) {
	            Integer dni = diferencia.getKey();
	            Integer[] notas = diferencia.getValue();
	            System.out.println("DNI: " + dni + ", Nota A: " + notas[0] + ", Nota B: " + notas[1]);
	        }
        }
    }

    // Método que une los dos ArrayMap y devuelve las diferencias en un nuevo ArrayMap
    public static ArrayMap<Integer, Integer[]> unir(ArrayMap<Integer, Integer> M1, ArrayMap<Integer, Integer> M2) {
        
    	ArrayMap<Integer, Integer[]> resultado = new ArrayMap<>(10);
        Entry<Integer, Integer>[] entradas = M1.entries();

        for (int i = 0; i < M1.size(); i++) {
            Integer dni = entradas[i].getKey(); // Clave (DNI)
            Integer notaA = entradas[i].getValue(); // Nota de M1
            Integer notaB = M2.get(dni); // Nota de M2

            if (notaB != null && !notaA.equals(notaB)) {
                // Si las notas son diferentes, las guardamos en el ArrayMap de resultados
                resultado.put(dni, new Integer[]{notaA, notaB});
            }
        }

        return resultado;
    }
}
