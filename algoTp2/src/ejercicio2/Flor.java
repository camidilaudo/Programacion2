package ejercicio2;

public class Flor {

	// atributos
	private String nombre;
	private int cantPetalos;
	private float precio;
	
	
	// constructores 
	public Flor(String nombre, int cantPetalos, float precio) {
		this.setNombre(nombre);
		this.setCantPetalos(cantPetalos);
		this.setPrecio(precio);
	}
	
	public Flor() {
		this.setNombre("Margarita");
		this.setCantPetalos(10);
		this.setPrecio((float) 34.3);
	}

	
	// METODOS
	
	
	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantPetalos() {
		return cantPetalos;
	}

	public void setCantPetalos(int cantPetalos) {
		this.cantPetalos = cantPetalos;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
