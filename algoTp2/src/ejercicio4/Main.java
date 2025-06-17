package ejercicio4;

public class Main {

    public static void main(String[] args) {

    	
    	float[] arregloTemp = new float[5];
        TempMinEstacion estacion = new TempMinEstacion(arregloTemp);

        try {
            estacion.agregarTemp(3.2f);
            estacion.agregarTemp(-2.5f);
            estacion.agregarTemp(0.0f);
            estacion.agregarTemp(5.8f);
            estacion.agregarTemp(1.1f);

            // aca tiene que haber exepcion
            estacion.agregarTemp(4.0f);
        
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        try {
            System.out.println("Mayor temperatura: " + estacion.getMayorTemp());
       
        } catch (MyException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        
        System.out.println("Promedio de temperaturas: " + estacion.promTemp());


        System.out.println("Cantidad de heladas: " + estacion.cantHeladas());


        System.out.println("¿Hubo heladas?: " + estacion.huboHeladas());


        float tempDada = 2.0f;
        System.out.println("Primera temperatura mayor a " + tempDada + ": " + estacion.mayorTemp(tempDada));


        System.out.println("¿Están las temperaturas en orden creciente?: " + estacion.ordenCreciente());
    }
}
