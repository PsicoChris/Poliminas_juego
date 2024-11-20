/**
 * Clase principal del juego donde se encuentra
 * lo necesario para ejecutar el juego.
 * 
 * @author Christian Lancheros Martínez, Mariana Piñeros Torres, Jorge Torres Candia Jhonatan David López Bermúdez, Daniel Felipe Herrera
 * 
 * @version 1.0
 */
package poli.edu.co.coltrolador;

import poli.edu.co.modelos.Tablero;

public class Controlador {

	public static void main(String[] args) {
		Tablero tablero = new Tablero(5,5,1);
		tablero.imprimirTablero();
		System.out.println("========Pistas=========");
		tablero.imprimirPistas();
		tablero.cicloJuego();

	}

}
