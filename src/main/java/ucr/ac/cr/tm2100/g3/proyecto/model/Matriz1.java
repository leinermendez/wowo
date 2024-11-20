/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.model;

import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class Matriz1 {

    boolean open = false;
    int laberinto1[][]
            = {
                //    0= camino 1= pared   2=cajon  3=llave   4= meta
                /*LINEA SUPERIOR 0*/{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                /*fila 1*/ {1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                /*fila 2*/ {9, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                /*fila 3*/ {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 2, 4},
                /*fila 4*/ {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                /*fila 5*/ {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                /*fila 6*/ {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                /*fila 7*/ {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                /*fila 8*/ {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                /*fila 9*/ {1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                /*fila 10*/ {1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                /*fila 11*/ {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1},
                /*fila 12*/ {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                /*fila 13*/ {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                /*fila 14*/ {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 1},
                /*FILA INFERIOR 15*/ {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    public int[][] obtenerLaberinto() { // Devuelve el laberinto
        return laberinto1;
    }

    public boolean esCeldaLibre(int x, int y) {// Verifica si la celda está libre
        return laberinto1[y][x] == 0;
    }

    public boolean esLlave(int x, int y) { // Verifica si la celda es la llave 
        if (laberinto1[x][y] == 3) {
            open = true;
            System.out.println("OPEN");
            return true;
        } else {
            return false;
        }
    }

    public boolean esCajon(int x, int y) {
        // Verifica si la celda es cajon
        return laberinto1[y][x] == 2 && open;
    }

    public boolean esMeta(int x, int y) {

        if (laberinto1[y][x] == 4) {
            JOptionPane.showMessageDialog(null, "Nivel completado!");
            return true;
            
        } else {
            return false;
        }

    }
}
