/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.model;

/**
 *
 * @author RYZEN
 */
public class Matriz3 {
     
          //    0= camino 1= pared 3=trampa veneno 4= trampa enemiga 5= agujero 6= caja 8=meta
     int[][] laberinto3 = {
    {0, 0, 0, 7, 0, 4, 0, 0, 7, 0, 0, 6, 0, 4, 8},
    {0, 1, 0, 1, 0, 1, 0, 1, 5, 1, 0, 1, 3, 1, 0},
    {0, 0, 0, 2, 6, 2, 0, 0, 0, 4, 0, 7, 0, 2, 0},
    {5, 1, 3, 1, 0, 1, 5, 1, 0, 1, 2, 1, 0, 1, 0},
    {0, 7, 0, 5, 0, 4, 0, 3, 0, 2, 0, 4, 0, 4, 0},
    {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
    {0, 5, 0, 0, 0, 1, 0, 6, 0, 3, 0, 0, 0, 2, 0},
    {6, 1, 0, 1, 5, 1, 0, 1, 0, 1, 2, 1, 0, 1, 0},
    {0, 2, 0, 4, 0, 0, 0, 5, 0, 4, 0, 0, 0, 2, 0},
    {0, 1, 2, 1, 0, 1, 1, 1, 5, 1, 0, 1, 5, 1, 0},
    {0, 7, 6, 0, 0, 0, 0, 4, 6, 0, 0, 0, 6, 0, 0},
    {0, 1, 5, 7, 2, 1, 2, 1, 0, 1, 0, 1, 0, 1, 5},
    {0, 4, 0, 0, 0, 7, 0, 0, 0, 4, 0, 3, 0, 7, 0},
    {0, 1, 0, 1, 3, 1, 5, 1, 2, 1, 2, 1, 0, 1, 0},
    {0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
};
        
   public int[][] obtenerLaberinto() {
        return laberinto3;
    }
   
    public boolean esCeldaLibre(int x, int y) {// Verifica si la celda está libre
        return laberinto3[y][x] == 0;
    }
   
    public boolean esMeta(int x, int y) {
        if (laberinto3[y][x] == 8) {
            return true;
        } else {
            return false;
        }

    }
    
}
