
package poli.edu.co.modelos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Tablero implementa la logica  
 * que sea necesaria para manipular todo lo correspondiente  
 * al tablero del juego.
 * 
 * casilla: Matriz que representa el tablero del juego.
 * numFilas: Numero de filas que tendra el tablero.
 * numColumnas: Numero de columnas que tendra el tablero.
 * numMinas: Numero de minas que tendra el tablero.
 * 
 * @author Christian Lancheros Martínez, Mariana Piñeros Torres, Jorge Torres Candia Jhonatan David López Bermúdez, Daniel Felipe Herrera 
 * 
 * @version 1.0
 */
public class Tablero {
	Casilla [][] casillas;
	int numFilas;
	int numColumnas;
	int numMinas;
	
	/**
	 * Constructor de la clase 
	 * @param numFilas numero de filas del tablero
	 * @param numColumnas número de columnas del tablero
	 * @param numMinas Número de minas en el tablero 
	 */
	public Tablero(int numFilas, int numColumnas, int numMinas) {
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
		this.numMinas = numMinas;
		inicializarCasillas();
		
	}
	
	/**
	 * Crea el tablero del juego, que es una matriz de objetos Casillas, 
	 * de tamaño numFilas por numColumnas
	 * 
	 */
	public void inicializarCasillas(){
		casillas = new Casilla[this.numFilas][this.numColumnas]; 
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j =0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(i, j); 
			}
		}
		
		generarMinas();
		 
	}
	
	/**
	 * Dada una posición de la matriz, devuelve una lista con las casillas 
	 * de alrededor.
	 * 
	 * @param posFila posición de la fila de la casilla
	 * @param posColumna posición de la columna de la casilla
	 * 
	 * @return listaCasillas Lista de las casillas alrededor
	 */
	public List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
		List<Casilla> listaCasillas = new LinkedList<>();
		for (int i =0; i<8; i++) {
			int tmpFila = posFila;
			int tmpColumna = posColumna;
			switch(i) {
			case 0: tmpFila--; break; // Arriba
			case 1: tmpFila--; tmpColumna++; break; // Arriba Derecha
			case 2: tmpColumna++; break; // Derecha
			case 3: tmpFila++; tmpColumna++;break; // Derecha Abajo
			case 4: tmpFila++; break; // Abajo
			case 5: tmpFila++; tmpColumna--; break; // Abajo Izquierda
			case 6: tmpColumna--; break; // Izquierda
			case 7: tmpFila--; tmpColumna--;break; // Izquierda Arriba
			}
			if (tmpFila >= 0 && tmpFila < casillas.length 
					&& tmpColumna >= 0 && tmpColumna < casillas[0].length) {
				listaCasillas.add(this.casillas[tmpFila][tmpColumna]);
			}
		}
		return listaCasillas;
	}
	
	/**
	 * Recorre el tablero actualizando el valor de numero de bombas 
	 * alredor de cada casilla, para generar en la matriz tambien las pistas 
	 * necesarias para solucionar el Pusle.  
	 * 
	 */
	private void actualizarPistas() {
		for (int i = 0; i<casillas.length; i++) {
			for (int j = 0; j<casillas[i].length; j++) {
				if (casillas[i][j].isMina()) {
					List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);
					casillasAlrededor.forEach((c)->c.incrementarPista());
				}
			}
		}
	}
	
	/**
	 * A partir del numero de minas empieza a generar posiciones aleatorias
	 * y a partir de esas posiciones donde marcara dicha casilla como una mina
	 * así hasta terminar de poner el numero de minas establecido en un 
	 * principio  
	 */
	private void generarMinas() {
		int minasGeneradas = 0;
		while (minasGeneradas != numMinas) {
			int posTmpFila = (int) (Math.random() * casillas.length);
			int posTmpColumna = (int) (Math.random() * casillas[0].length);
			if(!casillas[posTmpFila][posTmpColumna].isMina()) {
				casillas[posTmpFila][posTmpColumna].setMina(true);
				minasGeneradas++;
			}
		}
		actualizarPistas();
	}
	
	/**
	 * Funcion que dada una posición pregunta si esta es o no una mina, 
	 * en cuyo caso retornara un estado de falso que dara por finalizado 
	 * el juego. 
	 * 
	 * @param posFila posición de la fila de la casilla
	 * @param posColumna posición de la columna de la casilla
	 * @param estado Estado del juego
	 * 
	 * @return estado estado que determina si continua el juego o si termina 
	 * 
	 * @deprecated Se crea para una primera version sin interfaz grafica, se espera 
	 * que al migrar hacia la interfaz grafica, este funcionamiento cambie
	 */
	public boolean seleccionarCasilla(int posFila, int posColumna, boolean estado) {
		if (this.casillas[posFila][posColumna].isMina()) {
			System.out.print("\nBoom!!");
			estado = false;
		}
		return estado;
	}
	
	/**
	 * Funcion que se encarga de mantener el ciclo de juego
	 * 
	 * @deprecated Se crea para una primera version sin interfaz grafica, se espera 
	 * que al migrar hacia la interfaz grafica, este funcionamiento cambie
	 */
	public void cicloJuego() {
		Scanner sc = new Scanner(System.in);
		boolean estado = true;
		while(estado) {
			System.out.print("Ingrese fila: ");
			int pf = sc.nextInt();
			System.out.print("Ingrese Columna: ");
			int pc = sc.nextInt();
			estado = seleccionarCasilla(pf, pc, estado);
		}
		sc.close();
	}
	
	/**
	 * Funcion que imprime en consola de juego el tablero con las respectivas minas
	 * Solo se usa con funciones de ayuda visual y para hacer debug al funcionamiento del juego
	 * 
	 * @deprecated se espera 
	 * que al migrar hacia la interfaz grafica, este funcionamiento cambie o se retire.
	 */
	public void imprimirTablero () {
		for (int i = 0; i < casillas.length; i++) {
			for (int j =0; j < casillas[i].length; j++) {
				System.out.print(casillas[i][j].isMina()?"*":"0");
			}
			System.out.println("");
		}
		
	}
	
	/**
	 * Funcion que imprime en consola de juego el tablero con las respectivas pistas
	 * Solo se usa con funciones de ayuda visual y para hacer debug al funcionamiento del juego
	 * 
	 * @deprecated se espera 
	 * que al migrar hacia la interfaz grafica, este funcionamiento cambie o se retire.
	 */
	public void imprimirPistas() {
		for (int i = 0; i<casillas.length; i++) {
			for (int j = 0; j<casillas[i].length; j++) {
				System.out.print(casillas[i][j].getPista());
			}
			System.out.println("");
		}
	}
	

}
 