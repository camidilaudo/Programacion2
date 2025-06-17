package ejercicio2;

import ejercicio1.Entry;
import ejercicio1.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> mapa = new ArrayMap<>(10);

        System.out.println("¿Está vacío?: " + mapa.isEmpty());

        mapa.put("camila", 25);
        mapa.put("thiago", 30);
        mapa.put("miranda", 20);

        System.out.println("Tamaño: " + mapa.size());
        System.out.println("Valor de camila: " + mapa.get("camila"));
        System.out.println("Valor de thiago: " + mapa.get("thiago"));
        System.out.println("Valor de miranda: " + mapa.get("miranda"));

        System.out.println("\nReemplazo el valor de thiago:");
        mapa.put("thiago", 26);
        System.out.println("Nuevo valor de thiago: " + mapa.get("thiago"));

        System.out.println("\nClaves:");
        for (Object clave : mapa.keys()) {
            System.out.println((String) clave); }

        System.out.println("\nValores:");
        for (Object valor : mapa.values()) {
            System.out.println((Integer) valor); // casteo dentro del loop
        }

        System.out.println("\nEliminando a camila...");
        mapa.remove("camila");

        System.out.println("Tamaño después de eliminar: " + mapa.size());

        System.out.println("\nEntradas:");
        for (Entry<String, Integer> e : mapa.entries()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
