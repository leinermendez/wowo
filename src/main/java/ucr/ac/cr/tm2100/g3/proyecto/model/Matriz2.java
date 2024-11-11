/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.model;

/**
 *
 * @author RYZEN
 */
public class Matriz2 {

    public int[][] obtenerLaberinto() {

        int laberinto2[][]
                // 0= camino 1= pared  2=puerta 3= llave 4,5,6,7 = nenufar
                

                = {
                    /*LINEA SUPERIOR 0*/{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    /*fila 1*/ {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                    /*fila 2*/ {0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                    /*fila 3*/ {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                    /*fila 4*/ {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                    /*fila 5*/ {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 7, 0, 0, 0, 0, 1},
                    /*fila 6*/ {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                    /*fila 7*/ {1, 0, 0, 0, 0, 1, 0, 1, 6, 0, 1, 0, 0, 0, 0, 1},
                    /*fila 8*/ {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                    /*fila 9*/ {1, 0, 0, 1, 4, 0, 0, 1, 1, 2, 1, 0, 1, 1, 0, 1},
                    /*fila 10*/ {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                    /*fila 11*/ {1, 0, 1, 5, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1},
                    /*fila 12*/ {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                    /*fila 13*/ {1, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
                    /*fila 14*/ {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                    /*fila 15*/ {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}
                };
        return laberinto2;

    }
}
