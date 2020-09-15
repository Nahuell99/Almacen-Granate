package Comercio;

import java.util.ArrayList;

import Carrito.Articulo;
import Carrito.Carrito;

public class Comercio extends Actor{
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	ArrayList<DiaRetiro> lstDiaRetiro = new ArrayList<DiaRetiro>(); 
	ArrayList<Carrito> lstCarrito = new ArrayList<Carrito>();
	ArrayList<Articulo> lstArticulo = new ArrayList<Articulo>();
	
	public Comercio(int id, String email, String celular, double latitud, double longitud,String nombreComercio,long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo, DiaRetiro lstDiaRetiro, Carrito lstCarrito, Articulo lstArticulo) {
		super(id, new Contacto( email,  celular,  latitud,  longitud));
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro.add(lstDiaRetiro);
		this.lstCarrito.add(lstCarrito);
		this.lstArticulo.add(lstArticulo);
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
		if( !((cuit > 30000000000L && cuit < 30999999999L) || (cuit > 33000000000L && cuit < 34999999999L)) ) {
			throw new Exception("Los CUIT de empresas comienzan con 30, 33 o 34");
		}
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
	
	public void agregarDiaRetiro(DiaRetiro DiaRetiroA){
		lstDiaRetiro.add(DiaRetiroA);
		}
	
	public void agregarLstCarrito(Carrito lstCarritoA){
		lstCarrito.add(lstCarritoA);
	}
	public void agregarLstCarrito(Articulo lstArticuloA){
		lstArticulo.add(lstArticuloA);
	}
	
	public Articulo traerArticuloCod (String codBarra) {
		for(Articulo str : lstArticulo)
		{
		    //imprimimos el objeto pivote
		    System.out.println(str);
		}
		
		return null;
	}
	
}
