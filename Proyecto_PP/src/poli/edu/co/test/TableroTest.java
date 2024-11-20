/**
 * La Clase TableroTest se encarga de manejar toda la parte de los 
 * test unitarios implementados para la clase Tablero {@link Tablero}.
 * 
 * @author Christian Lancheros Martínez, Mariana Piñeros Torres, Jorge Torres Candia
 */

package poli.edu.co.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import poli.edu.co.modelos.Casilla;
import poli.edu.co.modelos.Tablero;

public class TableroTest extends TestCase {
	
	public void testSeleccionarCasilla() {
		/**
		 * Test para probar el ciclo de juego
		 */
		Tablero tablero = new Tablero(1,1,1);
		assertEquals("la casilla es mina", true, tablero.seleccionarCasilla(0, 0, false));
	}
	
	public void testObtenerCasillasAlrededor() {
		/**
		 * Test para probar el funcionamiento de la funcion obtenerCasillas alrededor
		 * 
		 * @deprecated este test debe mejorar para matrices más grandes 
		 */
		Tablero tablero = new Tablero(1,1,1);
		List<Casilla> casillasAlrededor = new ArrayList();
		assertEquals("la casilla es mina", casillasAlrededor, tablero.obtenerCasillasAlrededor(0, 0));
	}

}
