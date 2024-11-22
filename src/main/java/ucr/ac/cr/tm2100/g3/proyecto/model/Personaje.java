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
    private int vidas;

    public Personaje(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public Personaje(int startX, int startY, int startVidas) {
        this.x = startX;
        this.y = startY;
        this.vidas= startVidas;
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
    
    public void restarVidas(int vidas){
    this.vidas =vidas-1;
    }
    
    public int getVidasRestantes(){
    return vidas;
    }
    
    
    
}
