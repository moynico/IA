package ejemplojuego;

import java.awt.Color;

public interface Constantes {
    public final String TITULO_APP = "Juego IA";
    
    public final int TAMANO_CELDA = 40;
    
    public final int CANTIDAD_FILAS_ESCENARIO = 10;
    public final int CANTIDAD_COLUMNAS_ESCENARIO = 15;
    
    public final int ANCHO_VENTANA  = (CANTIDAD_COLUMNAS_ESCENARIO * TAMANO_CELDA)+50;
    public final int ALTO_VENTANA = (CANTIDAD_FILAS_ESCENARIO * TAMANO_CELDA)+50;
    
    public final String TIPO_JUGADOR = "J";
    public final String TIPO_VACIO = "V";
    public final String TIPO_ENEMIGO = "E";
    
    public final Color COLOR_VACIO = Color.GREEN;
    public final Color COLOR_JUGADOR = Color.BLUE;
    public final Color COLOR_ENEMIGO = Color.RED;
}
