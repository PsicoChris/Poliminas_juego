package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmJuego {

    private static final int NUM_FILAS = 5;
    private static final int NUM_COLUMNAS = 5;
    private static final int NUM_MINAS = 5;

    private Tablero tablero;
    private JButton[][] botones;  // Matriz de botones que representarán el tablero

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmJuego().crearVentana());
    }

    public FrmJuego() {
        tablero = new Tablero(NUM_FILAS, NUM_COLUMNAS, NUM_MINAS);
        botones = new JButton[NUM_FILAS][NUM_COLUMNAS];
    }

    private void crearVentana() {
        JFrame frame = new JFrame("Juego de Minas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(NUM_FILAS, NUM_COLUMNAS, 5, 5)); // Configurar el layout en cuadrícula

        // Crear botones y agregar acción al hacer clic
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                JButton btn = new JButton();
                btn.setFont(new Font("Arial", Font.PLAIN, 20));
                btn.setPreferredSize(new Dimension(50, 50));

                final int fila = i;
                final int columna = j;

                // Evento de clic
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manejarClic(fila, columna);
                    }
                });

                botones[i][j] = btn;  // Guardar el botón en la matriz
                frame.add(btn);  // Agregar el botón al JFrame
            }
        }

        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }


    private void manejarClic(int fila, int columna) {
        Casilla casilla = tablero.casillas[fila][columna];

        if (casilla.isMina()) {
            botones[fila][columna].setText("*");
            botones[fila][columna].setBackground(Color.RED); 
            mostrarAlerta("¡PERDISTE!");
            reiniciarJuego();  
        } else {
            int minasAlrededor = casilla.getMinasAlrededor();
            botones[fila][columna].setText(minasAlrededor == 0 ? "" : String.valueOf(minasAlrededor));
            botones[fila][columna].setBackground(Color.LIGHT_GRAY);
            botones[fila][columna].setEnabled(false); 
        }
    }


    private void mostrarAlerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Fin del juego", JOptionPane.ERROR_MESSAGE);
    }


    private void reiniciarJuego() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "¿Reiniciar?", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            tablero = new Tablero(NUM_FILAS, NUM_COLUMNAS, NUM_MINAS);
            botones = new JButton[NUM_FILAS][NUM_COLUMNAS];
            crearVentana();
        } else {
            System.exit(0);
        }
    }
}
