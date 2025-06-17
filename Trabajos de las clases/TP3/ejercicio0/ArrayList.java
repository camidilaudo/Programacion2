package ejercicio0;

public class ArrayList<A> implements List<A>{
	
	
	// ATRIBUTOS
	private A[] array;
	private int size;
	private int current;
	
	// CONSTRUCTORES
	public ArrayList(int capacidad) {
		array = (A[]) new Object [ capacidad ];	
		size = 0;
		}
		

	// METODOS
	
	@Override
	public void addFirst(A newElement) {
		// TODO Auto-generated method stub
		
		if (size == array.length) {throw new MyException("Lista llena");}
		
		// muevo todos los elementos a la derecha 
		for (int i = size ; i > 0 ; i--) {
			array[i]= array[i-1];
		}
		array[0]= newElement;
		size++;
	}

	@Override
	public void addLast(A newElement) {
		// TODO Auto-generated method stub
		if (size == array.length) {throw new MyException("Lista llena");}
		
		array[size]=newElement;
		size++;	
		
	}

	@Override
	public void removeFirst() throws MyException {
		// TODO Auto-generated method stub
		if (size == 0) {throw new MyException("Lista vacia");}
		
		// muevo todos los elementos a la izquierda 
		for(int i=0; i<size; i++) {
			array[i]=array[i+1];
		}
		array[size-1]=null;
		size--;
		

	}

	@Override
	public void removeLast() throws MyException {
		// TODO Auto-generated method stub
		if (size == 0) {throw new MyException("Lista vacia");}

		array[size-1]=null;
		size--;
		
	}

	@Override
	public void remove(A element) throws MyException {
		// TODO Auto-generated method stub
		if (size == 0) {throw new MyException("Lista vacia");}
		
		for (int i=0; i<size; i++) {
			if (array[i].equals(element)) {
				for(int i2=i; i2<size;i++) {
					array[i2]=array[i2+1];
				}
			}
			array[size-1]=null;
			size--;
		}

		
	}

	@Override
	public void First() {
		// TODO Auto-generated method stub
		current = 0;
		
	}

	@Override
	public void advance() {
		// TODO Auto-generated method stub
		if (current>=size) {throw new MyException("Fuera de la lista");}
		current++;
		
	}

	@Override
	public A getCurrent() {
		// TODO Auto-generated method stub
		if (current>=size) {throw new MyException("Fuera de la lista");}
		return array[current];
	}

	@Override
	public boolean atEnd() {
		// TODO Auto-generated method stub
		return size==array.length;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void printList() {
	    for (int i = 0; i < size; i++) {
	        System.out.println(array[i]);
	    }
	}


}
