package ejercicio4;

public interface Queue<A> {
	
	public void enqueue(A element);
	public A dequeue();
	public A fornt();
	public int size();
	public boolean isEmpty();

}
