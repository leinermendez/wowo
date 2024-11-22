/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.TrapperWonFrame;

/**
 *
 * @author RYZEN
 */
public class TrapperWonController implements ActionListener {

   TrapperWonFrame trapperWonFrame;
    MenuFrame menuFrame;

    public TrapperWonController(MenuFrame menuFrameParam) {
        trapperWonFrame = new TrapperWonFrame();
        trapperWonFrame.setVisible(true);
       trapperWonFrame.listen(this);
        menuFrame = menuFrameParam;
    }

    public void setVisible() {
        trapperWonFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                trapperWonFrame.setVisible(false);
                menuFrame.setVisible(true);
                break;
        }

    }
}
