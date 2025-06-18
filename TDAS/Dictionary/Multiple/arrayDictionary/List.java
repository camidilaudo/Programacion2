package arrayDictionary;

public interface List<V>{
	public void addFirst(V newElement);
	public void addLast(V newElement);
	public void removeFirst()throws MyException;
	public void removeLast()throws MyException;
	public void remove(V element)throws MyException;
	public void First();
	public void advance();
	public V getCurrent();
	public boolean atEnd();
	public int getSize();
}