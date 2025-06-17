package ejercicio6;

import ejercicio4.*;

public class LinkedDictionary<K,V> implements Dictionary<K,V>{
	
	protected Node<Entrada<K, List<V>>> head;
	protected Node<Entrada<K, List<V>>> tail;
	protected int size;


	public LinkedDictionary() {
		head=null;
		tail=null;
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
	public List<V> get(Object k) {
		// TODO Auto-generated method stub
		if(size==0) {
			return null;
		}
		Node<Entrada<K, List<V>>> actual = head; 
		while(actual != null && actual.getElement().getKey() != k) {
			actual = actual.getNext();
		}
		if(actual!=null) {
			return actual.getElement().getValue(); // aca abria que hacer una copia
		}
		else {return null;}
	}

	@Override
	public void put(K k, V v) {
		// TODO Auto-generated method stub
		if(size==0) {
			List<V> listaValores = new LinkedList<V>();
			listaValores.addFirst(v);
			Entrada<K, List<V>> entrada = new Entrada<K, List<V>>(k, listaValores);
			Node<Entrada<K,List<V>>> nuevoNodo = new Node<Entrada<K, List<V>>>(entrada);
			head = nuevoNodo;
			tail = nuevoNodo;
			size++;
			
		}
		
		if(head.getElement().getKey() == k) {
			head.getElement().getValue().addLast(v);
		}
		
		Node<Entrada<K, List<V>>> actual = head;
		while(actual != null && actual.getElement().getKey() != k) {
			actual = actual.getNext();
		}
		
		if(actual != null) {
			actual.getElement().getValue().addLast(v);
		}
		else {
			List<V> listaValores = new LinkedList<V>();
			listaValores.addFirst(v);
			Entrada<K, List<V>> entrada = new Entrada<K, List<V>> (k, listaValores);
			Node<Entrada<K, List<V>>> nuevoNodo = new Node<Entrada<K, List<V>>>(entrada);
			tail.setNext(nuevoNodo);
			nuevoNodo.setPrevious(tail);
			tail = nuevoNodo;
			size++;
		}
		
	}

	@Override
	public List remove(K k) {
		// TODO Auto-generated method stub
		
		if(size==0) {
			return null;
		}
		
		if(head.getElement().getKey() == k) {
			List<V> valor = head.getElement().getValue(); // hacer copia
			head.getNext().setPrevious(null);
			head = head.getNext();
			size--;
			return valor;
		
		}
		Node<Entrada<K,List<V>>> actual = head;
		while (actual != null && actual.getElement().getKey() != k) {
			actual = actual.getNext();
		}
		
		if(actual != null) {
			List<V> valor = actual.getElement().getValue(); // hacer copia
			actual.getPrevious().setNext(actual.getNext());
			if(actual.getNext() != null) {
				actual.getNext().setPrevious(actual.getPrevious());
			}
			else {
				tail = actual.getPrevious();
			}
			size--;
			return valor;
		}
		else {
			return null;
		}
		
	}

	@Override
	public V remove(K k, V v) {
		// TODO Auto-generated method stub
		if(size==0) {
			return null;
		}
		Node<Entrada<K,List<V>>> actual = head;
		while(actual != null && actual.getElement().getKey() != k) {
			actual = actual.getNext();
		}
		if (actual != null) {
			List<V> listaValores = actual.getElement().getValue();
			listaValores.First();
			while(!listaValores.atEnd() && listaValores.getCurrent() != v) {
				listaValores.advance();
			}
			if(!listaValores.atEnd()) {
				listaValores.remove(v);
				if(listaValores.getSize() == 0) {
					actual.getPrevious().setNext(actual.getNext());
					if(actual.getNext() != null) {
						actual.getNext().setPrevious(actual.getPrevious());
					}
					else {
						tail = actual.getPrevious();
					}
					size--;
				}
				return v;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> claves = new LinkedList<K>();
		Node<Entrada<K, List<V>>> actual = head;
		while(actual != null) {
			claves.addLast(actual.getElement().getKey());
			actual = actual.getNext();
		}
		return claves;
	}

	@Override
	public List entries() {
		// TODO Auto-generated method stub
		
		// HAY Q HACER COPIA DE LIST<V>
		
		List<Entrada<K, List<V>>> entradas = new LinkedList<Entrada<K, List<V>>>();
		Node<Entrada<K, List<V>>> actual = head;
		while(actual != null) {
			entradas.addLast(actual.getElement());
			actual = actual.getNext();
		}
		return entradas;
	}

}
