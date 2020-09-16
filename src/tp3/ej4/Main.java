/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej4;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        int cant = 2;
        Surtidor surt = new Surtidor();
        Auto[] autos = new Auto[cant];
        for (int i = 0; i < cant; i++) {
            autos[i] = new Auto("p" + i, "mod" + i, "mar" + i, 199, surt);
        }

        Thread[] hilos = new Thread[cant];
        for (int i = 0; i < cant; i++) {
            hilos[i] = new Thread(autos[i]);
            hilos[i].start();
        }
    }

}
