package ejercicio4;

public class TempMinEstacion {
	
	// ATRIBUTOS
	protected float [] temperaturas;
	protected int size;
	
	
	// CONSTRUCTOR
    public TempMinEstacion(float[] temperaturas) {
        this.temperaturas = temperaturas;
    }

    // METODOS
    
    
    // agrega un nuevo elemento a la lista
	public void agregarTemp(float nuevaTemp) {
		if (size < temperaturas.length) {
			temperaturas[size] = nuevaTemp;
			size++;
			}
		else {throw new MyException("Arreglo lleno");}
	}
	
	
	// recorre el arreglo y devuelve la mayor temperatura
	public float getMayorTemp() {
		if (size==0) throw new MyException("Arreglo vacio");		
		else {
			float mayor = temperaturas[0];
			for (int i=1; i<size; i++) {
				if (mayor < temperaturas[i])
					mayor = temperaturas[i];			
			}
			return mayor;
		}
	}
	
	
	// promedio de los elementos agregados de la lista
	public float promTemp() {
		int suma = 0;
		for (int i = 0; i<size; i++) {
			 suma += temperaturas[i];
		}
		return suma / size;
	}
	
	
	// recorre el arreglo y devuelve la cantidad de elementos menores a 0
	public int cantHeladas() {
		int heladas = 0;
		for (int i = 0; i<size; i++) {
			if (temperaturas[i]<0) 
				heladas ++;
		}
		return heladas;
	}
	
	
	// recorre el arreglo y devuelve true si hay un elementos menor a 0
	public boolean huboHeladas() {
		for (int i = 0; size>i; i++) {
			if (temperaturas[i]<0)
				return true;
		}
		return false;
	}
	
	
	// recorre el arreglo y compara con el parametro, devuelve el mayor
	public float mayorTemp(float tempDada) {
		for (int i = 0; i < size; i++) {
			if (temperaturas[i]> tempDada)
				return temperaturas[i];
		}
		return tempDada;
	}
	
	
	// se fija si los elementos estan en orden creciente
	public boolean ordenCreciente() {
		float menor = temperaturas[0];
		for (int i = 1; size>i; i++) {
			if (menor>temperaturas[i])
				return false;
		}
		return true;
	}
	
	
	// imprime los elementos de la lista
	public void mostrarTemperaturas() {
	    for (int i = 0; i < size; i++) {
	        System.out.print(temperaturas[i] + " ");
	    }
	    System.out.println();
	}
		
	
	
	public String temperaturasComoString() {
	    String resultado = "";
	    for (int i = 0; i < size; i++) {
	        resultado += temperaturas[i];
	        if (i < size - 1) {
	            resultado += " ";
	        }
	    }
	    return resultado;
	}


	
	

}
