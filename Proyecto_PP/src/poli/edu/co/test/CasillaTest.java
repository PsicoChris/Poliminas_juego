/**
 * La Clase CasillaTest se encarga de manejar toda la parte de los 
 * test unitarios implementados para la clase Casilla {@link Casilla}.
 * 
 * @author Christian Lancheros Martínez, Mariana Piñeros Torres, Jorge Torres Candia
 */

package poli.edu.co.test;

import junit.framework.TestCase;
import poli.edu.co.modelos.Casilla;

public class CasillaTest extends TestCase {
	
	public void testGetPosFila() {
		/**
		 * Prueba de la funcion getPosFila, que trae la posición de la fila de la casilla
		 */
		Casilla cas = new Casilla(1, 1);
		assertEquals("Posición de la fila erronea", 1, cas.getPosFila() );
	}
	
	public void testGetPosColumna() {
		/**
		 * Prueba de la funcion getPosFila, que trae la posición de la columna de la casilla
		 */
		Casilla cas = new Casilla(1, 1);
		assertEquals("Posición de la columna erronea", 1, cas.getPosColumna());
	}
	
	public void testIsMina() {
		/**
		 * Prueba de la funcion IsMina, que me dice si una casilla esta marcada como bomba
		 */
		Casilla cas = new Casilla(1, 1);
		cas.setMina(true);
		assertEquals("Verificación de la mina erronea", true, cas.isMina());
	}
	
	public void testGetPista() {
		/**
		 * Prueba de la funcion getPista, que me indica el numero de bombas alrededor de una
		 * casilla
		 */
		Casilla cas = new Casilla(1, 1);
		assertEquals("Pista erronea", 0, cas.getPista());
	}

}
