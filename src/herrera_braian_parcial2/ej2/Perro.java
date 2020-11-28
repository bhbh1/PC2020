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
public class Perro implements Runnable {

    private int id;
    private Comedor comedor;

    public Perro(int id, Comedor comedor) {
        this.id = id;
        this.comedor = comedor;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 100));
            comedor.comer(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
