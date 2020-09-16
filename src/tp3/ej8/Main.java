/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej8;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cant = 2;
        Rueda rueda = new Rueda();
        Plato plato = new Plato();
        Hamaca hamaca = new Hamaca();
        
        Hamster[] hamsters = new Hamster[cant];
        for (int i = 0; i < cant; i++) {
            hamsters[i] = new Hamster("Hamster " + i, rueda, plato, hamaca);
        }

        Thread[] hilos = new Thread[cant];
        for (int i = 0; i < cant; i++) {
            hilos[i] = new Thread(hamsters[i]);
            hilos[i].start();
        }
    }
}
