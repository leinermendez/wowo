 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz1;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level1Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.PanelNivel1;

/**
 *
 * @author RYZEN
 */
public class Level1Controller implements KeyListener {
LevelWonController levelWonController;
    Level1Frame level1Frame; // Ventana que contiene el nivel 1
    PanelNivel1 nivel1; // Panel que representa visualmente el nivel 1
    Matriz1 matriz; // Objeto que representa la matriz del laberinto
    MenuFrame menuFrame; // Ventana principal del menú del juego
    Personaje pj; // Objeto que representa al personaje controlado por el jugador
 
    
    private int laberinto[][]; // Matriz que define la estructura del laberinto

// Constructor de la clase controlador
    public Level1Controller(MenuFrame menuFrameParam) {

        matriz = new Matriz1(); // Inicializa la matriz del laberinto
        laberinto = matriz.obtenerLaberinto(); // Obtiene la matriz del laberinto
        nivel1 = new PanelNivel1(597, 16, matriz.obtenerLaberinto()); // Configura el panel visual del nivel

        pj = new Personaje(0, 2); // Crea el personaje en una posición inicial (0,2)
        level1Frame = new Level1Frame(nivel1, pj); // Crea la ventana del nivel 1 y le pasa el panel y el personaje

        level1Frame.addKeyListener(this); // Agrega el controlador como escuchador de eventos de teclado
        level1Frame.setFocusable(true); // Hace que el frame pueda recibir eventos de teclado
        level1Frame.requestFocusInWindow(); // Solicita el foco en el frame para eventos de teclado
        level1Frame.setVisible(true); // Hace visible la ventana del nivel 1
        menuFrame = menuFrameParam; // Asigna el menú principal pasado como parámetro

    }

    // Método para establecer un nuevo panel para el nivel 1
    public void setPanel(PanelNivel1 nivel1) {
        this.nivel1 = nivel1;
    }

// Método para hacer visible la ventana del nivel 1
    public void setVisible() {
        level1Frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int dx = 0; // Cambio en la posición horizontal
        int dy = 0; // Cambio en la posición vertical

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:  // ARRIBA
                System.out.println(e.getKeyChar());
                dy = -1;
                break;

            case KeyEvent.VK_S:  // ABAJO
                System.out.println(e.getKeyChar());
                dy = 1;
                break;

            case KeyEvent.VK_A:  // IZQUIERDA
                System.out.println(e.getKeyChar());
                dx = -1;
                break;

            case KeyEvent.VK_D:  // DERECHA
                System.out.println(e.getKeyChar());
                dx = 1;
                break;

            default:
                break;
        }

        // Calcula la nueva posición del personaje
        int nuevoX = pj.getX() + dx;
        int nuevoY = pj.getY() + dy;

// Verifica si la nueva posición es válida
        if (matriz.esCeldaLibre(nuevoX, nuevoY) || matriz.esLlave(nuevoX, nuevoY) || matriz.esCajon(nuevoX, nuevoY) || matriz.esMeta(nuevoX, nuevoY) ) {
            
             
            if ( matriz.esMeta(nuevoX, nuevoY)){
                level1Frame.dispose();
               levelWonController = new LevelWonController(menuFrame);
              
                  
            }
             
            pj.mover(dx, dy);// Actualiza la posición del personaje
            System.out.println("Nueva posición: (" + pj.getX() + ", " + pj.getY() + ")");

            // Actualiza la posición del personaje en el panel y repinta
            nivel1.actualizarPosicionPersonaje(pj.getX(), pj.getY());
            
        }
        
        

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
