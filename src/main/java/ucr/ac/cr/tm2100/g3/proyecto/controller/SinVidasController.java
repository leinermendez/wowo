/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.SinVidasFrame;

/**
 *
 * @author RYZEN
 */
public class SinVidasController implements ActionListener {

   SinVidasFrame sinVidasFrame;
    MenuFrame menuFrame;

    public SinVidasController(MenuFrame menuFrameParam) {
        sinVidasFrame = new SinVidasFrame();
         sinVidasFrame .setVisible(true);
        sinVidasFrame .listen(this);
        menuFrame = menuFrameParam;
    }

    public void setVisible() {
         sinVidasFrame .setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                 sinVidasFrame .setVisible(false);
                menuFrame.setVisible(true);
                break;
        }

    }
}
