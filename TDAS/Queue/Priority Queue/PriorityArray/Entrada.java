package PriorityArray;

public class Entrada< K extends Comparable <K> , V > implements Entry<K,V>{

	private K clave;
	private V value;
	
	public Entrada(K k,V v) {
		clave = k;
		value = v;
	}
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return clave;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public void setKet(K k) {
		clave = k;
	}
	
	public void setValue(V v) {
		value = v;
	}
	
	public String toString() {
		return "(" + getKey() + ", " + getValue() + ")";
	}

	

}
