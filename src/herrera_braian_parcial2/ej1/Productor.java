/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej1;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class Productor implements Runnable {

    private int tipo;
    private Fabrica fabrica;

    public Productor(int tipo, Fabrica fabrica) {
        this.tipo = tipo;
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
            for (int i = 0; i < 60; i++) {
                fabrica.almacenar(tipo);
                if (tipo == 4) {
                    Thread.sleep(150);
                } else {
                    Thread.sleep(400);
                }
            }
            IO.sColC(tipo, tipo, "Fin productor");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
