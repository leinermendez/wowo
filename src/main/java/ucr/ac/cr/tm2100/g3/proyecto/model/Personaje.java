/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.proyecto.model;

/**
 *
 * @author RYZEN
 */
public class Personaje {
    private int x, y;
    private int vidas = 5;

    public Personaje(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }
    
   public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
}
