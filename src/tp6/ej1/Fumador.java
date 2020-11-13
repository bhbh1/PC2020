/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej1;

import Utiles.IO;
import java.util.concurrent.locks.Condition;

/**
 *
 * @author b h
 */
public class Fumador implements Runnable {

    private int id;
    private SalaFumadores sala;

    public Fumador(int id, SalaFumadores sala) {
        this.id = id;
        this.sala = sala;
    }//constructor

    public void run() {
        try {
//            Thread.sleep(1000);
            while (true) {
                sala.entraFumar(id);
                IO.sColE(id, "Esta fumando");
                Thread.sleep(1000);
                sala.terminaFumar(id);

            }//while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run
}// clase
