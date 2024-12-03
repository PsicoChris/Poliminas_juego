package juego;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FrmJuego extends Application {

    private static final int NUM_FILAS = 5;
    private static final int NUM_COLUMNAS = 5;
    private static final int NUM_MINAS = 5;

    private Tablero tablero;
    private Button[][] botones;  // Matriz de botones que representarán el tablero

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Inicialización del tablero
        tablero = new Tablero(NUM_FILAS, NUM_COLUMNAS, NUM_MINAS);
        botones = new Button[NUM_FILAS][NUM_COLUMNAS];  // Crear una matriz de botones

        // Crear un GridPane para colocar los botones en una cuadrícula
        GridPane grid = new GridPane();
        grid.setVgap(5);  // Espacio vertical entre los botones
        grid.setHgap(5);  // Espacio horizontal entre los botones
        grid.setAlignment(Pos.CENTER);  // Centrar los botones en la ventana

        // Crear botones y agregar acción al hacer clic
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                Button btn = new Button();
                btn.setFont(new Font("Arial", 20));  // Fuente para los botones
                btn.setPrefSize(50, 50);  // Tamaño de los botones
                btn.setStyle("-fx-base: lightgray;");  // Estilo inicial de los botones

                final int fila = i;
                final int columna = j;

                // Evento de clic
                btn.setOnAction(e -> manejarClic(fila, columna));

                botones[i][j] = btn;  // Guardar el botón en la matriz
                grid.add(btn, j, i);  // Agregar el botón al GridPane en la posición (columna, fila)
            }
        }

        // Crear la escena y la ventana
        Scene scene = new Scene(grid, 600, 600);  // Crear la escena con el tamaño de la ventana
        primaryStage.setTitle("Juego de Minas");  // Título de la ventana
        primaryStage.setScene(scene);  // Asignar la escena al Stage
        primaryStage.show();  // Mostrar la ventana
    }

    // Método para manejar el clic en una casilla
    private void manejarClic(int fila, int columna) {
        Casilla casilla = tablero.casillas[fila][columna];

        if (casilla.isMina()) {
            botones[fila][columna].setText("*");  // Mostrar * si es mina
            botones[fila][columna].setStyle("-fx-base: red;");  // Cambiar color si hay mina
            mostrarAlerta("¡BOOM! Has perdido.", AlertType.ERROR);  // Mostrar alerta de pérdida
            reiniciarJuego();  // Reiniciar el juego después de perder
        } else {
            int minasAlrededor = casilla.getMinasAlrededor();
            botones[fila][columna].setText(minasAlrededor == 0 ? "" : String.valueOf(minasAlrededor));  // Mostrar número de minas cercanas
            botones[fila][columna].setStyle("-fx-base: lightblue;");  // Cambiar color al hacer clic
            botones[fila][columna].setDisable(true);  // Deshabilitar el botón después de hacer clic
        }
    }

    // Mostrar una alerta
    private void mostrarAlerta(String mensaje, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle("Fin del juego");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();  // Mostrar la alerta
    }

    // Método para reiniciar el juego
    private void reiniciarJuego() {
        // Mostrar una alerta para reiniciar el juego
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("¿Reiniciar?");
        alerta.setHeaderText("¿Quieres jugar de nuevo?");
        alerta.setContentText("Haz clic en 'OK' para reiniciar o 'Cancelar' para salir.");

        alerta.showAndWait().ifPresent(response -> {
            if (response.getButtonData().isCancelButton()) {
                System.exit(0);  // Salir si el jugador cancela
            } else {
                // Reiniciar juego
                tablero = new Tablero(NUM_FILAS, NUM_COLUMNAS, NUM_MINAS);  // Recrear el tablero
                botones = new Button[NUM_FILAS][NUM_COLUMNAS];  // Reiniciar la matriz de botones
                start(new Stage());  // Reiniciar la ventana
            }
        });
    }
}
