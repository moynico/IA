package ejemplojuego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Escenario extends JComponent implements Constantes{
    
    public Celda[][] c;
    public Jugador jugador;
    BufferedImage vacio;
    
    public Escenario() throws IOException{
        c = new Celda[CANTIDAD_FILAS_ESCENARIO][CANTIDAD_COLUMNAS_ESCENARIO];
        for(int i = 0; i < CANTIDAD_FILAS_ESCENARIO; i++){
            for(int j = 0; j < CANTIDAD_COLUMNAS_ESCENARIO; j++){
                c[i][j] = new Celda(j * TAMANO_CELDA, i * TAMANO_CELDA);
            }
        }
        this.jugador = new Jugador(this);
        c[0][0].cambiarTipo(TIPO_JUGADOR);
        c[5][5].cambiarTipo(TIPO_ENEMIGO);
        try{
            vacio = ImageIO.read(new File("src/fondo_azul.jpg"));
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(vacio,0,0,this);
        for(int i = 0; i < CANTIDAD_FILAS_ESCENARIO; i++){
            for(int j = 0; j < CANTIDAD_COLUMNAS_ESCENARIO; j++){
                c[i][j].paintComponent(g);
            }
        }
    }
    
    public void moverJugador(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT: jugador.moverJugadorDerecha(); break;
            case KeyEvent.VK_LEFT: jugador.moverJugadorIzquierda(); break;
            case KeyEvent.VK_UP: jugador.moverJugadorArriba(); break;
            case KeyEvent.VK_DOWN: jugador.moverJugadorAbajo(); break;
            
        }
        
    }
    
    
    
    
}
