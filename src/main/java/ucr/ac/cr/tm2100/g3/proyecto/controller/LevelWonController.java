/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level1Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level2Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.LevelWonFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class LevelWonController implements ActionListener {

   LevelWonFrame levelWonFrame;
    MenuFrame menuFrame;
    Level1Frame level1Frame;
    Level2Frame level2Frame;
     Level3Controller level3Controller;
    Level2Controller level2Controller;
    
    private int currentLevel; // Nivel actual que acaba de completarse

    public LevelWonController(MenuFrame menuFrameParam, int currentLevelParam) {
        
        
        levelWonFrame= new LevelWonFrame();
        levelWonFrame.setVisible(true);
       levelWonFrame.listen(this);
        menuFrame = menuFrameParam;
         this.currentLevel = currentLevelParam;
    }

    public void setVisible() {
        levelWonFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                levelWonFrame.setVisible(false);
                menuFrame.setVisible(true);
                break;   
            case "SIGUIENTE NIVEL":
               handleNextLevel();
            break;
    }
        
   
    }
     private void handleNextLevel() {
        // Ocultar la ventana actual y cargar el siguiente nivel
        levelWonFrame.setVisible(false);

        switch (currentLevel) {
            case 1:
                new Level2Controller(menuFrame); // Carga el nivel 2
                break;
            case 2:
                new Level3Controller(menuFrame); // Carga el nivel 3
                break;
            case 3:
                System.out.println("¡Felicidades! Has completado el juego.");
                menuFrame.setVisible(true);
                break;
        }
     }
}
