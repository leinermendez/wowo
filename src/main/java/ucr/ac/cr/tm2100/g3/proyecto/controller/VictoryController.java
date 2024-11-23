/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.VictoryFrame;

/**
 *
 * @author RYZEN
 */
public class VictoryController  implements ActionListener {

   VictoryFrame victoryFrame;
    MenuFrame menuFrame;

    public VictoryController(MenuFrame menuFrameParam) {
        victoryFrame= new VictoryFrame();
        victoryFrame.setVisible(true);
       victoryFrame.listen(this);
        menuFrame = menuFrameParam;
    }

    public void setVisible() {
        victoryFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                victoryFrame.setVisible(false);
                menuFrame.setVisible(true);
                break;   
            case "SALIR":
               System.exit(0);
                       
                break;
            
        }

    }
    
}
