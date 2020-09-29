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
	ArrayList<DiaRetiro> lstDiaRetiro; 
	ArrayList<Carrito> lstCarrito;
	ArrayList<Articulo> lstArticulo;
	
	public Comercio(int id,Contacto contacto,String nombreComercio,long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		try {
			this.setCuit(cuit);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		if(! validarIdentificadorUnicoCUIT(cuit) )  {
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
	
	public void agregarDiaRetiro(DiaRetiro DiaRetiroA){
		lstDiaRetiro.add(DiaRetiroA);
		}
	
	public void agregarLstCarrito(Carrito lstCarritoA){
		lstCarrito.add(lstCarritoA);
	}
	public void agregarLstArticulo(int id, String nombre,String codBarra, double precio)throws Exception{
		lstArticulo.add(new Articulo(id, nombre, codBarra, precio));
	}

	public Articulo traerArticuloCod (String codBarra) {
		int i = 0;
		//for(i = 0; i < lstArticulo.size(); i++)
		while(i < lstArticulo.size())
		{
		    if(lstArticulo.get(i).getCodBarra().equals(codBarra)) {
		    	return lstArticulo.get(i);
		    }
		    i++;
		}
		
		return null;
	}
	
	public Carrito traerCarritoId(int id) {
		for(Carrito str : lstCarrito)
		{
		    if(str.getId() == id) {
		    	return str;
		    }
		}
		return null;
	}

	
	
	
	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit + ", costoFijo=" + costoFijo
				+ ", costoPorKm=" + costoPorKm + ", diaDescuento=" + diaDescuento + ", porcentajeDescuentoDia="
				+ porcentajeDescuentoDia + ", porcentajeDescuentoEfectivo=" + porcentajeDescuentoEfectivo
				+ ", lstDiaRetiro=" + lstDiaRetiro + ", lstCarrito=" + lstCarrito + ", lstArticulo=" + lstArticulo
				+ "]";
	}

	
	
	
	
}
