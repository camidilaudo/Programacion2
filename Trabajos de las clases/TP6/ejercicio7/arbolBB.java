package ejercicio7;

import java.util.Comparator;

public class arbolBB<E extends Comparable<E>> implements ABB<E> {
	
	protected NodoABB<E> raiz;
	protected int size;
	Comparator<E> comp;
	
	//CONSTRUCTOR
	public arbolBB(Comparator<E> comp) { 
		raiz = new NodoABB<E>(null,null); 
		size = 0;
		this.comp = comp;
	}
	
	// BUSCAR UN ELEMENTO
	public boolean pertenece( E elemento ) { 
		return buscar(elemento).getElemento() != null; 
	}
	private NodoABB<E> buscar( E elemento ) {
		return buscarAux( elemento, raiz );
	}
	private NodoABB<E> buscarAux( E elemento, NodoABB<E> nodov ) {
		 if( nodov.getElemento() == null ) 
			 return nodov;
		 else{
			 int c = comp.compare( elemento, nodov.getElemento() );
			 if( c == 0 ) return nodov;
			 else 
				 if( c < 0 ) 
					 return buscarAux( elemento, nodov.getIzq() );
				 else 
					 return buscarAux( elemento, nodov.getDer() );
		 }
	}
	
	// INSERTAR UN ELEMENTO
	
	// 1. inserta el elemento y crea hijos en null
	public void insertar( E elemento ) throws MyException {
		NodoABB<E> nodov = buscar( elemento );
		if( nodov.getElemento() == null ) {
			nodov.setElemento( elemento );
			nodov.setIzq( new NodoABB<E>( null, nodov ) );
			nodov.setDer( new NodoABB<E>( null, nodov ) );
			size++;
		}
		else {
			throw new MyException("Error : El elemento ya esta en el arbol. ");
		}
	}
	
	// 2. insertar alternativo recursivo :
	public void insertar2( E elemento ) {
		insertarAux( elemento, raiz ); 
	}
	// 
	private void insertarAux( E elemento, NodoABB<E> nodov ) throws MyException {
		if( nodov.getElemento() == null ) {
			nodov.setElemento( elemento ); 
			size++;
			nodov.setIzq( new NodoABB<E>( null, nodov ) );
			nodov.setDer( new NodoABB<E>( null, nodov ) );
		} 
		else {
			int c = comp.compare( elemento, nodov.getElemento() );
			if( c == 0 ) { throw new MyException("Error : El elemento ya esta en el arbol. "); }
			else 
				if( c < 0 ) 
					insertarAux( elemento, nodov.getIzq() );
				else 
					insertarAux( elemento, nodov.getDer() );
		}
	}
	 
	// ELIMINAR UN ELEMENTO
	
	// retorna null si no pudo eliminar a k, retorna k si la pudo eliminar
	public E eliminar( E elemento ) {
		NodoABB<E> p = buscar( elemento );
		if( p.getElemento() != null ) {
			E eliminado = p.getElemento();
			eliminarAux( p );
			size--;
			return eliminado;
		} 
		else 
			return null;
	}
	
