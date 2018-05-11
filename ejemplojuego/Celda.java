package ejemplojuego;

import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Celda extends JComponent implements Constantes{
    public int x=0, y=0;
    public String tipo  = "V";
    BufferedImage jugador, enemigo, vacio;
    
    public Celda(int x, int y) throws IOException{
        this.x = x;
        this.y = y;
        try{
            jugador = ImageIO.read(new File("src/Kirby.png"));
            enemigo = ImageIO.read(new File("src/metaKnight.png"));
            vacio = ImageIO.read(new File("src/fondo_azul.jpg"));
        }catch(IOException e){
            
        }
    }
    
    public void cambiarTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String obtenerTipo(){
        return this.tipo;
    }
    
//    @Override
//    public void update(Graphics g){
//        switch(this.tipo){
//            case TIPO_JUGADOR: g.drawImag(jugador,x,y,this); break;
//            case TIPO_ENEMIGO: g.drawImage(enemigo,x,y,this); break;
//            case TIPO_VACIO: g.setColor(COLOR_VACIO);
//        }
//        g.fillRect(this.x, this.y, TAMANO_CELDA, TAMANO_CELDA);
//    }
    
    @Override
    public void paintComponent(Graphics g){
        switch(this.tipo){
            case TIPO_JUGADOR: g.drawImage(jugador,x,y,this); break;
            case TIPO_ENEMIGO: g.drawImage(enemigo,x,y,this); break;
            //case TIPO_VACIO: g.setColor(COLOR_VACIO);
        }
        g.drawImage(vacio,this.x,this.y,this);
    }
}
