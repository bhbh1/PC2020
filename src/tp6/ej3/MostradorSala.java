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
public class MostradorSala {

    public ReentrantLock lockSala = new ReentrantLock();
    public Condition haySalas = lockSala.newCondition();
    public Condition hayAbridores = lockSala.newCondition();
    public int cantMostradoresDisp = 5;
    public int cantAbridoresDisp = 10;

    public void obtenerBandeja(int id) throws InterruptedException {
        try {
            lockSala.lock();
            while (cantMostradoresDisp < 1) {
                haySalas.await();
            }
            IO.sCol(id, "Obtiene bandeja");
            cantMostradoresDisp--;
        } finally {
            lockSala.unlock();
        }
    }

    public void salir(int id) throws InterruptedException {
        try {
            lockSala.lock();
            IO.sCol(id, "Suelta bandeja");
            cantMostradoresDisp++;
            haySalas.signalAll();
        } finally {
            lockSala.unlock();
        }
    }

    public void obtenerAbridor(int id) throws InterruptedException {
        try {
            lockSala.lock();

            while (cantAbridoresDisp < 1) {
                hayAbridores.await();
            }
            IO.sCol(id, "Obtiene abridor");
            cantAbridoresDisp--;
        } finally {
            lockSala.unlock();
        }
    }

    public void soltarAbridor(int id) throws InterruptedException {
        try {
            lockSala.lock();
            IO.sCol(id, "Suelta abridor");
            cantAbridoresDisp++;
            hayAbridores.signalAll(); 
        } finally {
            lockSala.unlock();
        }
    }

}
