package Test;

import java.time.LocalDate;
import java.time.LocalTime;

import Carrito.Envio;

import Comercio.Cliente;
import Comercio.Comercio;
import Comercio.Contacto;

import Comercio.Ubicacion;

public class TestAlmacen {

	public static void main(String[] args) {

		try {
			Comercio comercio = new Comercio(1, new Contacto("almacengranate", "15151651", new Ubicacion(-38.5545, -58.7396)),
					"Almacen Granate", 30610252334L, 100, 5, 3, 20, 30);

			Cliente cliente1 = new Cliente(2, new Contacto("emanigro@gmail.com", "53613131", new Ubicacion(-38.0055, -57.5426)),
					"Nigro", "Emanuel", 30659878L, 'm');
			
			
			Cliente cliente2 = comercio.nuevoCliente(3,
					new Contacto("nahuelponce@gmail.com", "1564165156", new Ubicacion(2312L, 2312L)), "Ponce", "Gaston",
					42231767L, 'f');
			Cliente cliente3 = comercio.nuevoCliente(4,
					new Contacto("maurirossi@gmail.com", "1532326323", new Ubicacion(315L, 25L)), "Mauricio", "Rossi",
					63987541L, 'f');
			Cliente cliente4 = comercio.nuevoCliente(5,
					new Contacto("fedeprocs@gmail.com", "15151611", new Ubicacion(123L, 823L)), "Federic", "Procs",
					35426987L, 'm');

			
			comercio.agregarDiaRetiro(1, 1, LocalTime.of(5, 30), LocalTime.of(18, 30), 1);

			comercio.agregarLstArticulo(1, "jabón", "1234567890418", 30);
			comercio.agregarLstArticulo(2, "sal", "6382730434473", 30);
			comercio.agregarLstArticulo(3, "arroz", "9659376765214", 30);
			comercio.agregarLstArticulo(4, "harina", "4950671922148", 30);
			comercio.agregarLstArticulo(5, "lavandina", "7388386942842", 30);
			comercio.agregarLstArticulo(6, "leche", "5752907913932", 30);
			comercio.agregarLstArticulo(7, "aceite", "6046202617466", 30);
			comercio.agregarLstArticulo(8, "huevos", "5701050395621", 30);
			comercio.agregarLstArticulo(9, "levadura", "7615596342361", 30);
			comercio.agregarLstArticulo(10, "levadura", "5575951290145", 30);

			comercio.agregarLstCarrito(1, LocalDate.now(), LocalTime.now(), false, 0, cliente1);

			comercio.traerCarritoId(1).agregarlstItemCarritoA(comercio.traerArticuloCod("7615596342361"), 2);
			comercio.traerCarritoId(1).agregarlstItemCarritoA(comercio.traerArticuloCod("6382730434473"), 2);
			comercio.traerCarritoId(1).agregarlstItemCarritoA(comercio.traerArticuloCod("9659376765214"), 2);
			comercio.traerCarritoId(1).agregarlstItemCarritoA(comercio.traerArticuloCod("4950671922148"), 2);
			comercio.traerCarritoId(1).agregarlstItemCarritoA(comercio.traerArticuloCod("4950671922148"), 5);

//			comercio.traerCarritoId(1)
//					.quitarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 1));
//			comercio.traerCarritoId(1)
//					.quitarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 3));
//			comercio.traerCarritoId(1)
//					.quitarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 3));

			comercio.traerCarritoId(1)
					.setEntrega(new Envio(true, comercio.traerCarritoId(1).getId(), LocalDate.now(), true,
							LocalTime.now(), LocalTime.of(18, 30), cliente1.getContacto().getUbicacion(),
							comercio.getContacto().getUbicacion(), comercio.getCostoFijo(), comercio.getCostoPorKm()));


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}