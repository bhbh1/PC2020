/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej8;

import Utiles.IO;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class Caja {

    private ReentrantLock lockCaja = new ReentrantLock();
    private Condition excedePeso = lockCaja.newCondition();
    private int pesoActual = 0;
    private int pesoMaximo;

    public Caja(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    //Mover a clase Brazo
    public void retirarCaja() throws InterruptedException {
        try {
            lockCaja.lock();
        } finally {
            IO.sCol(5, 0, "Se retira la caja");
            reponerCaja();
        }
    }

    public void reponerCaja() throws InterruptedException {
        try {
            pesoActual = 0;
            IO.sCol(5, 0, "Se repone una caja");
            Thread.sleep(2000);
        } finally {
            excedePeso.signal();
            lockCaja.unlock();

        }

    }

    public void soltarPastel(int idE, int peso)
            throws InterruptedException {
        try {
            lockCaja.lock();
            if (pesoActual + peso > pesoMaximo) {
                retirarCaja();
                while (pesoActual != 0) {
                    excedePeso.await();
                }
            }
        } finally {
            pesoActual += peso;
            IO.sColM(6, idE, "Suelta en caja: " + peso + "kg"
                    + ". PesoAct: " + pesoActual, '>');
            lockCaja.unlock();
        }
    }

}
