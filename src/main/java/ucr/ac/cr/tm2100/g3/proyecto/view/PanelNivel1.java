/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz1;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;

/**
 *
 * @author RYZEN
 */
public class PanelNivel1 extends javax.swing.JPanel {

    Matriz1 level1 = new Matriz1();
    private int[][] laberinto;
    private int tammax, tam, can, res;
    private Personaje pj;

    public PanelNivel1(int tammax, int can, int[][] matriz) {
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
        laberinto = matriz;
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        Image pj = new ImageIcon("./src/main/resources/img/spriteStand.png").getImage();
        Image meta1 = new ImageIcon("./src/main/resources/img/meta1.png").getImage();
        Image image = new ImageIcon("./src/main/resources/img/camino1.png").getImage();
        Image camino1 = new ImageIcon("./src/main/resources/img/camino1.png").getImage();
        Image pared1 = new ImageIcon("./src/main/resources/img/pared1.png").getImage();
        Image puerta = new ImageIcon("./src/main/resources/img/puerta.png").getImage();
        Image llave = new ImageIcon("./src/main/resources/img/llave.png").getImage();

        super.paintComponent(g);

        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {

                if (laberinto[i][j] == 2 || laberinto[i][j] == 3 ||  laberinto[i][j] == 9 ||  laberinto[i][j] == 4) {
                    g.drawImage(image, res / 2 + j * tam, res / 2 + i * tam, null);
                }

                Image img = null;
// 0= camino 1= pared 
                switch (laberinto[i][j]) {
                    case 0 ->
                        img = camino1;
                    case 1 ->
                        img = pared1;
                    case 2 ->
                        img = puerta;
                    case 3 ->
                        img = llave;
                    case 9 ->
                        img = pj;
                          case 4 ->
                        img = meta1;
                        
                        

                }
                if (img != null) {
                    g.drawImage(img, res / 2 + j * tam, res / 2 + i * tam, null);
                }
            }
        }
    }

  

    public void actualizarPosicionPersonaje(int x, int y) {
        // Limpiar posición anterior
        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {
                if (laberinto[i][j] == 9) {
                    laberinto[i][j] = 0; // Regresar a camino
                }
            }
        }
        // Actualizar la nueva posición
        laberinto[y][x] = 9;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
