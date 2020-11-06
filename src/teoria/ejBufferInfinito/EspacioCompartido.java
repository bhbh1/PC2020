/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferInfinito;

import Utiles.IO;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class EspacioCompartido {

    private LinkedList buffer;
    private int inicio;
    private int fin;
    Semaphore semProd;
    Semaphore semCons;
    //Indica si esta lleno o vacio
    Semaphore semBuffer;

    public EspacioCompartido() {
        //Puede contener 10 elementos
        this.buffer = new LinkedList();
        this.semProd = new Semaphore(10);
        this.semCons = new Semaphore(0);
        this.semBuffer = new Semaphore(1);
    }

    public void producir(int id, Integer recurso) throws InterruptedException {
        try {
            semProd.acquire();
            buffer.add(recurso);
            IO.sColE(1, id, "Puso: " + recurso + "\t" + buffer.toString());
        } finally {
            semCons.release();
        }
    }

    public void consumir(int id) throws InterruptedException {
        boolean suceso = false;
        short n = (short) (Math.random() * 10);
        String s = "";
        try {
            //consume recurso en posicion aleatoria
            if (semCons.tryAcquire()) {
                s = " "+IO.colMsg(0, id, true)+ "Saco: ";
                if (n < 5) {
                    s += buffer.removeFirst();
                } else {
                    s += buffer.removeLast();
                }
                s += "\t" + buffer.toString();
                suceso = true;
            }
        } finally {
            if (suceso) {
                System.out.println(s);
                semProd.release();
            }
        }
    }

}
