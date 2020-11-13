/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import java.util.logging.Level;

/**
 *
 * @author b h
 */
public class Medidor implements Runnable {

    private GestorSala sala;

    public Medidor(GestorSala sala) {
        this.sala = sala;
    }

    @Override
    public void run() {
        int temp = 27;
        int nAleatorio;
        while (true) {
            nAleatorio = (int) (Math.random() * 10);
            try {

                if (nAleatorio <= 8) {
                    temp++;
                } 
//                else if (nAleatorio > 9) {
//                    temp--;
//                }
                sala.notificarTemperatura(temp);
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
