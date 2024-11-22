/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.LevelWonFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class LevelWonController implements ActionListener {

   LevelWonFrame levelWonFrame;
    MenuFrame menuFrame;

    public LevelWonController(MenuFrame menuFrameParam) {
        levelWonFrame= new LevelWonFrame();
        levelWonFrame.setVisible(true);
       levelWonFrame.listen(this);
        menuFrame = menuFrameParam;
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
            case "SALIR":
               System.exit(0);
                       
                break;
        }

    }
}
