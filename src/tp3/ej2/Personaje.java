/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej2;

/**
 *
 * @author b h
 */
public class Personaje {

    protected int vida;
    protected int maxVida;

    public Personaje() {
        this.vida = 10;
        this.maxVida = this.vida;
    }

    public synchronized int getVida() {
        return vida;
    }

    public synchronized void setVida(int vida) {
        this.vida = vida;
    }

}
