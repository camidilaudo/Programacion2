package ejercicio5;

import ejercicio4.*;

public class TempEstacion extends TempMinEstacion{
	
	
	// CONSTRUCTOR
	public TempEstacion(float[] temperaturas) {
		super(temperaturas);
	}

	// METODOS
	
	
	// recorre el arreglo y devuelve el menor elemento
	public float menorTemperatura() {
		if (size==0) throw new MyException("Arreglo vacio");
		else {
			float menor = temperaturas[0];
			for (int i=1; size > i; i++) {
				if (menor > temperaturas[i])
					menor = temperaturas[i];			
			}
			return menor; 
		}
	}
	
	
	// devuelve la posicion del menor elemento
	public int posMenorTemperatura() {
		if (size==0) throw new MyException("Arreglo vacio");		
		else {
			int menor = 0;
			for (int i=0; size > i; i++) {
				if (menor > temperaturas[i])
					menor = i;			
			}
			return menor;
		}
	}
	
	// recorro toda la lista, si encuentro un nro negativo devuelvo false. 
	public boolean todosPositivos() {
		if (size==0) throw new MyException("Arreglo vacio");
		
		boolean positivo = true;
		for(int i = 0 ; i < size ; i++) {
			if (temperaturas[i] < 0) {return false;}
		}
		return true;
		
	}
	
	
	// comparo los dos arreglos y devuelvo la cantidad de coincidencias en posicion y elemento
	public int contarCoincidencias(TempEstacion s) {
		int coincidencias = 0;
		for (int i=0; i<size; i++)  {
			if (this.temperaturas[i] == s.temperaturas[i])
				coincidencias++;
		}
		return coincidencias;
	}
	
	
	// devuelve un nuevo arreglo invertido
	public TempEstacion invertir() {
	    float[] invertido = new float[temperaturas.length];
	    for (int i = 0; i < size; i++) {
	        invertido[i] = temperaturas[size - 1 - i];
	    }

	    TempEstacion nueva = new TempEstacion(invertido);
	    nueva.size = this.size; //
	    return nueva;
	}

	// reemeplaza todos los elementos del arreglo que sean el valor 1 con el valor 2
	public void reemplazar(float val1, float val2) {
		for (int i=0; i<size; i++) {
			if (temperaturas[i] == val1) {
				temperaturas[i] = val2;
			}
		}
	}
	
	
	// intercambia el elemento de la posicion 1 con el de la posicion 2
	public String intercambiar(int pos1, int pos2) {
		
		if (pos1 < size && pos2 < size) {
			float aux = temperaturas[pos1];
			temperaturas[pos1] = temperaturas[pos2];
			temperaturas[pos2] = aux;
			return "";
		}
		else {
			throw new MyException("No existen las posiciones");
		}

	}
	
	
	// invierte los elementos en el mismo arreglo
	public void invertirMe() {
		for(int i=0; i<size/2; i++) {
			float aux = temperaturas[i];
			temperaturas[i] = temperaturas[size -1 - i];
			temperaturas[size -1 - i] = aux;
		}
	}
}