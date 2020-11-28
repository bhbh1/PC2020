/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b h
 */
public class Encargado implements Runnable {

    private Comedor comedor;

    public Encargado(Comedor comedor) {
        this.comedor = comedor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                comedor.dormir();
                comedor.rellenarPlatos();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