	// si es hoja, devuelve true, si tiene algun hijo, devuelve false
	private boolean isExternal( NodoABB<E> p ) { 
		return p.getIzq().getElemento() == null && p.getDer().getElemento() == null; 
	}
	private boolean soloTieneHijoIzquierdo( NodoABB<E> p ) {
		return p.getIzq().getElemento() != null &&  p.getDer().getElemento() == null;
	}
	private boolean soloTieneHijoDerecho( NodoABB<E> p ) {
		return p.getDer().getElemento() != null && p.getIzq().getElemento() == null;
	}
	
	
	private void eliminarAux( NodoABB<E> p ) {
		if( isExternal(p) ) {  // p es hoja: Convertir el nodo en un dummy y soltar sus hijos dummy.
			p.setElemento( null );  
			p.setIzq( null );  
			p.setDer( null );
		}
		else {  // p no es hoja
			if( soloTieneHijoIzquierdo(p) ) {
				// Enganchar al padre de p con el hijo izquierdo de p
				if( p == raiz ) { // si p es la raíz del árbol
					raiz = p.getIzq(); // el nuevo nodo raíz es el hijo izquierdo
					raiz.setPadre(null); // la nueva raíz no tiene padre
				}
				else {
					if( p.getPadre().getIzq() == p ) // p es el hijo izquierdo de su padre
						p.getPadre().setIzq( p.getIzq() );  // el hijo izq del padre de p es ahora el hijo de p
					else // p es el hijo derecho de su padre
						p.getPadre().setDer( p.getIzq() ); // el hijo derecho del padre de p es el hijo de p
					p.getIzq().setPadre( p.getPadre() ); // Ahora el padre del hijo izq de p es su abuelo
				}
			} 
			else 
				if( soloTieneHijoDerecho(p) ) {
					// Enganchar al padre de p con el hijo derecho de p
					if( p == raiz ) { // si p es la raíz del árbol
						raiz = p.getDer(); // el nuevo nodo raíz es el hijo derecho
						raiz.setPadre(null); // la nueva raíz no tiene padre
					}
					else {
						if( p.getPadre().getIzq() == p ) // p es hijo izquierdo de su padre
							p.getPadre().setIzq( p.getDer() ); // el hijo izq del padre de p es el hijo de p
						else
							p.getPadre().setDer( p.getDer() ); // el hijo derecho del padre de p es el hijo de p
						p.getDer().setPadre( p.getPadre() ); // Ahora el padre del hijo der. de p es su abuelo
					}
				} 
				else { // p tiene dos hijos: seteo como rótulo de p al rótulo del sucesor inorder de p.
					p.setElemento( eliminarMinimo( p.getDer() ) );
				}
		}	
	}

	
	// Elimina el nodo con elemento mínimo del subárbol que tiene como raíz a p
	// El mínimo rótulo del subárbol que tiene como raíz a p es el rótulo del primer nodo que 
	// encuentro yendo a la izquierda que no tiene hijo izquierdo 
	private E eliminarMinimo( NodoABB<E> p ) {
		if( p.getIzq().getElemento() == null ) {  // El hijo izquierdo de p es un dummy
			E aRetornar = p.getElemento();  // salvo el rótulo a devolver
			if( p.getDer().getElemento() == null ) { // p es hoja (pues sus hijos son dummy)
				p.setElemento( null ); // Convierto a p en dummy haciendo nulo su rótulo
				p.setIzq( null ); // y desenganchando sus dos hijos dummy
				p.setDer( null );
			} 
			else { 
				// p solo tiene hijo derecho (xq no tiene izquierdo)
				// Engancho al padre de p con el hijo derecho de p.
				// Seguro tiene que ser el hijo derecho de su padre.
				p.getPadre().setIzq( p.getDer() );
				p.getDer().setPadre( p.getPadre() );
			}
			return aRetornar;
		} 
		else { // Si p tiene hijo izquierdo, entonces p.getRotulo() no es el mínimo.
			// El mínimo tiene que estar en el subárbol izquierdo
			return eliminarMinimo( p.getIzq() );
		}
	
	}

	//un método para mostrar el árbol
	public String toString() {
		return inorder( raiz );
	}
	private String inorder( NodoABB<E> nodov ) {
		if( nodov.getElemento() != null ) {
			return "(" + inorder( nodov.getIzq()) + nodov.getElemento() + inorder( nodov.getDer() ) + ")";
		}	 
		else return "";
	}
	private String preorder( NodoABB<E> nodov ) {
		if( nodov.getElemento() != null ) {
			return "(" + nodov.getElemento() + preorder(nodov.getIzq()) + preorder(nodov.getDer()) + ")";
		}	 
		else return "";
	}
	private String postorder( NodoABB<E> nodov ) {
		if( nodov.getElemento() != null ) {
			return "(" + postorder(nodov.getIzq()) + postorder(nodov.getDer()) + nodov.getElemento() + ")";
		}	 
		else return "";
	}
	
	public NodoABB<E> getRaiz() {
	    return raiz;
	}

	public int getSize() {
	    return size;
	}


	
}
	
	


