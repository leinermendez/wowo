/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.InstructionsFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class InstructionsController implements ActionListener {

    InstructionsFrame instructionsFrame;
    MenuFrame menuFrame;

    public InstructionsController(MenuFrame menuFrameParam) {
        instructionsFrame = new InstructionsFrame();
        instructionsFrame.setVisible(true);
        instructionsFrame.listen(this);
        menuFrame = menuFrameParam;
    }

    public void setVisible() {
        instructionsFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                instructionsFrame.setVisible(false);
                menuFrame.setVisible(true);
                break;
        }

    }

}
