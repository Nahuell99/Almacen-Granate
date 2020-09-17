package Carrito;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Comercio.Cliente;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	ArrayList<ItemCarrito> lstItemCarrito = new ArrayList<ItemCarrito>();
	private Entrega entrega;
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
			Articulo articulo, int cantidad, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;	
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad) );
		this.entrega = entrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(ArrayList<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	public void agregarlstItemCarritoA(ItemCarrito lstItemCarritoA){
		lstItemCarrito.add(lstItemCarritoA);
	}
	
	public double calcularTotalCarrito() {
        double total = 0;
        int i = 0;
        while(i<lstItemCarrito.size()) {
            total += lstItemCarrito.get(i).calcularSubTotalItem();
        }
        return total;
    }
	
	public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		double radioTierra = 6371; //en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 =Math.pow(sindLat, 2)+Math.pow(sindLng, 2)*Math.cos(Math.toRadians(lat1))*
		Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
		}
	
	
}
