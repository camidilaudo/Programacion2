package ejercicio2;

public class Main {

    public static void main(String[] args) {

        Flor florPorDefecto = new Flor();
        System.out.println("Flor por defecto:");
        System.out.println("Nombre: " + florPorDefecto.getNombre());
        System.out.println("Cantidad de pétalos: " + florPorDefecto.getCantPetalos());
        System.out.println("Precio: $" + florPorDefecto.getPrecio());

        Flor florPersonalizada = new Flor("Rosa", 25, 50.5f);
        System.out.println("\nFlor personalizada:");
        System.out.println("Nombre: " + florPersonalizada.getNombre());
        System.out.println("Cantidad de pétalos: " + florPersonalizada.getCantPetalos());
        System.out.println("Precio: $" + florPersonalizada.getPrecio());
    }
}
