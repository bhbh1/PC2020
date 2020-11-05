/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej1;

import Utiles.IO;
import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class Animal {

    protected int id;
    protected Manejador manejador;
    protected int tipo;
    protected boolean yaComio = false;

    public Animal(int id, Manejador manejador, int tipo) {
        this.id = id;
        this.manejador = manejador;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public void buscarComedor(boolean esGato) throws InterruptedException {
        Thread.sleep((int) (Math.random() * 200));
        Comedor c = manejador.buscarComedor(this, esGato);
        Semaphore sem = c.getSem(esGato);
        this.comer(c, sem, esGato);
    }

    protected void comer(Comedor c, Semaphore semComedor, boolean esGato)
            throws InterruptedException {
        try {
            IO.sColFijoP(tipo, id, "Está comiendo en: " + c.getId());
            this.yaComio = true;
            Thread.sleep(1200);
        } finally {
            c.salir(this, esGato);
        }
    }
}
