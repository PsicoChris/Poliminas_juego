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
