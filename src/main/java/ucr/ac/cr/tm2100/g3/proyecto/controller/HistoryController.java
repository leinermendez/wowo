/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.tm2100.g3.proyecto.view.HistoryFrame;
import ucr.ac.cr.tm2100.g3.proyecto.view.MenuFrame;

/**
 *
 * @author RYZEN
 */
public class HistoryController implements ActionListener{
HistoryFrame historyFrame;
 MenuFrame menuFrame;
 
    public HistoryController(MenuFrame menuFrameParam) {
            historyFrame = new HistoryFrame();
            historyFrame.setVisible(true);
            historyFrame.listen(this);
            menuFrame=menuFrameParam;
    }
    
   public void setVisible(){
   historyFrame.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "REGRESAR":
                historyFrame.setVisible(false);
                menuFrame.setVisible(true);
                break;
        }
       
    }
    
}
