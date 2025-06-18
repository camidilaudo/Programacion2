package LinkedStack;

public class LinkedStack<T> implements Stack<T>{
	
	private Node<T> top;
	private int  size;
	
	public LinkedStack() {
		top = null;
		size=0;
	}

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		Node<T> newNode = new Node<T>(item);
		newNode.setNext(top);
		top = newNode;
		size++;
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(size==0)
			throw new MyException("La lista está vacia");
	    Node<T> oldTop = top;
	    top = oldTop.getNext();
	    oldTop.setNext(null);           
	    size--;                       
	    return oldTop.getElement(); 

	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (top==null) {
			throw new MyException("La lista esta vacia");
		}
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void printStack() {
	    Node<T> current = top;
	    while (current != null) {
	        System.out.println(current.getElement());
	        current = current.getNext();
	    }
	}
	
	 public static <T> LinkedStack<T> invertir(LinkedStack<T> original) {
	        LinkedStack<T> invertida = new LinkedStack<>();
	        LinkedStack<T> copia = new LinkedStack<>();

	        // Paso 1: Vaciar el original en copia (sin perder elementos)
	        while (!original.isEmpty()) {
	            T elem = original.pop();
	            copia.push(elem);
	            invertida.push(elem); // también lo invertimos aquí
	        }

	        // Paso 2: Restaurar original
	        while (!copia.isEmpty()) {
	            original.push(copia.pop());
	        }

	        return invertida;
	    }

	
	

	

}
