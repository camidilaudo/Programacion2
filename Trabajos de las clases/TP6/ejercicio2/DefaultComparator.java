package ejercicio2;

public class DefaultComparator<E> implements java.util.Comparator<E>{

	@Override
	public int compare(E a, E b) { return ((Comparable)a).compareTo(b); }
	
	

}
