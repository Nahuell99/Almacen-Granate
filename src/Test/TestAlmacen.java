package Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Carrito.Articulo;
import Carrito.Carrito;
import Carrito.Entrega;
import Carrito.ItemCarrito;
import Carrito.RetiroLocal;
import Comercio.Cliente;
import Comercio.Comercio;
import Comercio.DiaRetiro;

public class TestAlmacen {

	public static void main(String[] args) {
		
		int contadorID = 1;
		Cliente cliente1 = new Cliente(1, "cliente1@gmail.com", "1165971568", 40L, 50L, "Nigro", "Emanuel", 30659878);
		Cliente cliente2 = new Cliente(2, "cliente2@gmail.com", "1198765432", 90L, 30L, "Ponce", "Gaston", 42231767);
		Cliente cliente3 = new Cliente(3, "cliente3@gmail.com", "1127916548", 10L, 70L, "Mauricio", "Rossi", 63987541);
		Cliente cliente4 = new Cliente(4, "cliente4@gmail.com", "1168712536", 80L, 30L, "Federic", "Procs", 35426987);
		
		Comercio comercio = new Comercio(1,"Comercio@AlmacenGranate.com", "1123456879", 20L, 30L,"Almacen Granate", 30610252334L, 100, 40, 3,
				20, 30);
		
		comercio.agregarDiaRetiro(new DiaRetiro(1, 1, LocalTime.of(5, 30), LocalTime.of(18, 30), 1));
		
		comercio.agregarLstArticulo(new Articulo(1, "jabón","4268897902756",30));
		comercio.agregarLstArticulo(new Articulo(2, "sal","6382730434472",20));
		comercio.agregarLstArticulo(new Articulo(3, "arroz","9659376765217",60));
		comercio.agregarLstArticulo(new Articulo(4, "harina","4950671922141",30));
		comercio.agregarLstArticulo(new Articulo(5, "lavandina","7388386942848",30));
		comercio.agregarLstArticulo(new Articulo(6, "leche","5752907913932",30));
		comercio.agregarLstArticulo(new Articulo(7, "aceite","6046202617461",30));
		comercio.agregarLstArticulo(new Articulo(8, "huevos","5701050395624",30));
		comercio.agregarLstArticulo(new Articulo(9, "levadura","7615596342360",30));
		comercio.agregarLstArticulo(new Articulo(10, "levadura","5575951290141",30));
		
		comercio.agregarLstCarrito(new Carrito(1, LocalDate.of(2020, 03, 01), LocalTime.of(5, 30), false, 0, cliente1, comercio.traerArticuloCod("7388386942848"), 1,
				new RetiroLocal(1, LocalDate.of(2020, 10, 25), true, LocalTime.of(18, 30))   ));
		LocalDate a = LocalDate.of(2020, 12, 12);
		
		System.out.println(a.getDayOfWeek());
		
		if(a.getDayOfWeek().getValue() == 5)
		{
			System.out.println("M");
		}
		
	}

}
