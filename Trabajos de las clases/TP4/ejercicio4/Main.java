package ejercicio4;

import ejercicio4.PilaCola;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedStack<LinkedQueue<Integer>> P1 = new LinkedStack<LinkedQueue<Integer>>();
		LinkedStack<LinkedQueue<Integer>> P2 = new LinkedStack<LinkedQueue<Integer>>();

		
		LinkedQueue<Integer> q1 = new LinkedQueue<>();
		q1.enqueue(1);
		LinkedQueue<Integer> c1 = new LinkedQueue<>();
		c1.enqueue(1);
		
		P1.push(q1);
		P2.push(c1);


		LinkedQueue<Integer> q2 = new LinkedQueue<>();
		q2.enqueue(1);
		q2.enqueue(2);
		LinkedQueue<Integer> c2 = new LinkedQueue<>();
		c2.enqueue(2);
		c2.enqueue(2);
		
		P1.push(q2);
		P2.push(c2);


		LinkedQueue<Integer> c3 = new LinkedQueue<>();
		c3.enqueue(3);
		c3.enqueue(3);
		c3.enqueue(3);

		P2.push(c3);
		
		LinkedStack<LinkedQueue<Integer>> POUT = PilaCola.unir(P1,P2);
		while (!POUT.isEmpty()) {
		    LinkedQueue<Integer> aux = POUT.pop();
		    System.out.println(PilaCola.print(aux));
		}


		
	

	}
	

	

}
