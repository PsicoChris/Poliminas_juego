package poli.edu.co.modelos;

/**
 * La clase Casilla implementa la logica  
 * que sea necesaria para manipular todo lo correspondiente a 
 * las casillas del juego.
 * 
 * posFila: Posición de la fila de la casilla en el tablero.
 * posColumna: Posición de la columna de la casilla en el tablero.
 * mina: Booleano que indica si en la casilla hay una mina.
 * pista: Valor numerico que indica el numero de bombas alrededor.
 * 
 * @author Christian Lancheros Martínez, Mariana Piñeros Torres, Jorge Torres Candia Jhonatan David López Bermúdez, Daniel Felipe Herrera
 * 
 * @version 1.0
 */
public class Casilla {
	private int posFila;
	private int posColumna;
	private boolean mina;
	private int pista;
	
	
	/**
	 * Constructor para la clase
	 * @param posFila Posición de la Fila de la casilla
	 * @param posColumna Posición de la Columna de la casilla
	 */
	public Casilla(int posFila, int posColumna) {
		
		this.posFila = posFila;
		this.posColumna = posColumna;
		this.mina = false;
		this.pista = 0;
	}

	/**
	 * Metodo para traer el valor del atributo de la posición de la Fila 
	 * 
	 * @return posFila Posición de la Fila
	 */
	public int getPosFila() {
		return posFila;
	}
	
	/**
	 * Metodo para darle valor al atributo de la posición de la fila 
	 * 
	 * @param posFila Posición de la Fila
	 */
	public void setPosFila(int posFila) {
		this.posFila = posFila;
	}
	
	/**
	 * Metodo para traer el valor del atributo de la posición de la Columna 
	 * 
	 * @return posColumna Posición de la Columna
	 */
	public int getPosColumna() {
		return posColumna;
	}
	
	/**
	 * Metodo para darle valor al atributo de la posición de la Columna 
	 * 
	 * @param posColumna Posición de la Columna
	 */
	public void setPosColumna(int posColumna) {
		this.posColumna = posColumna;
	}
	
	/**
	 * Metodo para traer el valor del atributo mina 
	 * 
	 * @return mina booleano que indica si es mina o no
	 */
	public boolean isMina() {
		return mina;
	}
	
	/**
	 * Metodo para darle valor al atributo si es o no una mina 
	 * 
	 * @param mina Valor verdadero o falso que determina si es o no una mina
	 */
	public void setMina(boolean mina) {
		this.mina = mina;
	}

	/**
	 * Metodo para traer el valor del atributo de la pista
	 * 
	 * @return pista valor numerico de la cantidad de minas cercanas
	 */
	public int getPista() {
		return pista;
	}

	/**
	 * Metodo para darle valor al atributo pista 
	 * 
	 * @param mina numero de minas alrededor
	 */
	public void setPista(int pista) {
		this.pista = pista;
	}
	
	/**
	 * Metodo para aumentar el numero de minas alrededor de una casilla 
	 * 
	 */
	public void incrementarPista() {
		this.pista++;
	}
	

}
