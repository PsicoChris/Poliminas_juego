package poli.edu.co.modelos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tablero {
	Casilla [][] casillas;
	
	int numFilas;
	int numColumnas;
	int numMinas;
	
	
	public Tablero(int numFilas, int numColumnas, int numMinas) {
		
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
		this.numMinas = numMinas;
		inicializarCasillas();
		
	}
	
	
	public void inicializarCasillas(){
		casillas = new Casilla[this.numFilas][this.numColumnas]; 
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j =0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(i, j); 
			}
		}
		
		generarMinas();
		 
	}
	
	private List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
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
	
	
	private boolean seleccionarCasilla(int posFila, int posColumna, boolean estado) {
		if (this.casillas[posFila][posColumna].isMina()) {
			System.out.print("\nBoom!!");
			estado = false;
		}
		return estado;
	}
	
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
	
	
	public void imprimirTablero () {
		for (int i = 0; i < casillas.length; i++) {
			for (int j =0; j < casillas[i].length; j++) {
				System.out.print(casillas[i][j].isMina()?"*":"0");
			}
			System.out.println("");
		}
		
	}
	
	public void imprimirPistas() {
		for (int i = 0; i<casillas.length; i++) {
			for (int j = 0; j<casillas[i].length; j++) {
				System.out.print(casillas[i][j].getPista());
			}
			System.out.println("");
		}
	}
	

}
 