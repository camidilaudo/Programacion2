package ejercicio2;

import ejercicio1.*;


public class ArrayMap<K,V> implements Map<K,V>{
	
	// ATRIBUTOS
	private int size;
	private Entry<K,V>[] array;
	
	
	// CONSTRUCTOR
	public ArrayMap(int capacidad) {
		array = (Entry<K,V>[]) new Entry[capacidad];
		size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		int i = 0;
		boolean encontreClave=false;
		
		while(!encontreClave && i<size) {
			if(array[i].getKey()==k) {
				encontreClave=true;
			}
			else {i++;}
		}
		if(!encontreClave) {return null;}
		else {
			return array[i].getValue();
		}
	}

	@Override
	public V put(K k, V v) {
		// TODO Auto-generated method stub
		int i = 0;
		boolean encontreClave=false;
		
		while(!encontreClave && i<size) {
			if(array[i].getKey()==k) {
				encontreClave=true;
			}
			else {i++;}
		}
		if (!encontreClave) {
			if (size<array.length) {
				array[size] = new Entrada(k,v);
				size++;
				return null;
			}
			else {throw new MyException("Arreglo lleno");}
		}
		else {
			V auxiliar = array[i].getValue();
			array[i].setValue(v);
			return auxiliar;}

		}


	public V remove(K k) {
		int i=0;
		boolean encontreClave=false;
		while(!encontreClave && i<size) {
			if(array[i].getKey()==k)
				encontreClave=true;
			else
				i++;
		}
		if(!encontreClave)
			return null;
		else {
			V auxiliar = array[i].getValue();
			array[i] = array[size-1];
			size--;
			return auxiliar;
		}
	}
	

	public K[] keys() {
	    K[] aux = (K[]) new Object[size];
	    for (int i = 0; i < size; i++) {
	        aux[i] = array[i].getKey();
	    }
	    return aux;
	}

	
	public V[] values() {
		//me creo un arreglo auxiliar
		V[] aux = (V[])new Object[size];
		//recorro array pidiendo las claves
		for(int i=0;i<size;i++)
		//las agrego a auxiliar
			aux[i]=array[i].getValue();
		//devuelvo auxiliar
		return aux;
	}

	@Override
	public Entry<K,V>[] entries(){
		Entry<K,V>[] auxArray = (Entry<K,V>[])new Entrada[size];
		for(int i=0;i<size;i++)
			auxArray[i]=new Entrada(array[i].getKey(),array[i].getValue());
		return auxArray;
	}
	
}
