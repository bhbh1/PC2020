/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferFinito;

import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class Recurso {

    private int dato;
    private Semaphore sem;

    public Recurso() {
        this.dato = -2;
        this.sem = new Semaphore(1);
    }

    public Semaphore getSem() {
        return sem;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

}
