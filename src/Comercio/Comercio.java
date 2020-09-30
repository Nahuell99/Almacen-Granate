package Comercio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Carrito.Articulo;
import Carrito.Carrito;
import Carrito.Entrega;
import Carrito.Envio;
import Carrito.ItemCarrito;

public class Comercio extends Actor {
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	ArrayList<DiaRetiro> lstDiaRetiro;
	ArrayList<Carrito> lstCarrito;
	ArrayList<Articulo> lstArticulo;

	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		super( id, contacto);
		this.nombreComercio = nombreComercio;
		this.setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstCarrito = new ArrayList<Carrito>();
		this.lstArticulo = new ArrayList<Articulo>();
	}





	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) throws Exception {
		if (!validarIdentificadorUnicoCUIT(cuit)) {
			throw new Exception("CUIT Invalido");
		}
		this.cuit = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	public void agregarDiaRetiro(int id, int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		lstDiaRetiro.add(new DiaRetiro(id, diaSemana,  horaDesde,horaHasta, intervalo));
	}

	public void agregarLstCarrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente) throws Exception {
		lstCarrito.add(new Carrito(id,  fecha,  hora,  cerrado,  descuento,  cliente));
	}

	public void agregarLstArticulo(int id, String nombre, String codBarra, double precio) throws Exception {
		lstArticulo.add(new Articulo(id, nombre, codBarra, precio));
	}

	public Articulo traerArticuloCod(String codBarra) {
		Articulo traerArt = null;
		int i = 0;
		// for(i = 0; i < lstArticulo.size(); i++)
		while (i < lstArticulo.size() && traerArt == null) {
			if (lstArticulo.get(i).getCodBarra().equals(codBarra)) {
				traerArt = lstArticulo.get(i);
			}
			i++;
		}
		return traerArt;
	}

	public Carrito traerCarritoId(int id) {
		Carrito traerCarrito = null;
		for (Carrito str : lstCarrito) {
			if (str.getId() == id) {
				traerCarrito = str;
			}
		}
		return traerCarrito;
	}

	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit + ", costoFijo=" + costoFijo
				+ ", costoPorKm=" + costoPorKm + ", diaDescuento=" + diaDescuento + ", porcentajeDescuentoDia="
				+ porcentajeDescuentoDia + ", porcentajeDescuentoEfectivo=" + porcentajeDescuentoEfectivo
				+ ", lstDiaRetiro=" + lstDiaRetiro + ", lstCarrito=" + lstCarrito + ", lstArticulo=" + lstArticulo
				+ "]";
	}
	
public Cliente nuevoCliente(int id, Contacto contacto, String apellido, String nombre, long dni, char genero) throws Exception {
	Cliente cliente=new Cliente( id,  contacto,  apellido,  nombre,  dni,  genero);
	return cliente;
}

public Entrega nuevaEntrega(boolean tipoEntrega, int id,  LocalDate fecha, boolean efectivo, LocalTime horaHasta, LocalTime horaDesde, Ubicacion ubicacion, Ubicacion ubicacionC, double costoFijo , double costoPorKm) {
	Entrega envio=new Envio( tipoEntrega,  id,   fecha,  efectivo,  horaHasta,  horaDesde,  ubicacion,  ubicacionC,  costoFijo ,  costoPorKm);
	return envio;
}

}
