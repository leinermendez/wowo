/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz1;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz2;

/**
 *
 * @author RYZEN
 */
public class PanelNivel2 extends javax.swing.JPanel {

    Matriz2 level2 = new Matriz2();
    private int[][] laberinto = level2.obtenerLaberinto();
    private int tammax, tam, can, res;

    public PanelNivel2(int tammax, int can) {
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
        initComponents();
    }

    @Override
    public void paint(Graphics g) {

        Image camino = new ImageIcon("./src/main/resources/img/camino2.png").getImage();
        Image puerta = new ImageIcon("./src/main/resources/img/puerta.png").getImage();
        Image llave = new ImageIcon("./src/main/resources/img/llave.png").getImage();
        Image nenufar = new ImageIcon("./src/main/resources/img/nenufar.png").getImage();
        Image fondoAgua = new ImageIcon("./src/main/resources/img/fondoAgua.png").getImage();
        Image flores = new ImageIcon("./src/main/resources/img/flores.png").getImage();

        super.paintComponent(g);

        g.drawImage(fondoAgua, 0, 0, null);

        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {

                if (laberinto[i][j] == 2 || laberinto[i][j] == 3) {
                    g.drawImage(camino, res / 2 + j * tam, res / 2 + i * tam, null);
                }

                Image img = null;
// 0= camino 1= pared  2=puerta 3= llave 4=nenufar
                switch (laberinto[i][j]) {
                    case 0 ->
                        img = camino;
                    case 2 ->
                        img = puerta;
                    case 3 ->
                        img = llave;
                    case 4 ->
                        img = nenufar;
                    case 5 ->
                        img = nenufar;
                    case 6 ->
                        img = nenufar;
                    case 7 ->
                        img = nenufar;

                }
                if (img != null) {
                    g.drawImage(img, res / 2 + j * tam, res / 2 + i * tam, null);
                }
            }
        }
        g.drawImage(flores, 0, 0, null);
    }

    public void cambiarMatriz(int x, int y) {
        laberinto[x][y] = 0;
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
