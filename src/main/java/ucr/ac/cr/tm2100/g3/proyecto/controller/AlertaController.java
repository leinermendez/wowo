/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.AlertaFrame;

/**
 *
 * @author RYZEN
 */
public class AlertaController implements ActionListener {

  AlertaFrame alertaFrame;
    

    public AlertaController() {
        alertaFrame = new AlertaFrame();
        alertaFrame.setVisible(true);
       alertaFrame.listen(this);
    }

    public void setVisible() {
        alertaFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "VIDA MENOS":
                alertaFrame.setVisible(false);
                break;
        }

    }
}

