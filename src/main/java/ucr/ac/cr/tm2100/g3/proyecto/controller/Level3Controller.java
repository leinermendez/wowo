/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz3;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level3Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.PanelNivel3;

/**
 *
 * @author RYZEN
 */
public class Level3Controller implements KeyListener {

    Level3Frame level3Frame;
    PanelNivel3 nivel3;
    MenuFrame menuFrame;
    Matriz3 matriz; // Objeto que representa la matriz del laberinto
    Personaje pj; // Objeto que representa al personaje controlado por el jugador

    private int laberinto[][]; // Matriz que define la estructura del laberinto

    public Level3Controller(MenuFrame menuFrameParam) {

        menuFrame = menuFrameParam;

        matriz = new Matriz3(); // Inicializa la matriz del laberinto
        laberinto = matriz.obtenerLaberinto(); // Obtiene la matriz del laberinto

        nivel3 = new PanelNivel3(597, 16); // Configura el panel visual del nivel

        pj = new Personaje(0, 2); // Crea el personaje en una posición inicial (0,2)
        level3Frame = new Level3Frame(nivel3, pj);
        level3Frame.setVisible(true);
        level3Frame.addKeyListener(this); // Agrega el controlador como escuchador de eventos de teclado
        level3Frame.setFocusable(true); // Hace que el frame pueda recibir eventos de teclado
        level3Frame.requestFocusInWindow(); // Solicita el foco en el frame para eventos de teclado
        level3Frame.setVisible(true); // Hace visible la ventana del nivel 2
        menuFrame = menuFrameParam; // Asigna el menú principal pasado como parámetro

    }

    public void setVisible() {
        level3Frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
