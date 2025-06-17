package ejercicio4;

public class PilaCola {
	
	public static LinkedStack<LinkedQueue<Integer>> unir(LinkedStack<LinkedQueue<Integer>> P1, LinkedStack<LinkedQueue<Integer>> P2){
	    LinkedStack<LinkedQueue<Integer>> Pout = new LinkedStack<>();

	    while (!P1.isEmpty() || !P2.isEmpty()) {
	        LinkedQueue<Integer> aux = new LinkedQueue<>();

	        if (!P1.isEmpty()) {
	            LinkedQueue<Integer> q1 = P1.pop();
	            int size = q1.size();
	            for (int i = 0; i < size; i++) {
	                int val = q1.dequeue();
	                aux.enqueue(val);
	            }
	        }

	        if (!P2.isEmpty()) {
	            LinkedQueue<Integer> q2 = P2.pop();
	            int size = q2.size();
	            for (int i = 0; i < size; i++) {
	                int val = q2.dequeue();
	                aux.enqueue(val);
	            }
	        }

	        Pout.push(aux);
	    }

	    return invertir(Pout); // Esto invierte toda la pila una vez al final
	}

	
	public static <T> LinkedStack<T> invertir(LinkedStack<T> stack) {
        LinkedStack<T> invertida = new LinkedStack<>();
        while (!stack.isEmpty()) {
            invertida.push(stack.pop());
        }
        return invertida;
    }
	
	public static String print(LinkedQueue<Integer> q) {
		
		String cola="[";
		while(!q.isEmpty()) {
			cola += q.dequeue();
			cola+=", ";
		}
		cola += "]";
		cola += ". ";
		return cola;
	}


}
