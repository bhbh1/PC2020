/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b h
 */
public class Agente implements Runnable {

    private SalaFumadores sala;
    private Random r;

    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }

    public void run() {
        while (true) {
            sala.colocar(r.nextInt(3) + 1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
    }// run
}//clase
