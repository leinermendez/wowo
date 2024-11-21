/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz2;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level2Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.PanelNivel2;

/**
 *
 * @author RYZEN
 */
public class Level2Controller implements KeyListener {

    Level2Frame level2Frame;
    PanelNivel2 nivel2;
    MenuFrame menuFrame;
    Matriz2 matriz; // Objeto que representa la matriz del laberinto
    Personaje pj; // Objeto que representa al personaje controlado por el jugador

    private int laberinto[][]; // Matriz que define la estructura del laberinto

    public Level2Controller(MenuFrame menuFrameParam) {

        matriz = new Matriz2(); // Inicializa la matriz del laberinto
        laberinto = matriz.obtenerLaberinto(); // Obtiene la matriz del laberinto
        nivel2 = new PanelNivel2(597, 16, matriz.obtenerLaberinto()); // Configura el panel visual del nivel

        pj = new Personaje(0, 2); // Crea el personaje en una posición inicial (0,2)
        level2Frame = new Level2Frame(nivel2, pj); // Crea la ventana del nivel 2 y le pasa el panel y el personaje

        level2Frame.addKeyListener(this); // Agrega el controlador como escuchador de eventos de teclado
        level2Frame.setFocusable(true); // Hace que el frame pueda recibir eventos de teclado
        level2Frame.requestFocusInWindow(); // Solicita el foco en el frame para eventos de teclado
        level2Frame.setVisible(true); // Hace visible la ventana del nivel 2
        menuFrame = menuFrameParam; // Asigna el menú principal pasado como parámetro
    }
    // Método para establecer un nuevo panel para el nivel 1

    public void setPanel(PanelNivel2 nivel2) {
        this.nivel2 = nivel2;
    }

    public void setVisible() {
        level2Frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

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

        }

        // Calcula la nueva posición del personaje
        int nuevoX = pj.getX() + dx;
        int nuevoY = pj.getY() + dy;

// Verifica si la nueva posición es válida y no es unpunto de teletransporte
        if (matriz.esCeldaLibre(nuevoX, nuevoY) || matriz.esLlave(nuevoX, nuevoY) || matriz.esCajon(nuevoX, nuevoY) || matriz.esMeta(nuevoX, nuevoY)) {

            pj.mover(dx, dy);// Actualiza la posición del personaje
            System.out.println("Nueva posición: (" + pj.getX() + ", " + pj.getY() + ")");

            // Actualiza la posición del personaje en el panel y repinta
            nivel2.actualizarPosicionPersonaje(pj.getX(), pj.getY());

            if (matriz.esMeta(nuevoX, nuevoY)) {
                 JOptionPane.showMessageDialog(null, "Nivel completado!");
                menuFrame.setVisible(true);
                level2Frame.dispose();
            }

        }

        
// Verifica si la nueva posición es un punto de teletransporte
        if (matriz.esNenufar1(nuevoX, nuevoY)) {
            
            pj.mover(dx, dy);// Actualiza la posición del personaje
            // Actualiza la posición del personaje en el panel y repinta
            nivel2.moverPersonaje(pj);  
        } 
        
        if (matriz.esNenufar2(nuevoX, nuevoY)) {
            
            pj.mover(dx, dy);// Actualiza la posición del personaje
            // Actualiza la posición del personaje en el panel y repinta
            nivel2.moverPersonaje(pj);  

        }

    }

@Override
public void keyReleased(KeyEvent e) {

    }
}
