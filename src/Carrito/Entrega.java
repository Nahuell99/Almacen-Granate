package Carrito;

import java.time.LocalDate;

public abstract class Entrega {
	protected int id;
	protected boolean tipoEntrega;
	protected LocalDate fecha;
	protected boolean efectivo;
	
	public Entrega( boolean tipoEntrega,int id, LocalDate fecha, boolean efectivo) {

		this.tipoEntrega=tipoEntrega;
		this.id = id;
		this.fecha = fecha;
		this.efectivo = efectivo;
	}
	
	public boolean isTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(boolean tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
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
	
	public boolean isEfectivo() {
		return efectivo;
	}
	
	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}
	
}