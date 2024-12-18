/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz3;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;
import ucr.ac.cr.tm2100.g3.proyecto.view.AlertaFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level3Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.PanelNivel3;
import ucr.ac.cr.tm2100.g3.proyecto.view.TrapperWonFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.VictoryFrame;

/**
 *
 * @author RYZEN
 */
public class Level3Controller implements KeyListener {

    TrapperWonController trapperWonController;
    VictoryController victoryController;
    AlertaController alertaController;
    SinVidasController sinvidasController;
    Level3Frame level3Frame; // Ventana que contiene el nivel 1
    PanelNivel3 nivel3; // Panel que representa visualmente el nivel 1
    Matriz3 matriz; // Objeto que representa la matriz del laberinto
    MenuFrame menuFrame; // Ventana principal del menú del juego
    Personaje pj; // Objeto que representa al personaje controlado por el jugador
    AlertaFrame alertaFrame;

    int laberinto[][]; // Matriz que define la estructura del laberinto

    public Level3Controller(MenuFrame menuFrameParam) {

        matriz = new Matriz3(); // Inicializa la matriz del laberinto
        laberinto = matriz.obtenerLaberinto(); // Obtiene la matriz del laberinto
        nivel3 = new PanelNivel3(650, 15, matriz.obtenerLaberinto()); // Configura el panel visual del nivel
        pj = new Personaje(0, 2, 5); // Crea el personaje en una posición inicial (0,2)
        level3Frame = new Level3Frame(nivel3, pj); // Crea la ventana del nivel 1 y le pasa el panel y el personaje
        level3Frame.addKeyListener(this); // Agrega el controlador como escuchador de eventos de teclado
        level3Frame.setFocusable(true); // Hace que el frame pueda recibir eventos de teclado
        level3Frame.requestFocusInWindow(); // Solicita el foco en el frame para eventos de teclado
        level3Frame.setVisible(true); // Hace visible la ventana del nivel 1
        menuFrame = menuFrameParam; // Asigna el menú principal pasado como parámetro

    }

    // Método para establecer un nuevo panel para el nivel 
    public void setPanel(PanelNivel3 nivel3) {
        this.nivel3 = nivel3;
    }

// Método para hacer visible la ventana del nivel 
    public void setVisible() {
        level3Frame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

        //-------------------------------------------------------------------------------------------- CONDICIONALES DE MOVIMIENTO
//Verifica si el personaje  esta en el camino, si choca con una pared o llego a la meta
        if (matriz.esCeldaLibre(nuevoX, nuevoY) || matriz.esMeta(nuevoX, nuevoY) || matriz.esFake(nuevoX, nuevoY)
                || !matriz.esInvisible(nuevoX, nuevoY) || matriz.esPoisonTrap(nuevoX, nuevoY) || matriz.esTrampaEnemiga(nuevoX, nuevoY)) {

            if (matriz.esCeldaLibre(nuevoX, nuevoY) || matriz.esMeta(nuevoX, nuevoY) || matriz.esFake(nuevoX, nuevoY)) {
                pj.mover(dx, dy);// Actualiza la posición del personaje
                System.out.println("Nueva posición: (" + pj.getX() + ", " + pj.getY() + ")");
                // Actualiza la posición del personaje en el panel y repinta
                nivel3.actualizarPosicionPersonaje(pj.getX(), pj.getY());
            }

            if (matriz.esMeta(nuevoX, nuevoY)) {
                level3Frame.dispose();
                victoryController = new VictoryController(menuFrame);

            }

            //VERIFICA SI PISO AL ENEMIGO
            if (matriz.esTrampaEnemiga(nuevoX, nuevoY)) {
                pj.mover(dx, dy);
                nivel3.actualizarPosicionPersonaje(pj.getX(), pj.getY());
                nivel3.trapperAwake(pj.getX(), pj.getY(), pj);
                level3Frame.dispose();
                trapperWonController = new TrapperWonController(menuFrame);
            }

        }
        //VERIFICA SI PISO VENENO/ resta una vida
        if (matriz.esPoisonTrap(nuevoX, nuevoY)) {
            pj.mover(dx, dy);
            nivel3.restarVida(pj);
            
               alertaController= new AlertaController();

            //verifica que este vivo antes de poder seguir
            if (!nivel3.conVida(pj)) {
                menuFrame.setVisible(true);
                level3Frame.dispose();
                sinvidasController = new SinVidasController(menuFrame);
            }
        }

        //EL PERSONAJE SE MUEVE AL INICIO
// Verifica si la nueva posición es un hoyo y manda al personaje al inicio
        if (matriz.esHoyo(nuevoX, nuevoY)) {

            pj.mover(dx, dy);// Actualiza la posición del personaje
            // Actualiza la posición del personaje en el panel y repinta
            nivel3.moverPersonajeTP(pj);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
