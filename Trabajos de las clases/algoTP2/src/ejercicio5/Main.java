package ejercicio5;

import ejercicio4.*;

public class Main {

    public static void main(String[] args) {

    	
        float[] temps = new float[5];
        TempEstacion estacion = new TempEstacion(temps);


        try {
            estacion.agregarTemp(3.5f);
            estacion.agregarTemp(-1.2f);
            estacion.agregarTemp(0.0f);
            estacion.agregarTemp(5.1f);
            estacion.agregarTemp(3.5f); // temperatura repetida

            // aca deberia haber exepcion
            estacion.agregarTemp(2.0f);
        
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }


        try {
            System.out.println("Menor temperatura: " + estacion.menorTemperatura());
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }


        try {
            System.out.println("Posición del menor: " + estacion.posMenorTemperatura());
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }


        try {
            System.out.println("¿Todas las temperaturas son positivas?: " + estacion.todosPositivos());
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }


        float[] otrasTemps = new float[5];
        TempEstacion otraEstacion = new TempEstacion(otrasTemps);
        otraEstacion.agregarTemp(3.5f);
        otraEstacion.agregarTemp(-1.2f);
        otraEstacion.agregarTemp(9.9f);
        otraEstacion.agregarTemp(5.1f);
        otraEstacion.agregarTemp(1.0f);

        int coincidencias = estacion.contarCoincidencias(otraEstacion);
        System.out.println("Cantidad de coincidencias: " + coincidencias);


        // invertir creando nuevo arreglo
        TempEstacion invertida = estacion.invertir();
        System.out.println("Temperaturas invertidas :");
        invertida.mostrarTemperaturas();


        // invertir en el mismo arreglo
        estacion.invertirMe();
        System.out.println("Temperaturas de invertirMe():");
        estacion.mostrarTemperaturas();

        // reemplazar 
        estacion.reemplazar(3.5f, 7.7f);
        System.out.println("Temperaturas después de reemplazar 3.5 por 7.7:");
        estacion.mostrarTemperaturas();

        // intercambiar posiciones válidas
        try {
            estacion.intercambiar(0, 4);
            System.out.println("Temperaturas después de intercambiar posiciones 0 y 4:");
            estacion.mostrarTemperaturas();
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        // intercambiar con posiciones inválidas
        try {
            estacion.intercambiar(0, 10);
        } catch (MyException e) {
            System.out.println("Excepción esperada: " + e.getMessage());
        }
    }
}
