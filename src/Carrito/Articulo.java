package Carrito;

public class Articulo {
	private int id;
	private String nombre;
	private String codBarra;
	private double precio;
	
	public Articulo(int id, String nombre, String codBarra, double precio)throws Exception { // {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
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
	
	public void setCodBarra(String codBarra) throws Exception{
		if(!validarCodBarras(codBarra)) {
			throw new Exception("Codigo de barra no validado del articulo");
		}
		this.codBarra = codBarra;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//El tamaño del codigo tiene que ser de 13 u 8 caracteres
	public boolean validarCodBarras(String codBarra) {
        String[] codigoString = codBarra.split("");
        int[] codigoInt = new int[codigoString.length];
        int sumaPares = 0, sumaImpares = 0;

        if (codBarra.length() == 13) {

            for (int i = 0; i < codigoString.length; i++) {

                codigoInt[i] = Integer.parseInt(codigoString[i]);
                if (i % 2 == 0 && i != 12) {
                    sumaPares = sumaPares + codigoInt[i];
                }
                if (i % 2 == 1 && i != 13) {
                    sumaImpares = sumaImpares + codigoInt[i];
                }

            }
            int imparesParesSumados, contador = 0;
            imparesParesSumados = sumaPares + sumaImpares * 3;

            while (imparesParesSumados % 10 != 0) {
                contador++;
                imparesParesSumados++;
            }

            if (contador == codigoInt[12]) {
                this.codBarra = codBarra;
                return true;
            } else {
                System.out.println("Codigo invalido");
                return false;
            }

        } else {
            System.out.println("La longitud del codigo es invalida");
            return false;
        }
    }
	
	public boolean equals(Articulo articulo) {
        if(id==articulo.getId()||codBarra==articulo.getCodBarra()) {
            return true;
        }else {
            return false;
        }
    }
	
	public boolean equals(String codBarraN) {
        if(codBarra.equals(codBarraN)) {
            return true;
        }else {
            return false;
        }
    }

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", codBarra=" + codBarra + ", precio=" + precio + "]";
	}
	
	
}
