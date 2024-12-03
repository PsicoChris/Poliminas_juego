package juego;

public class Casilla {

    private int posFila;
    private int posColumna;
    private boolean mina;
    private int minasAlrededor;  // Nombre corregido a "minasAlrededor"
    
    // Constructor
    public Casilla(int posFila, int posColumna) {
        this.posFila = posFila;
        this.posColumna = posColumna;
        this.mina = false;  // Asegurarse de que mina por defecto es false
        this.minasAlrededor = 0;  // Inicializamos minasAlrededor en 0
    }

    // Métodos de acceso (getters y setters)
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

    public int getMinasAlrededor() {
        return minasAlrededor;
    }

    public void setMinasAlrededor(int minasAlrededor) {
        this.minasAlrededor = minasAlrededor;
    }

    // Método para incrementar el número de minas alrededor de la casilla
    public void incrementarNumeroMinasAlrededor() {
        this.minasAlrededor++;  // Incrementar la variable correcta (minasAlrededor)
    }
}
