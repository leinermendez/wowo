/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz1;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level1Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.PanelNivel1;

/**
 *
 * @author RYZEN
 */
public class Level1Controller implements KeyListener {

    Level1Frame level1Frame;
      PanelNivel1 nivel1;
      Matriz1 matriz;
    MenuFrame menuFrame;
    private  int laberinto[][];

    public Level1Controller(MenuFrame menuFrameParam) {
        
       
        matriz =  new Matriz1();
        laberinto= matriz.obtenerLaberinto();
        nivel1 = new PanelNivel1(597, 16);
         level1Frame = new Level1Frame(nivel1);
      level1Frame.addKeyListener(this);
      level1Frame.setFocusable(true);
      level1Frame.requestFocusInWindow();
        level1Frame.setVisible(true);
        menuFrame = menuFrameParam;
        
        
    }

    public void setVisible() {
        level1Frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:  // ARRIBA
               
                break;
            case KeyEvent.VK_S:  // ABAJO
               
                break;
            case KeyEvent.VK_A:  // IZQUIERDA
             
                break;
            case KeyEvent.VK_D:  // DERECHA
                
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
