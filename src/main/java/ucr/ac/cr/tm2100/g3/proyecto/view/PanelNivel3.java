/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz1;
import ucr.ac.cr.tm2100.g3.proyecto.model.Matriz3;
import ucr.ac.cr.tm2100.g3.proyecto.model.Personaje;

/**
 *
 * @author RYZEN
 */
public class PanelNivel3 extends javax.swing.JPanel {

    Matriz3 level3 = new Matriz3();
    private int[][] laberinto = level3.obtenerLaberinto();
    private int tammax, tam, can, res;

    public PanelNivel3(int tammax, int can) {
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax / can;
        this.res = tammax % can;
        initComponents();
    }

    @Override
    public void paint(Graphics g) {

        Image camino3 = new ImageIcon("./src/main/resources/img/camino3.png").getImage();
        Image letalTrap = new ImageIcon("./src/main/resources/img/poisonTrap.png").getImage();
        Image trampaEnemigo = new ImageIcon("./src/main/resources/img/trampaEnemigo.png").getImage();
        Image hoyo = new ImageIcon("./src/main/resources/img/hoyo.png").getImage();
        Image box = new ImageIcon("./src/main/resources/img/box.png").getImage();
        Image bloqueoInvisible = new ImageIcon("./src/main/resources/img/bloqueo.png").getImage();
        Image plantaFondo = new ImageIcon("./src/main/resources/img/plantaFondo.png").getImage();
        Image planta = new ImageIcon("./src/main/resources/img/planta.png").getImage();
        super.paintComponent(g);

        g.drawImage(plantaFondo, 0, 0, null);

        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {

                if (laberinto[i][j] == 7) {
                    g.drawImage(camino3, res / 2 + j * tam, res / 2 + i * tam, null);
                }

                Image img = null;

                //    0= camino 3=trampa veneno 4= trampa enemiga 5= agujero 6= caja           
                switch (laberinto[i][j]) {
                    case 0 ->
                        img = camino3;
                    case 2 ->
                        img = bloqueoInvisible;
                    case 3 ->
                        img = letalTrap;
                    case 4 ->
                        img = trampaEnemigo;
                    case 5 ->
                        img = hoyo;
                    case 6 ->
                        img = box;

                    case 7 ->
                        img = planta;
                }

                if (img != null) {
                    g.drawImage(img, res / 2 + j * tam, res / 2 + i * tam, null);
                }
            }

        }

    }

    public void cambiarMatriz(int x, int y) {
        laberinto[x][y] = 0;
    }

    
    public void moverPersonaje(Personaje pj) {
        // Variables actuales del personaje
        int x = pj.getX();
        int y = pj.getY();
        int xHole;
        int yHole;

        // Determinar el movimiento basado en la posición actual
        switch (laberinto[y][x]) {
            case 4: // Nenúfar 1 al Nenúfar 2
                x = 3;
                y = 11;
                xHole = 4;
                yHole = 9;
                System.out.println("esNenufar1!");
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                laberinto[9][5]=0;
                 laberinto[11][3]=9;
                laberinto[yHole][xHole] = 0;

                // Actualizar visualización
                repaint();
                break;

            case 6: // Nenúfar 2
                x = 10;
                y = 5;
                xHole = 8;
                yHole = 7;
                System.out.println("esNenufar2!");
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                 laberinto[7][9]=0;
                 laberinto[5][10]=9;
                laberinto[yHole][xHole] = 0;

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
