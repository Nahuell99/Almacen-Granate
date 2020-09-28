package Comercio;

public class Cliente extends Actor{
	private String apellido;
	private String nombre;
	private long dni;
	private char genero;
	
	public Cliente(int id, Contacto contacto, String apellido, String nombre, long dni, char genero)throws Exception {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.genero = genero;
		this.setDni(dni);
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) throws Exception  {
		if(! validarIdentificadorUnicoDNI(dni))  {
			throw new Exception("DNI invalido");
		}
		this.dni = dni;
	}
	
	
	
}
