package ejemplojuego;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lienzo extends Canvas implements KeyListener/*, Runnable*/{
    
    public Escenario escenario;
    public boolean corriendo;
    public Thread hilo;
    BufferedImage vacio;
    
    public Lienzo() throws IOException{
        this.setFocusable(true);
        escenario = new Escenario();
        this.setBackground(Color.ORANGE);
        this.addKeyListener(this);
        
        try{
            vacio = ImageIO.read(new File("src/fondo_azul.jpg"));
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void paint(Graphics g){
        escenario.paintComponent(g);
        //g.drawImage(vacio,0,0,this);
    }

    @Override
    public void update(Graphics g){
        escenario.paintComponent(g);
        //g.drawImage(vacio,0,0,this);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        escenario.moverJugador(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    private synchronized void start(){
        corriendo = true;
        hilo.start();
    }
    
    public synchronized void stop (){
        corriendo = false;
        try{
            hilo.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
