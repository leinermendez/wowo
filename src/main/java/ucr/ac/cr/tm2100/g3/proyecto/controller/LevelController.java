/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level1Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.LevelFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class LevelController implements ActionListener {

    LevelFrame levelFrame;
    Level1Controller level1Controller;
    Level2Controller level2Controller;
    Level3Controller level3Controller;
    MenuFrame menuFrame;

    public LevelController(MenuFrame menuFrameParam) {
        levelFrame = new LevelFrame();
        levelFrame.setVisible(true);
        levelFrame.listen(this);
         menuFrame = menuFrameParam;
    }
    
      public void setVisible() {
        levelFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                levelFrame.setVisible(false);
                menuFrame.setVisible(true);
                break;
                
                 case "LEVEL1":
                     
                levelFrame.setVisible(false);
                level1Controller = new Level1Controller(menuFrame);
               
         
                break; 
                 case "LEVEL2":
                levelFrame.setVisible(false);
                level2Controller = new Level2Controller(menuFrame);
                break;
                 case "LEVEL3":
                 levelFrame.setVisible(false);
                level3Controller = new Level3Controller(menuFrame);
                break;
                
                
        }
    }

}
