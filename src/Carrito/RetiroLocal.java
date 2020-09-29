package Carrito;

import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega {
	private LocalTime horaEntrega;

	public LocalTime getHoraEntrega() {
		return horaEntrega;
	}
	
	public RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
		super(efectivo, id, fecha, efectivo);
		this.horaEntrega = horaEntrega;
	}

	public void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	
}
