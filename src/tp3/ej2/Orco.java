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
public class Orco extends Personaje implements Runnable {

    private Personaje pj;

    public Orco(Personaje pj) {
        this.vida = 6;
        this.maxVida = this.vida;
        this.pj = pj;
    }

    @Override
    public void run() {
        this.golpear();
    }

    public void golpear() {
        synchronized (pj) {
            int vida = pj.getVida();
            System.out.println("Vida o: " + pj.getVida());
            vida = vida - 3;
            pj.setVida(vida);
            System.out.println("Vida o: " + pj.getVida());
        }
    }

}
