/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz2;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;

/**
 *
 * @author RYZEN
 */
public class PanelNivel2 extends javax.swing.JPanel {

    Matriz2 level2 = new Matriz2();
    private int[][] laberinto = level2.obtenerLaberinto();
    private int tammax, tam, can, res;
    private Personaje pj;

    public PanelNivel2(int tammax, int can, int[][] matriz) {
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
        initComponents();
    }

    @Override
    public void paint(Graphics g) {

        Image pj = new ImageIcon("./src/main/resources/img/spriteStand.png").getImage();
        Image camino = new ImageIcon("./src/main/resources/img/camino2.png").getImage();
        Image puerta = new ImageIcon("./src/main/resources/img/puerta.png").getImage();
        Image llave = new ImageIcon("./src/main/resources/img/llave.png").getImage();
        Image nenufar = new ImageIcon("./src/main/resources/img/nenufar.png").getImage();
        Image fondoAgua = new ImageIcon("./src/main/resources/img/fondoAgua.png").getImage();
        Image flores = new ImageIcon("./src/main/resources/img/flores.png").getImage();
        Image meta2 = new ImageIcon("./src/main/resources/img/meta2.png").getImage();

        super.paintComponent(g);

        g.drawImage(fondoAgua, 0, 0, null);

        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {

                if (laberinto[i][j] == 2 || laberinto[i][j] == 3 || laberinto[i][j] == 4 || laberinto[i][j] == 5 || laberinto[i][j] == 6 || laberinto[i][j] == 7 || laberinto[i][j] == 8 || laberinto[i][j] == 9) {
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
                    case 6 ->
                        img = nenufar;
                    case 8 ->
                        img = meta2;
                    case 9 ->
                        img = pj;

                }
                if (img != null) {
                    g.drawImage(img, res / 2 + j * tam, res / 2 + i * tam, null);
                }
            }
        }
        g.drawImage(flores, 0, 0, null);
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

    public void moverPersonaje(Personaje pj) {
        // Variables actuales del personaje
        int x = pj.getX();
        int y = pj.getY();
        int xNenufar;
        int yNenufar;

        // Determinar el movimiento basado en la posición actual
        switch (laberinto[y][x]) {
            case 4: // Nenúfar 1 al Nenúfar 2
                x = 3;
                y = 11;
                xNenufar = 4;
                yNenufar = 9;
                System.out.println("esNenufar1!");
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                laberinto[9][5]=0;
                 laberinto[11][3]=9;
                laberinto[yNenufar][xNenufar] = 0;

                // Actualizar visualización
                repaint();
                break;

            case 6: // Nenúfar 2
                x = 10;
                y = 5;
                xNenufar = 8;
                yNenufar = 7;
                System.out.println("esNenufar2!");
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                 laberinto[7][9]=0;
                 laberinto[5][10]=9;
                laberinto[yNenufar][xNenufar] = 0;

                // Actualizar visualización
                repaint();
                break;
        }
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
