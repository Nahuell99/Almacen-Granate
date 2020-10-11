package Comercio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Carrito.Articulo;
import Carrito.Carrito;
import Carrito.Entrega;
import Carrito.Envio;
import Carrito.RetiroLocal;
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

	public Comercio(Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		super(contacto);
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

	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit + ", costoFijo=" + costoFijo
				+ ", costoPorKm=" + costoPorKm + ", diaDescuento=" + diaDescuento + ", porcentajeDescuentoDia="
				+ porcentajeDescuentoDia + ", porcentajeDescuentoEfectivo=" + porcentajeDescuentoEfectivo
				+ ", lstDiaRetiro=" + lstDiaRetiro + ", lstCarrito=" + lstCarrito + ", lstArticulo=" + lstArticulo
				+ ", Contacto=" + super.toString() + "]";
	}

	public ArrayList<Articulo> getLstArticulo() {
		return lstArticulo;
	}

	public void setLstArticulo(ArrayList<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}

	public ArrayList<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(ArrayList<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	public void agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {

		lstDiaRetiro.add(new DiaRetiro(idNuevo("diaRetiros"), diaSemana, horaDesde, horaHasta, intervalo));
	}

	public void agregarLstArticulo(String nombre, String codBarra, double precio) throws Exception {
		lstArticulo.add(new Articulo(idNuevo("articulos"), nombre, codBarra, precio));
	}

	public boolean eliminarArticuloComercio(String codBarra) {
		int i = 0;
		boolean encontrado = false;

		while (i < lstArticulo.size() && encontrado == false) {
			if (lstArticulo.get(i).equals(codBarra)) {
				lstArticulo.remove(i);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	public Articulo traerArticuloCod(String codBarra) {
		Articulo traerArt = null;
		int i = 0;

		while (i < lstArticulo.size() && traerArt == null) {

			if (lstArticulo.get(i).getCodBarra().equals(codBarra)) {
				traerArt = lstArticulo.get(i);
			}
			i++;
		}
		return traerArt;
	}

	public void agregarLstCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		lstCarrito.add(new Carrito(idNuevo("carritos"), fecha, hora, cliente));
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

	// Metodos para instanciar todas la clase relacionadas

	public Cliente nuevoCliente(String email, String celular, double latitud, double longitud, String apellido,
			String nombre, long dni, char genero) throws Exception {

		return new Cliente(new Contacto(email, celular, new Ubicacion(latitud, longitud)), apellido, nombre, dni,
				genero);

	}

	public Contacto nuevoContacto(String email, String celular, Ubicacion ubicacion) {
		return new Contacto(email, celular, ubicacion);
	}

	// METODO PARA CALCULAR ID A ARTICULOS, DIA DE RETIROS Y CARRITOS
	public int idNuevo(String lista) {
		int idNuevo = 1;
		int i = 0;

		if (lista.equalsIgnoreCase("articulos")) {
			while (i < lstArticulo.size()) {

				if (lstArticulo.get(i).getId() == idNuevo) {
					idNuevo++;
					i = -1;
				}
				i++;

			}
		}
		if (lista.equalsIgnoreCase("carritos")) {
			while (i < lstCarrito.size()) {

				if (lstCarrito.get(i).getId() == idNuevo) {
					idNuevo++;
					i = -1;
				}
				i++;

			}
		}
		if (lista.equalsIgnoreCase("diaRetiros")) {
			while (i < lstDiaRetiro.size()) {

				if (lstDiaRetiro.get(i).getId() == idNuevo) {
					idNuevo++;
					i = -1;
				}
				i++;

			}
		}

		return idNuevo;
	}

	public ArrayList<Turno> generarTurnosLibres(LocalDate fecha) throws Exception {
		ArrayList<Turno> lstTurnosLibres = new ArrayList<Turno>();
		DiaRetiro dia = traerDiaRetiroPorDiaSemana(fecha);

		if (dia == null) {
			throw new Exception("no hay dia de retiro");
		}

		LocalTime horaInicio = dia.getHoraDesde();

		while (horaInicio.isBefore(dia.getHoraHasta())) { // COMPRUEBA SI LA HORA DE INICIO ES SUPERIO A LA HORA MAXIMA
															// HASTA CUANDO SE ERMITE ENTREGAR TURNOS LIBRES
			lstTurnosLibres.add(new Turno(fecha, horaInicio, false)); // Agrego un turno libre con la fecha mandada por
																		// parametro y la hora praviamente comprobada
																		// que no supera la hora maxima
			horaInicio = horaInicio.plusHours(dia.getIntervalo()); // LE SUMO EL INTERVALO DE HORAS PARA CADA TURNO
		}

		ArrayList<Turno> turnosLibres = new ArrayList<Turno>();

		for (Turno turnoOcupado : traerTurnosOcupados(fecha)) {
			for (Turno turnoLibre : lstTurnosLibres) {
				if (turnoOcupado.getHora().equals(turnoLibre.getHora())) {
					lstTurnosLibres.remove(new Turno(fecha, turnoLibre.getHora(), false));
				}
			}
		}
		return turnosLibres;
	}

	public DiaRetiro traerDiaRetiroPorDiaSemana(LocalDate diaSemana) {
		int diaSemanaNum = diaSemana.getDayOfWeek().getValue();
		DiaRetiro dia = null;
		for (DiaRetiro diaRetiro : lstDiaRetiro) {
			if (diaRetiro.getDiaSemana() == diaSemanaNum) {
				dia = diaRetiro;
			}
		}
		return dia;

	}

	public ArrayList<Turno> traerTurnosOcupados(LocalDate fecha) {
		ArrayList<Turno> turnosOcupados = new ArrayList<Turno>();
		for (Carrito carrito : lstCarrito) {
			if(carrito.getEntrega()!=null) {				
			if (carrito.getEntrega().getFecha().equals(fecha) && carrito.getEntrega() instanceof RetiroLocal) {
				turnosOcupados.add(new Turno(fecha, ((RetiroLocal) carrito.getEntrega()).getHoraEntrega(), true));
			}
		}}
		return turnosOcupados;
	}

	public ArrayList<Turno> traerTurnosLibres(LocalDate fecha) {
		ArrayList<Turno> turnosLibres = new ArrayList<Turno>();
		boolean cargado = false;
		boolean agregado = false;
		List<Turno> turnosOcupados = traerTurnosOcupados(fecha);
		DiaRetiro dia = traerDiaRetiroPorDiaSemana(fecha);
		LocalTime horaCondicion = dia.getHoraDesde();
		long hora = (long) dia.getIntervalo();

		while (cargado == false) {
			for (Turno t : turnosOcupados) {
				if (t.getHora().equals(horaCondicion)) {
					agregado = true;
				}
			}
			if (!agregado) {
				turnosLibres.add(new Turno(fecha, horaCondicion, false));
			}

		}
		return turnosLibres;
	}

	public ArrayList<Turno> generarAgenda(LocalDate fecha) throws Exception {
		ArrayList<Turno> agenda = new ArrayList<Turno>();
		agenda.addAll(generarTurnosLibres(fecha));
		agenda.addAll(traerTurnosOcupados(fecha));
		boolean comprobar = true;
		Turno traspaso;

		while (comprobar) {
			comprobar = false;
			for (int i = 0; i < agenda.size() - 1; i++) {
				if (agenda.get(i).getHora().isAfter(agenda.get(i + 1).getHora())) {
					comprobar = true;
					traspaso = agenda.get(i);
					agenda.add(i, agenda.get(i + 1));
					agenda.add(i + 1, traspaso);
				}
			}
		}
		return agenda;
	}

	public ArrayList<Turno> traerTurnosLibres2(LocalDate fecha) {

		ArrayList<Turno> turnosLibres = new ArrayList<Turno>();
		ArrayList<Turno> turnosOcupados = traerTurnosOcupados(fecha);

		DiaRetiro diaRetiro = traerDiaRetiroPorDiaSemana(fecha);
		LocalTime horaInicio = diaRetiro.getHoraDesde();

		boolean encontrado = false;

		while (horaInicio.isBefore(diaRetiro.getHoraHasta())) { // COMPRUEBA SI LA HORA DE INICIO ES SUPERIO A LA HORA
																// MAXIMA HASTA CUANDO SE ERMITE ENTREGAR TURNOS LIBRES
			for (Turno turnoOcupado : turnosOcupados) {
				if (turnoOcupado.getHora() == horaInicio) {
					encontrado = true;
				}
			}
			if (!encontrado) {
				turnosLibres.add(new Turno(fecha, horaInicio, false)); // Agrego un turno libre con la fecha mandada por
																		// parametro y la hora praviamente comprobada
																		// que no supera la hora maxima
			}
			horaInicio = horaInicio.plusHours(diaRetiro.getIntervalo()); // LE SUMO EL INTERVALO DE HORAS PARA CADA //
																			// TURNO
		}
		return turnosLibres;
	}

	public ArrayList<Turno> generarAgenda2(LocalDate fecha) {
		ArrayList<Turno> agendaCompleta = new ArrayList<Turno>();
		ArrayList<Turno> turnosLibres = traerTurnosLibres2(fecha);
		ArrayList<Turno> TurnosOcupados = traerTurnosOcupados(fecha);
		agendaCompleta.addAll(turnosLibres);
		agendaCompleta.addAll(TurnosOcupados);

		return agendaCompleta;
	}

	public void nuevoRetiroLocal(int idCarrito, boolean efectivo, LocalTime horaEntrega) throws Exception {

		if (this.lstCarrito.get(idCarrito).getEntrega() != null) {
			throw new Exception("Ya existe una entrega con envio");
		}
		if (horaEntrega.isAfter(traerDiaRetiroPorDiaSemana(this.lstCarrito.get(idCarrito).getFecha()).getHoraHasta())) {
			throw new Exception("No se permite entregas a esa hora");
		}
		if (horaEntrega
				.isBefore(traerDiaRetiroPorDiaSemana(this.lstCarrito.get(idCarrito).getFecha()).getHoraDesde())) {
			throw new Exception("No se permite entregas a esa hora");
		}

		for (Carrito carrito : lstCarrito) {
			
			if (((RetiroLocal) carrito.getEntrega()) != null) {
				
				if (((RetiroLocal) carrito.getEntrega()).getHoraEntrega().equals(horaEntrega)) {
					throw new Exception("el turno esta ocupado");
				}
			}
		}

		lstCarrito.get(idCarrito)
				.setEntrega(new RetiroLocal(lstCarrito.get(idCarrito).getFecha(), efectivo, horaEntrega));

	}

}
