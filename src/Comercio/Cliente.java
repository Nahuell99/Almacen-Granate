package Comercio;

public class Cliente extends Actor{
	private String apellido;
	private String nombre;
	private int dni;
	
	public Cliente(int id, String email, String celular, double latitud, double longitud, String apellido, String nombre, int dni) {
		super(id, new Contacto( email,  celular,  latitud,  longitud));
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
	
}
