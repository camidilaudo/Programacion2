package arrayMap;


public class Main {
    public static void main(String[] args) {
        ArrayMap<String, Integer> mapa = new ArrayMap<>(10);

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
        
        
        // EL MAIN DEL PROFE : 
    		ArrayMap<Integer,String> diccionario = new ArrayMap<>(10);
    		System.out.print("Ingrese una clave: ");
    		String key = System.console().readLine();
    		int keyN = Integer.parseInt(key);
    		System.out.print("Ingrese un valor: ");
    		String value = System.console().readLine();
    		String salida = diccionario.put(keyN, value);
    		System.out.println("Valor retornado: "+salida);
    		while(keyN!=-1 && value!="-1") {
    			System.out.print("Ingrese una clave: ");
    			key = System.console().readLine();
    			keyN = Integer.parseInt(key);
    			System.out.print("Ingrese un valor: ");
    			value = System.console().readLine();
    			salida = diccionario.put(keyN, value);
    			System.out.println("Valor retornado: "+salida);
    		}
    		diccionario.remove(-1);
    		System.out.println("El diccionario creado es:");
    		System.out.print("{");
    		Entry<Integer,String>[] entradas = diccionario.entries();
    		for(int i = 0; i<entradas.length;i++)
    			System.out.print(" ( "+entradas[i].getKey()+" , "+entradas[i].getValue()+" ) |");
    		System.out.print("}");
    		
    	}
    	
    	static boolean sonDiccionariosIguales(ArrayMap<Integer,String> unDiccionario, ArrayMap<Integer,String> otroDiccionario) {
    		if(unDiccionario.size()!=otroDiccionario.size())
    			return false;
    		Entry<Integer,String>[] entradasUnDiccionario = unDiccionario.entries();
    		int i =0;
    		boolean sonIguales=true;
    		while(i<entradasUnDiccionario.length && sonIguales) {
    			sonIguales=otroDiccionario.get(entradasUnDiccionario[i].getKey()).equals(entradasUnDiccionario[i].getValue());
    			i++;
    		}
    		return sonIguales;
    	

    

    }
}
