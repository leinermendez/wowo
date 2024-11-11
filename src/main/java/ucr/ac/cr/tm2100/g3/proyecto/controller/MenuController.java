/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.LevelFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class MenuController implements ActionListener {

    private MenuFrame menuFrame;
    private HistoryController historyController;
    private InstructionsController instructionsController;
    private LevelController levelController;

    public MenuController() {
        menuFrame = new MenuFrame();
        menuFrame.setVisible(true);
        menuFrame.listen(this);

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "HISTORIA":
                menuFrame.setVisible(false);
                if (historyController == null) {
                    historyController = new HistoryController(menuFrame);
                }else{
                historyController.setVisible();
                }
                 
                break;
            case "INSTRUCCIONES":
                
                    menuFrame.setVisible(false);
                if (instructionsController == null) {
                   instructionsController= new InstructionsController(menuFrame);
                }else{
                instructionsController.setVisible();
                }

                break;

            case "JUGAR":
                menuFrame.setVisible(false);
                if (levelController == null) {
                   levelController= new LevelController(menuFrame);
                }else{
               levelController.setVisible();
                }

                break;

            case "SALIR":
                System.exit(0);

                break;
        }
    }

}
