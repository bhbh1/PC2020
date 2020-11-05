/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferFinito;

import Utiles.IO;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class EspacioCompartido {

    private Recurso[] buffer;
    Semaphore semProd;
    Semaphore semCons;
    //Indica si esta lleno o vacio
    Semaphore semBuffer;

    public EspacioCompartido() {
        //Puede contener 10 elementos
        this.buffer = new Recurso[10];
        for (int i = 0; i < 10; i++) {
            this.buffer[i] = new Recurso();
        }
        this.semProd = new Semaphore(10);
        this.semCons = new Semaphore(0);
        this.semBuffer = new Semaphore(1);
    }

    public boolean producir(int id) throws InterruptedException {
        short pos = (short) (Math.random() * 10);
        boolean esValido = false;
        try {
            semProd.acquire();
            Semaphore semPos = this.buffer[pos].getSem();
            esValido = semPos.tryAcquire();
            if (esValido) {
                this.buffer[pos].setDato(id);
                IO.sColE(1, id, "Puso: " + id + " en " + pos + "\t" + this.toString(pos));
            }
        } finally {
            if (esValido) {
                semCons.release();
            }else{
                semProd.release();
            }
        }

        return true;
    }

    public boolean consumir(int id) throws InterruptedException {
        short pos = (short) (Math.random() * 10);
        Recurso rec;
        int dato;
        boolean esValido = false;
        Semaphore semPos = this.buffer[pos].getSem();
        try {
            //consume recurso en posicion aleatoria
            rec = this.buffer[pos];
            semCons.acquire();
            dato = rec.getDato();
            if (dato > -1) {
                esValido = true;

                IO.sColE(0, id, "Saco: " + dato + " de " + pos + "\t" + this.toString(pos));
                rec.setDato(-2);
            } else {
                //No consume porque hay vacio
//                IO.sColE(0, id, "Deja: " + dato + " en " + pos + "\t" + this.toString(pos));
            }
        } finally {
            semPos.release();
            semProd.release();
            semCons.release();
        }

        return esValido;
    }

    public String toString(int pos) {
        String s = "";
        int dato;
        for (int i = 0; i < 10; i++) {
            dato = this.buffer[i].getDato();
            if (dato < 0) {
                switch (dato) {
                    case -1:
                        s += " - ";
                        break;
                    case -2:
                        if (i == pos) {
                            s += "[X]";
                        } else {
                            s += " X ";
                        }
                        break;
                }
            } else {
                if (i == pos) {
                    s += "[" + dato + "]";
                } else {
                    s += " " + dato + " ";
                }
            }

            if (i < 10 - 1) {
                s += ", ";
            }
        }
        return s;
    }

}
