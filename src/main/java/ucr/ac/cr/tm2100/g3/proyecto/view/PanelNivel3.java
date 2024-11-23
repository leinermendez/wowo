/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private Personaje pj;
    private JButton btnCuidado;

    public PanelNivel3(int tammax, int can, int[][] matriz) {
        this.tammax = tammax;
        // Limitar can al tamaño real del laberinto
        this.can = Math.min(can, laberinto.length);
        this.tam = tammax / this.can;
        this.res = tammax % this.can;
        initComponents();

    }

    @Override
    public void paint(Graphics g) {

        Image pj = new ImageIcon("./src/main/resources/img/spriteStand.png").getImage();
        Image poisoned = new ImageIcon("./src/main/resources/img/spritePoisoned.png").getImage();
        Image camino3 = new ImageIcon("./src/main/resources/img/camino3.png").getImage();
        Image poisonTrap = new ImageIcon("./src/main/resources/img/poisonTrap.png").getImage();
        Image trampaEnemigo = new ImageIcon("./src/main/resources/img/trampaEnemigo.png").getImage();
        Image trapperAwake = new ImageIcon("./src/main/resources/img/trapperAwake.png").getImage();
        Image hoyo = new ImageIcon("./src/main/resources/img/hoyo.png").getImage();
        Image box = new ImageIcon("./src/main/resources/img/box.png").getImage();
        Image bloqueoInvisible = new ImageIcon("./src/main/resources/img/bloqueo.png").getImage();
        Image plantaFondo = new ImageIcon("./src/main/resources/img/plantaFondo.png").getImage();
        Image planta = new ImageIcon("./src/main/resources/img/planta.png").getImage();
        super.paintComponent(g);

        g.drawImage(plantaFondo, 0, 0, null);

        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {

                if (laberinto[i][j] == 7 || laberinto[i][j] == 9 || laberinto[i][j] == 3 || laberinto[i][j] == 23) {
                    g.drawImage(camino3, res / 2 + j * tam, res / 2 + i * tam, null);
                }

                Image img = null;

                //   Visible (2)(numero de elemento de matriz) = 21 por ejemplo
                // invisible ()numero de matriz
                //    visibles 0= camino  4= trampa enemiga  6= caja 22= bloqueo 23=trampa veneno 25= agujero
                //     invisibles 1= pared(directamente no se pinta) 2= bloqueo  3=trampa veneno 5= agujero 8=meta 
                // los objetos invisibles se pintan como camino3
                switch (laberinto[i][j]) {

                    case 0 -> //camino
                        img = camino3;

                    case 2 ->   //bloqueo invisibles
                        img = camino3;
                    case 22 ->
                        img = bloqueoInvisible;

                    case 3 -> //trampas de veneno
                        img = poisonTrap;
                    case 23 ->
                        img = poisoned;

                    case 4 -> //trampa enemigo
                        img = trampaEnemigo;

                    case 24 -> //trampa enemigo
                        img = trapperAwake;

                    case 5 -> //trampas de agujero
                        img = camino3;
                    case 25 ->
                        img = hoyo;

                    case 6 ->
                        img = camino3;

                    case 7 ->
                        img = planta;

                    case 8 ->
                        img = camino3;

                    case 9 ->
                        img = pj;

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

    public void moverPersonajeTP(Personaje pj) {
        // Variables actuales del personaje
        int x = pj.getX();
        int y = pj.getY();

        // Determinar el movimiento basado en la posición actual
        switch (laberinto[y][x]) {
            case 5: // hoyo
                laberinto[pj.getY()][pj.getX()] = 25; //convierte la casilla a visible
                x = 0;
                y = 2;
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                // Limpiar posición anterior
                for (int i = 0; i < can; i++) {
                    for (int j = 0; j < can; j++) {
                        if (laberinto[i][j] == 9) {
                            laberinto[i][j] = 0; // Regresar a camino
                        }
                    }
                }
                laberinto[2][0] = 9; //muestra la nueva posicion
                // Actualizar visualización
                repaint();
                break;

            case 25:

                x = 0;
                y = 2;
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                // Limpiar posición anterior
                for (int i = 0; i < can; i++) {
                    for (int j = 0; j < can; j++) {
                        if (laberinto[i][j] == 9) {
                            laberinto[i][j] = 0; // Regresar a camino
                        }
                    }
                }
                laberinto[2][0] = 9; //muestra la nueva posicion
                // Actualizar visualización
                repaint();
        }
    }

    public void restarVida(Personaje pj) {

        // Variables actuales del personaje
        int x = pj.getX();
        int y = pj.getY();
        int vidas = pj.getVidasRestantes();

        switch (laberinto[y][x]) {
            case 3: // trampa
                laberinto[pj.getY()][pj.getX()] = 23; //convierte la casilla a visible
                x = 0;
                y = 2;
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                pj.restarVidas(vidas);
                System.out.println("vidas restantes: " + vidas);
                // Limpiar posición anterior
                for (int i = 0; i < can; i++) {
                    for (int j = 0; j < can; j++) {
                        if (laberinto[i][j] == 9) {
                            laberinto[i][j] = 0; // Regresar a camino
                        }
                    }
                }
                laberinto[2][0] = 9; //muestra la nueva posicion
                // Actualizar visualización

                repaint();
                break;

            case 23:

                x = 0;
                y = 2;
                // Actualizar posición del personaje
                pj.setX(x);
                pj.setY(y);
                pj.restarVidas(vidas);
                System.out.println("vidas restantes: " + vidas);
                // Limpiar posición anterior
                for (int i = 0; i < can; i++) {
                    for (int j = 0; j < can; j++) {
                        if (laberinto[i][j] == 9) {
                            laberinto[i][j] = 0; // Regresar a camino
                        }
                    }
                }

                laberinto[y][x] = 9; //muestra la nueva posicion
                // Actualizar visualización
                repaint();
        }
    }

    public void trapperAwake(int x, int y, Personaje pj) {

        // Limpiar posición anterior
        for (int i = 0; i < can; i++) {
            for (int j = 0; j < can; j++) {
                if (laberinto[i][j] == 9) {
                    laberinto[i][j] = 0; // Regresar a camino
                }
            }
        }
        // Actualizar la nueva posición
        laberinto[y][x] = 24;

        repaint();
    }

    public boolean conVida(Personaje pj) {
        if (pj.getVidasRestantes() == 0) {
            System.out.println("NO QUEDAN VIDAS");
            return false;
        } else {
            return true;
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
