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
			ItemCarrito itemCarrito) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;	
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito.add(itemCarrito );
		//this.entrega = envio;
	}
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
			Articulo articulo, int cantidad, RetiroLocal entrega) {
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

	public boolean getCerrado() {
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
		setCerrado(true);
	}
	
	public boolean agregarlstItemCarritoA(ItemCarrito lstItemCarritoA){
		int i = 0;
        while (i < lstItemCarrito.size()) {
            if (lstItemCarrito.get(i).getArticulo().equals(lstItemCarritoA.getArticulo())){
            	lstItemCarrito.get(i).setCantidad(lstItemCarrito.get(i).getCantidad() + lstItemCarritoA.getCantidad());
            	return false;
            }
            i++;
        }
        return lstItemCarrito.add(lstItemCarritoA);
	}
	
	public boolean quitarlstItemCarritoA(ItemCarrito lstItemCarritoA) throws Exception{
		int i = 0;
        while (i < lstItemCarrito.size()) {
        	// BUSCO UNA COINCIDENCIA CON EL PRODUCTO
            if (lstItemCarrito.get(i).getArticulo().equals(lstItemCarritoA.getArticulo())){
            	//SI LA CANTIDAD ES LA MISMA REMUEVO
            	if(lstItemCarrito.get(i).getCantidad() == lstItemCarritoA.getCantidad()) {
            		
            		return lstItemCarrito.remove(lstItemCarrito.get(i));
            	}//SI ES MENOR LE RESTO
            	else if (lstItemCarrito.get(i).getCantidad() > lstItemCarritoA.getCantidad()) {
            		lstItemCarrito.get(i).setCantidad(lstItemCarrito.get(i).getCantidad() - lstItemCarritoA.getCantidad());
            		
            		return true;
            	}
            	else {//SI RESTO MAS CANTIDAD DE LA QUE TENGO TIRO EXCEPTION
            		throw new Exception("No hay suficiente cantidad de productos en el carrito para eliminar");
            	}
            }
            i++;
        }
        throw new Exception("No se encuentra el producto en el carrito");
	}
	
	public double calcularTotalCarrito() {
        double total = 0;
        int i = 0;
        while(i<lstItemCarrito.size()) {
            total += lstItemCarrito.get(i).calcularSubTotalItem();
        }
        return total;
    }
	
	
	
	
	
	
	
	
}
