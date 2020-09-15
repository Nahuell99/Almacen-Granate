package Carrito;

public class Articulo {
	private int id;
	private String nombre;
	private String codBarra;
	private double precio;
	
	public Articulo(int id, String nombre, String codBarra, double precio) { //throws Exception {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		//if(!validarCodBarras(codBarra)) throw new Exception("Codigo de varra no validado del articulo: " + nombre);
		this.setCodBarra(codBarra); 
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodBarra() {
		return codBarra;
	}
	
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean validarCodBarras(String codBarraNuevo) {
		return (codBarraNuevo.length() == 13 || codBarraNuevo.length() == 8); 
	}   //El tamaño del codigo tiene que ser de 13 u 8 caracteres
	
	
}
