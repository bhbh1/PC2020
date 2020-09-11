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
public class Curandero extends Personaje implements Runnable {

    private Personaje pj;

    public Curandero(Personaje pj) {
        this.vida = 8;
        this.maxVida = this.vida;
        this.pj = pj;
    }

    @Override
    public void run() {
        synchronized (pj) {
            System.out.println("Inicio curandero");
            int vida = pj.getVida();
            System.out.println("Vida c: "+pj.getVida());
            vida = vida + 3;
            pj.setVida(vida);
            System.out.println("Vida c: "+pj.getVida());
        }
        System.out.println("Fin curandero");
    }

}
