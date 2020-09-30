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
	ArrayList<ItemCarrito> lstItemCarrito;
	private Entrega entrega;

	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente)
			throws Exception {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
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

	public boolean agregarlstItemCarritoA(Articulo articuloNuevo, int cantidad) {
		boolean itemNuevo = false;
		int i = 0;
		while (i < lstItemCarrito.size() && itemNuevo == false) {
			if (lstItemCarrito.get(i).getArticulo().equals(articuloNuevo)) {
				lstItemCarrito.get(i).setCantidad(lstItemCarrito.get(i).getCantidad() + cantidad);
				System.out.println("Producto existente, "+cantidad+" unidades agregadas " + articuloNuevo + ". Total:"
						+ lstItemCarrito.get(i).getCantidad());
				itemNuevo = true;
			}
			i++;
		}
		if (!itemNuevo) {
			System.out.println("Producto no existente, unidades agregadas. " + articuloNuevo);
			lstItemCarrito.add(new ItemCarrito(articuloNuevo, cantidad));
			itemNuevo=true;
		}
		return itemNuevo;
	}

	public boolean quitarlstItemCarritoA(ItemCarrito lstItemCarritoA) throws Exception {
		boolean itemRemovido = false;
		int i = 0;
		while (i < lstItemCarrito.size() && itemRemovido == false) {
			// BUSCO UNA COINCIDENCIA CON EL PRODUCTO
			if (lstItemCarrito.get(i).getArticulo().equals(lstItemCarritoA.getArticulo())) {
				// SI LA CANTIDAD ES LA MISMA REMUEVO
				if (lstItemCarrito.get(i).getCantidad() == lstItemCarritoA.getCantidad()) {
					System.out.println("Todas las unidades eliminadas del carrito");
					lstItemCarrito.remove(lstItemCarrito.get(i));
					itemRemovido = true;
				} // SI ES MENOR LE RESTO
				else if (lstItemCarrito.get(i).getCantidad() > lstItemCarritoA.getCantidad()) {
					lstItemCarrito.get(i)
							.setCantidad(lstItemCarrito.get(i).getCantidad() - lstItemCarritoA.getCantidad());
					System.out.println(lstItemCarrito.get(i).getCantidad() +" unidades restadas. Quedan:" + lstItemCarrito.get(i).getCantidad());
					itemRemovido = true;
				} else {// SI RESTO MAS CANTIDAD DE LA QUE TENGO TIRO EXCEPTION
					throw new Exception("No hay suficiente cantidad de productos en el carrito para eliminar");
				}
			}
			System.out.println("No se encuentra el producto en el carrito");
			i++;
		}

		return itemRemovido;
	}

	public double calcularTotalCarrito() {
		double total = 0;
		int i = 0;
		while (i < lstItemCarrito.size()) {
			total += lstItemCarrito.get(i).calcularSubTotalItem();
			i++;
		}
		return total;
	}

	/**
	 * Este método calcula el descuento a la segunda unidad si el dia es el correcto
	 * 
	 * @param diaDescuento           es un int que indica un dia de la semana
	 * @param porcentajeDescuentoDia es un double que contiene el porcentaje a
	 *                               descontar de la segunda unidad de los articulos
	 * @return Descuento aplicado a las segundas unidades
	 */
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuentoDia) {
		double descuento = 0;
		double precioArticulo = 0;
		int unidadesConDescuento = 0;

		if (diaDescuento == 1) {

			for (ItemCarrito iterador : lstItemCarrito) { // UNA ITERACIÓN POR CADA ITEM DEL CARRITO
				if (iterador.getCantidad() > 1) { // SI LA CANTIDAD DEL ARTICULO DEL ITEM CARRITO ES MÁS DE 1
					unidadesConDescuento = iterador.getCantidad() / 2; // LAS UNIDADES CON DESCUENTO SERÁN LA MITAD DE
					precioArticulo = iterador.getArticulo().getPrecio(); // OBTENGO EL PRECIO DEL ARTICULO
					descuento = descuento + unidadesConDescuento * precioArticulo * porcentajeDescuentoDia / 100;
					// CALCULO EL DESCUENTO DEL ARTICULO Y LOS SUMO AL ACUMULADOR
				}
			}
		}

		return descuento;
	}

	/**
	 * Este método calcula el descuento tras el pago en efectivo
	 * 
	 * @param porcentajeDescuentoEfectivo es un double que contiene el porcenteje a
	 *                                    descontar del carrito
	 * @return El descuento aplicado al total del carrito
	 */
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		descuento = calcularTotalCarrito() * porcentajeDescuentoEfectivo / 100; // EL DESCUENTO SERIA EL TOTAL POR EL
																				// PORCENTAJE A
		return descuento;
	}

	/**
	 * Este método compara los descuentos
	 * 
	 * @param diaDescuento                es un int que indica un dia de la semana
	 * @param porcentajeDescuentoDia      es un double que contiene el porcentaje a
	 *                                    descontar de la segunda unidad de los
	 *                                    articulos
	 * @param porcentajeDescuentoEfectivo es un double que contiene el porcenteje a
	 *                                    descontar del carrito
	 * @return El descuento más grande
	 */
	public double calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuentoDia,
			double porcentajeDescuentoEfectivo) {
		double resultado = 0;
		System.out.println("descuento dia " + calcularDescuentoDia(diaDescuento, porcentajeDescuentoDia));
		System.out.println("descuento efectivo " + calcularDescuentoEfectivo(porcentajeDescuentoEfectivo));
		if (entrega != null && entrega.isEfectivo()) {
			if (calcularDescuentoDia(diaDescuento,
					porcentajeDescuentoDia) >= calcularDescuentoEfectivo(porcentajeDescuentoEfectivo)) {
				resultado = calcularDescuentoDia(diaDescuento, porcentajeDescuentoDia);
			}

		} else {
			resultado = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		}
		return resultado;
	}

	/**
	 * Este método se encarga de calcular el total final del carrito con el
	 * descuento aplicado
	 * 
	 * @return El total menos el descuento del carrito
	 */

	public double totalAPagarCarrito() {
		double resultado;
		if (entrega instanceof Envio) {
			
			System.out.println("Costo envio: " + ((Envio) getEntrega()).getCosto());
			
			resultado = calcularTotalCarrito()
					- calcularDescuentoCarrito(LocalDate.now().getDayOfWeek().getValue(), 100L, 42L)
					+ ((Envio) getEntrega()).getCosto();
		} else {
			resultado = calcularTotalCarrito()
					- calcularDescuentoCarrito(LocalDate.now().getDayOfWeek().getValue(), 100L, 42L);
		}
		return resultado;
	}

}