package ejercicio8;

import linkeddictionary.*;
import linkeddictionary.Entrada;
import linkeddictionary.Entry;
import ejercicio7.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedDictionary<Integer, Integer> diccionarioGeneral = new LinkedDictionary<>();
        ArrayMap<Integer, Integer> ultimoMapeo = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENÚ:");
            System.out.println("1. Cargar un mapeo con notas de una materia");
            System.out.println("2. Mostrar el último mapeo cargado");
            System.out.println("3. Agregar el último mapeo cargado al Diccionario general");
            System.out.println("4. Agregar una nota para un DNI específico");
            System.out.println("5. Quitar una nota para un DNI específico");
            System.out.println("6. Quitar un alumno");
            System.out.println("7. Mostrar las notas de un alumno");
            System.out.println("8. Mostrar todos los alumnos");
            System.out.println("9. Mostrar todos los alumnos y su promedio de notas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ultimoMapeo = cargarMapeo(sc);
                    break;
                case 2:
                    mostrarMapeo(ultimoMapeo);
                    break;
                case 3:
                    if (ultimoMapeo != null) {
                        for (ejercicio7.Entry<Integer, Integer> e : ultimoMapeo.entries()) {
                            diccionarioGeneral.put(e.getKey(), e.getValue());
                        }
                        System.out.println("Mapeo agregado al diccionario general.");
                    } else {
                        System.out.println("No hay mapeo cargado.");
                    }
                    break;
                case 4:
                    System.out.print("DNI: ");
                    int dniAgregar = sc.nextInt();
                    System.out.print("Nota: ");
                    int nota = sc.nextInt();
                    diccionarioGeneral.put(dniAgregar, nota);
                    break;
                case 5:
                    System.out.print("DNI: ");
                    int dniQuitarNota = sc.nextInt();
                    System.out.print("Nota a quitar: ");
                    int notaQuitar = sc.nextInt();
                    Integer resultado = diccionarioGeneral.remove(dniQuitarNota, notaQuitar);
                    System.out.println(resultado != null ? "Nota quitada." : "Nota no encontrada.");
                    break;
                case 6:
                    System.out.print("DNI: ");
                    int dniEliminar = sc.nextInt();
                    diccionarioGeneral.remove(dniEliminar);
                    System.out.println("Alumno eliminado.");
                    break;
                case 7:
                    System.out.print("DNI: ");
                    int dniConsultar = sc.nextInt();
                    Iterable<Integer> notas = diccionarioGeneral.get(dniConsultar);
                    if (notas != null) {
                        System.out.print("Notas: ");
                        for (int n : notas) {
                            System.out.print(n + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("Alumnos registrados:");
                    for (Integer k : diccionarioGeneral.keys()) {
                        System.out.println("DNI: " + k);
                    }
                    break;
                case 9:
                    System.out.println("Alumnos y promedio:");
                    for (Entry<Integer, Iterable<Integer>> e : diccionarioGeneral.entries()) {
                        int suma = 0, cantidad = 0;
                        for (int n : e.getValue()) {
                            suma += n;
                            cantidad++;
                        }
                        double promedio = cantidad > 0 ? (double) suma / cantidad : 0.0;
                        System.out.println("DNI: " + e.getKey() + " - Promedio: " + promedio);
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    private static ArrayMap<Integer, Integer> cargarMapeo(Scanner sc) {
        ArrayMap<Integer, Integer> map = new ArrayMap<>(10);
        System.out.println("Cargar notas (DNI -1 para terminar):");
        while (true) {
            System.out.print("DNI: ");
            int dni = sc.nextInt();
            if (dni == -1) break;
            System.out.print("Nota: ");
            int nota = sc.nextInt();
            map.put(dni, nota);
        }
        return map;
    }

    private static void mostrarMapeo(ArrayMap<Integer, Integer> map) {
        if (map == null || map.isEmpty()) {
            System.out.println("No hay mapeo cargado.");
            return;
        }
        System.out.println("Último mapeo cargado:");
        for (ejercicio7.Entry<Integer, Integer> e : map.entries()) {
            System.out.println("DNI: " + e.getKey() + ", Nota: " + e.getValue());
        }
    }
}
