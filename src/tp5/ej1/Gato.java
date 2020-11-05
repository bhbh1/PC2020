/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class Gato extends Animal implements Runnable {

    public Gato(int id, Manejador manejador, int tipo) {
        super(id, manejador, tipo);
    }

    @Override
    public void run() {
        try {
            this.buscarComedor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buscarComedor() throws InterruptedException {
       this.buscarComedor(true);
    }

}
