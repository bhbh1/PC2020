/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej3;

import Utiles.IO;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class MostradorPostre {

    public ReentrantLock lockSala = new ReentrantLock();
    public Condition haySalas = lockSala.newCondition();
    public int cantMostradoresDisp = 3;

    public void obtenerPostre(int id) throws InterruptedException {
        try {
            lockSala.lock();
            while (cantMostradoresDisp < 1) {
                haySalas.await();
            }
            IO.sCol(id, "Obtiene postre");
            cantMostradoresDisp--;
        } finally {
            lockSala.unlock();
        }
    }

    public void soltarPostre(int id) throws InterruptedException {
        try {
            lockSala.lock();
            IO.sCol(id, "Termina postre");
            cantMostradoresDisp++;
            haySalas.signalAll();
        } finally {
            lockSala.unlock();
        }
    }
}
