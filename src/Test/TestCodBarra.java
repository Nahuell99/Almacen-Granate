package Test;

import Carrito.Articulo;
import Comercio.Comercio;
import Comercio.Contacto;
import Comercio.Ubicacion;

public class TestCodBarra {

	public static void main(String[] args) {
		Comercio comercio = new Comercio(1, new Contacto("almacengranate", "15151651", new Ubicacion(22L, 255L)),
				"Almacen Granate", 30610252334L, 100, 40, 3, 20, 30);
		
		
		try {
			comercio.agregarLstArticulo(new Articulo(1, "jabón", "1234567890416", 30));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
