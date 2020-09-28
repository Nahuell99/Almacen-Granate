package Test;

import java.time.LocalDate;
import java.time.LocalTime;

import Carrito.Articulo;
import Carrito.Carrito;
import Carrito.ItemCarrito;
import Comercio.Cliente;
import Comercio.Comercio;
import Comercio.Contacto;
import Comercio.DiaRetiro;
import Comercio.Ubicacion;

public class AgregarQuitarCarrito {

	public static void main(String[] args) {
		
		
		try {
		Cliente cliente1 = new Cliente(2, new Contacto("emanigro@gmail.com", "53613131", new Ubicacion(515L, 154L)),
				"Nigro", "Emanuel", 30659878L, 'm');

		Comercio comercio = new Comercio(1, new Contacto("almacengranate", "15151651", new Ubicacion(22L, 255L)),
				"Almacen Granate", 30610252334L, 100, 40, 3, 20, 30);

		comercio.agregarLstArticulo(new Articulo(1, "jabón", "1234567890418", 30));
		comercio.agregarLstArticulo(new Articulo(2, "sal", "6382730434473", 30));
		comercio.agregarLstArticulo(new Articulo(3, "arroz", "9659376765214", 30));
		comercio.agregarLstArticulo(new Articulo(4, "harina", "4950671922148", 30));
		comercio.agregarLstArticulo(new Articulo(5, "lavandina", "7388386942842", 30));
		comercio.agregarLstArticulo(new Articulo(6, "leche", "5752907913932", 30));
		comercio.agregarLstArticulo(new Articulo(7, "aceite", "6046202617466", 30));
		comercio.agregarLstArticulo(new Articulo(8, "huevos", "5701050395621", 30));
		comercio.agregarLstArticulo(new Articulo(9, "levadura", "7615596342361", 30));
		comercio.agregarLstArticulo(new Articulo(10, "levadura", "5575951290145", 30));

		comercio.agregarLstCarrito(new Carrito(1, LocalDate.now(), LocalTime.now(), false, 0, cliente1,
				new ItemCarrito(comercio.traerArticuloCod("1234567890418"), 1)));

		comercio.traerCarritoId(1)
				.agregarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("7615596342361"), 2));
		comercio.traerCarritoId(1)
				.agregarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("6382730434473"), 2));
		
		comercio.traerCarritoId(1)
				.agregarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 2));
		comercio.traerCarritoId(1)
				.agregarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 2));
		
		
		comercio.traerCarritoId(1)
				.agregarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("4950671922148"), 2));

		comercio.traerCarritoId(1)
				.quitarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 1));
		comercio.traerCarritoId(1)
			.quitarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 1));
		comercio.traerCarritoId(1)
				.quitarlstItemCarritoA(new ItemCarrito(comercio.traerArticuloCod("9659376765214"), 3));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
