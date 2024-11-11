/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.Level3Frame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class Level3Controller implements ActionListener{

    
    Level3Frame level3Frame;
    MenuFrame menuFrame;

    public Level3Controller(MenuFrame menuFrameParam) {
         level3Frame = new Level3Frame();
        level3Frame.setVisible(true);
        level3Frame.listen(this);
         menuFrame = menuFrameParam;
    }
    
       public void setVisible() {
        level3Frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
            case "REGRESAR":
                level3Frame.setVisible(false);
                menuFrame.setVisible(true);
                break;
      }
    
}
}
