package poli.edu.co.modelos;

public class Casilla {
	
	private int posFila;
	private int posColumna;
	private boolean mina;
	private int pista;
	
	
	
	public Casilla(int posFila, int posColumna) {
		this.posFila = posFila;
		this.posColumna = posColumna;
		this.mina = false;
		this.pista = 0;
	}


	public int getPosFila() {
		return posFila;
	}
	
	
	public void setPosFila(int posFila) {
		this.posFila = posFila;
	}
	
	
	public int getPosColumna() {
		return posColumna;
	}
	
	
	public void setPosColumna(int posColumna) {
		this.posColumna = posColumna;
	}
	
	
	public boolean isMina() {
		return mina;
	}
	
	
	public void setMina(boolean mina) {
		this.mina = mina;
	}


	public int getPista() {
		return pista;
	}


	public void setPista(int pista) {
		this.pista = pista;
	}
	
	public void incrementarPista() {
		this.pista++;
	}
	

}
