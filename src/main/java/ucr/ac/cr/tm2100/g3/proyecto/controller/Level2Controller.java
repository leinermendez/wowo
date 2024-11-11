/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level2Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class Level2Controller implements ActionListener{
    
   
    
    Level2Frame level2Frame;
    MenuFrame menuFrame;

    public Level2Controller(MenuFrame menuFrameParam) {
         level2Frame = new Level2Frame();
        level2Frame.setVisible(true);
        level2Frame.listen(this);
         menuFrame = menuFrameParam;
    }
    
       public void setVisible() {
        level2Frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     switch (e.getActionCommand()) {
            case "REGRESAR":
                level2Frame.setVisible(false);
                menuFrame.setVisible(true);
                break;
     }
    
}
}
