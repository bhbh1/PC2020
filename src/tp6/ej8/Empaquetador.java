/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b h
 */
public class Empaquetador implements Runnable {

    private int id;
    private Mostrador mostrador;
    private Caja caja;

    public Empaquetador(int id, Mostrador mostrador, Caja caja) {
        this.id = id;
        this.mostrador = mostrador;
        this.caja = caja;
    }

    @Override
    public void run() {
        try {
            do{
                manejarPastel();
            }while(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void manejarPastel() throws InterruptedException{
        int peso = mostrador.tomarPastel(id);
        caja.soltarPastel(id, peso);
    }
}
