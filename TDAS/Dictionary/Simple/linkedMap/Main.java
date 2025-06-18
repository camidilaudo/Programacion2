package linkedMap;

import arrayMap.*;

public class Main {
    public static void main(String[] args) {
        LinkedMap<String, Integer> mapa = new LinkedMap<>();

        mapa.put("uno", 1);
        mapa.put("dos", 2);
        mapa.put("tres", 3);

        System.out.println("Contenido del map:");
        for (Entry<String, Integer> entrada : mapa.entries()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        System.out.println("\nClaves:");
        for (Object clave : mapa.keys()) {
            System.out.println(clave);
        }

        System.out.println("\nValores:");
        for (Object valor : mapa.values()) {
            System.out.println(valor);
        }

        System.out.println("\nObtener clave 'dos': " + mapa.get("dos"));

        System.out.println("\nEliminar clave 'uno': " + mapa.remove("uno"));

        System.out.println("\nContenido después de eliminar:");
        for (Entry<String, Integer> entrada : mapa.entries()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
