/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej2;

import tp3.VerificarCuenta;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Personaje pj = new Personaje();
        Orco orco = new Orco(pj);
        Curandero curandero = new Curandero(pj);
        Thread hilo1 = new Thread(orco);
        Thread hilo2 = new Thread(curandero);
        hilo1.start();
        hilo2.start();
    }
}
