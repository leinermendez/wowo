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

    //    visibles 0= camino  4= trampa enemiga
   //     invisibles 1= pared(directamente no se pinta) 2= bloqueo  3=trampa veneno 5= agujero 8=meta
    //9= personaje
    
    int laberinto3[][]
            = {
                {0, 0, 0, 7, 0, 4, 0, 0, 7, 0, 0, 0, 0, 4, 8},
                {0, 1, 0, 1, 0, 1, 0, 1, 5, 1, 0, 1, 3, 1, 0},
                {0, 0, 0, 2, 0, 2, 0, 0, 0, 4, 0, 7, 0, 2, 0},
                {5, 1, 3, 1, 0, 1, 5, 1, 0, 1, 2, 1, 0, 1, 0},
                {0, 7, 0, 5, 0, 4, 0, 3, 0, 2, 0, 4, 0, 4, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 5, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 2, 0},
                {0, 1, 0, 1, 5, 1, 0, 1, 0, 1, 2, 1, 0, 1, 0},
                {0, 2, 0, 4, 0, 0, 0, 5, 0, 4, 0, 0, 0, 2, 0},
                {0, 1, 2, 1, 0, 1, 1, 1, 5, 1, 0, 1, 5, 1, 0},
                {0, 7, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
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

    public boolean esPoisonTrap(int x, int y) {
        if (laberinto3[y][x] == 3 ||laberinto3[y][x] == 23 ) {
            System.out.println("Poison!");//confirma que el metodo se ejecuto
            return true;
        }
        return false;
    }
    
      public boolean esFake(int x, int y) {
        if (laberinto3[y][x] == 7 ) {
            System.out.println("FAKE!");//confirma que el metodo se ejecuto
            return true;
        }
        return false;
    }
      public boolean esTrampaEnemiga(int x, int y) {
        if (laberinto3[y][x] == 4 ) {
            System.out.println("TRAP!");//confirma que el metodo se ejecuto
            return true;
        }
        return false;
    }
    
    public boolean esInvisible(int x, int y) {
        if (laberinto3[y][x] == 2 ) {
              System.out.println("BLOQUEO!");//confirma que el metodo se ejecuto
             return false;
        }
            return true;
    }
    
    
    
    public boolean esMeta(int x, int y) {
        if (laberinto3[y][x] == 8) {
            return true;
        } else {
            return false;
        }

    }

}
