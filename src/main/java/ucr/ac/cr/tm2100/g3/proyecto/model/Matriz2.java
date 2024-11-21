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
public class Matriz2 {

    boolean open = false;
    int laberinto2[][]
            // 0= camino 1= pared  2=puerta 3= llave 4,6 = nenufar meta=8 pj=9

            = {
                /*LINEA SUPERIOR 0*/{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                /*fila 1*/ {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                /*fila 2*/ {9, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                /*fila 3*/ {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                /*fila 4*/ {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                /*fila 5*/ {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                /*fila 6*/ {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                /*fila 7*/ {1, 0, 0, 0, 0, 1, 0, 1, 6, 0, 1, 0, 0, 0, 0, 1},
                /*fila 8*/ {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                /*fila 9*/ {1, 0, 0, 1, 4, 0, 0, 1, 1,/* 2*/ 0, 1, 0, 1, 1, 0, 1},
                /*fila 10*/ {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                /*fila 11*/ {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1},
                /*fila 12*/ {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                /*fila 13*/ {1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
                /*fila 14*/ {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                /*fila 15*/ {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1}
            };

    public int[][] obtenerLaberinto() { // Devuelve el laberinto
        return laberinto2;
    }

    public boolean esCeldaLibre(int x, int y) {// Verifica si la celda está libre
        return laberinto2[y][x] == 0;
    }

    public boolean esLlave(int x, int y) { // Verifica si la celda es la llave 
        if (laberinto2[x][y] == 3) {
            open = true;
            System.out.println("OPEN");
            return true;
        } else {
            return false;
        }
    }


    public boolean esCajon(int x, int y) {

        return laberinto2[y][x] == 2 && open;
    }
//     ---------------------------------------------------------- CREA LOS SALTOS DE LOS NENUFARES
    public boolean esNenufar1(int x, int y) {
        if (laberinto2[y][x] == 4  ) {
           System.out.println("Nenufar!");//confirma que el metodo se ejecuto
           
           
            return true;
        }
        return false;
    }
public boolean esNenufar2(int x, int y) {
        if (laberinto2[y][x] == 6 ) {
           System.out.println("Nenufar!");//confirma que el metodo se ejecuto
           
           
            return true;
        }
        return false;
    }

    public boolean esMeta(int x, int y) {

        if (laberinto2[y][x] == 8) {
            JOptionPane.showMessageDialog(null, "Nivel completado!");
            return true;

        } else {
            return false;
        }

    }

}
