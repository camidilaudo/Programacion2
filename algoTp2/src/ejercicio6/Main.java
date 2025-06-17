package ejercicio6;

public class Main {
    
    public static void main(String[] args) {

        LinkedList lista = new LinkedList();
        

        lista.agregarTemp(3.5f);
        lista.agregarTemp(-1.2f);
        lista.agregarTemp(0.0f);
        lista.agregarTemp(5.1f);
        lista.agregarTemp(3.5f);
        
        System.out.println("Temperaturas :");
        lista.imprimirLista(lista);
        
        // mayor temperatura
        System.out.println("Mayor temperatura: " + lista.getMayorTemp());
        
        // menor temperatura
        System.out.println("Menor temperatura: " + lista.getMenorTemp());
        
        // promedio de las temperaturas
        System.out.println("Promedio de temperaturas: " + lista.promTemp());
        
        // heladas 
        System.out.println("Cantidad de heladas: " + lista.cantHeladas());
        
        // hubo alguna helada
        System.out.println("¿Hubo heladas? " + (lista.huboHeladas() ? "Sí" : "No"));
        
        // todas las temperaturas son positivas
        System.out.println("¿Todas las temperaturas son positivas? " + (lista.todosPos() ? "Sí" : "No"));
        
        // posición de la menor temperatura
        System.out.println("Posición de la menor temperatura: " + lista.posMenorTemp());
        
        // invertir la lista
        LinkedList listaInvertida = lista.invertir();
        System.out.println("Temperaturas invertidas:");
        lista.imprimirLista(listaInvertida);
        
        // reemplazar temperaturas
        lista.reemplazar(3.5f, 7.7f);
        System.out.println("Lista después de reemplazar 3.5 por 7.7:");
        lista.imprimirLista(lista);
        
        // intercambiar posiciones
        lista.intercambiar(1, 3);
        System.out.println("Lista después de intercambiar posiciones 1 y 3:");
        lista.imprimirLista(lista);
        
        // comparar dos listas 
        LinkedList lista2 = new LinkedList();
        lista2.agregarTemp(7.7f);
        lista2.agregarTemp(-1.2f);
        lista2.agregarTemp(0.0f);
        lista2.agregarTemp(5.1f);
        lista2.agregarTemp(3.5f);
        
        System.out.println("Coincidencias entre listas: " + lista.contarCoincidencias(lista2));
    }

}
