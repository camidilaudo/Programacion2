package ejercicio4;

public interface Dictionary<K,V> {
	public int size();
	public boolean isEmpty(); 
	public List< V> get(K k); 
	public void put(K k, V v);
	public List<V> remove(K k); 
	public V remove(K k, V v); 
	public List<K> keys();
	public List <Entry<K,V>> entries(); 
	
}