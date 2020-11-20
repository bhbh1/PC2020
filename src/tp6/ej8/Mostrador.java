/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej8;

import Utiles.IO;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class Mostrador {

    private LinkedList mostrador = new LinkedList();
    private int espacioDisp = 12;

    public synchronized void poner(int tipo, int idE, int peso)
            throws InterruptedException {
        while (espacioDisp < 1) {
//            IO.sColE(tipo, idE, "Espera lugar p/poner" + "\t" + this.mostrador.toString());
            this.wait();
        }

        mostrador.add(peso);
//        IO.sColM(tipo, idE, "Puso en el mostrador: " + peso + "kg", '>');

        espacioDisp--;
        this.notifyAll();
    }

    public synchronized int tomarPastel(int idE) throws InterruptedException {
        int peso;
        while (espacioDisp > 9) {
//            IO.sColE(0, idE, "Espera que haya p/sacar");
            this.wait();
        }

        peso = (int) (mostrador.remove());
        IO.sColM(6, idE, "Toma del mostrador: " + peso + "kg", '<');

        espacioDisp++;
        this.notifyAll();
        return peso;
    }
}
