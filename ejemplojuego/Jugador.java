package ejemplojuego;

import static ejemplojuego.Constantes.CANTIDAD_COLUMNAS_ESCENARIO;
import static ejemplojuego.Constantes.CANTIDAD_FILAS_ESCENARIO;
import static ejemplojuego.Constantes.TIPO_ENEMIGO;
import static ejemplojuego.Constantes.TIPO_JUGADOR;
import javax.swing.JOptionPane;


public class Jugador implements Constantes{
    public int filaJugador, columnaJugador;
    public Escenario escenario;
    
    public Jugador(Escenario escenario){
        this.filaJugador = 0;
        this.columnaJugador = 0;
        this.escenario = escenario;
    }

    
    public void moverJugadorDerecha(){
        if((columnaJugador+1)<CANTIDAD_COLUMNAS_ESCENARIO){
            String tipo = escenario.c[filaJugador][columnaJugador+1].obtenerTipo();
            if(tipo.equals(TIPO_ENEMIGO)){
                JOptionPane.showMessageDialog(null, "Chocaste con el enemigo!!");
            }else{
            escenario.c[filaJugador][columnaJugador].cambiarTipo(tipo);
            escenario.c[filaJugador][columnaJugador+1].cambiarTipo(TIPO_JUGADOR);
            columnaJugador++;  
        }
        }else{
             JOptionPane.showMessageDialog(null, "Chocaste con una pared!");

         }
    }
    public void moverJugadorIzquierda(){
        if((columnaJugador-1)>=0){
            String tipo = escenario.c[filaJugador][columnaJugador-1].obtenerTipo();
            if(tipo.equals(TIPO_ENEMIGO)){
                JOptionPane.showMessageDialog(null, "Chocaste con el enemigo!!");
            }else{
                escenario.c[filaJugador][columnaJugador].cambiarTipo(tipo);
                escenario.c[filaJugador][columnaJugador-1].cambiarTipo(TIPO_JUGADOR);
                columnaJugador--;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Chocaste con una pared!");
        }
        
        
    }
    public void moverJugadorArriba(){
        if((filaJugador-1)>=0){
           String tipo = escenario.c[filaJugador-1][columnaJugador].obtenerTipo(); 
            if(tipo.equals(TIPO_ENEMIGO)){
                JOptionPane.showMessageDialog(null, "Chocaste con el enemigo!!");
            }else{
                escenario.c[filaJugador][columnaJugador].cambiarTipo(tipo);
                escenario.c[filaJugador-1][columnaJugador].cambiarTipo(TIPO_JUGADOR);
                filaJugador--;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Chocaste con una pared!");
        }
        
        
    }
    public void moverJugadorAbajo(){
        if((filaJugador+1)<CANTIDAD_FILAS_ESCENARIO){
            String tipo = escenario.c[filaJugador+1][columnaJugador].obtenerTipo();
            if(tipo.equals(TIPO_ENEMIGO)){
                JOptionPane.showMessageDialog(null, "Chocaste con el enemigo!!");
            }else{
                escenario.c[filaJugador][columnaJugador].cambiarTipo(tipo);
                escenario.c[filaJugador+1][columnaJugador].cambiarTipo(TIPO_JUGADOR);
                filaJugador++;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Chocaste con una pared!");
        }
    }
}
